package jp.gr.java_conf.ange.angelmining.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;

import java.util.Set;

import javax.inject.Inject;

import jp.gr.java_conf.ange.angelmining.Constants;
import jp.gr.java_conf.ange.angelmining.MainActivity;
import jp.gr.java_conf.ange.angelmining.Manager;
import jp.gr.java_conf.ange.angelmining.R;
import jp.gr.java_conf.ange.angelmining.di.AngelminingApplication;
import jp.gr.java_conf.ange.angelmining.fragment.LoginMastodonInstanceFragment;
import jp.gr.java_conf.ange.angelmining.fragment.LoginMastodonResultFragment;
import jp.gr.java_conf.ange.angelmining.fragment.LoginMastodonStartFragment;
import jp.gr.java_conf.ange.angelmining.httpclient.MastodonAPIClient;
import jp.gr.java_conf.ange.angelmining.model.MastodonPreferences;
import jp.gr.java_conf.ange.mastodon.api.AppService;
import jp.gr.java_conf.ange.mastodon.model.AccessToken;
import jp.gr.java_conf.ange.mastodon.model.Register;
import okhttp3.HttpUrl;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Login Mastodon
 */
public class LoginMastodonActivity extends AppCompatActivity implements
        LoginMastodonStartFragment.LoginMastodonStartListener,
        LoginMastodonInstanceFragment.LoginMastodonInstanceListener,
        LoginMastodonResultFragment.LoginMastodonResultListener {

    private View contentView;

    @Inject
    LoginMastodonStartFragment loginStartFragment;

    @Inject
    LoginMastodonInstanceFragment loginInstanceFragment;

    @Inject
    LoginMastodonResultFragment loginResultFragment;

    @Inject
    Manager manager;

    @Inject
    SharedPreferences prefs;

    @Inject
    MastodonPreferences currentMastodonPrefs;

    @Inject
    MastodonAPIClient client;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mastodon);

        AngelminingApplication.getComponent(this).inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contentView = findViewById(R.id.content_login_mastodon);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if ( (!loginStartFragment.isAdded()) && (!loginInstanceFragment.isAdded()) && (!loginResultFragment.isAdded()) ) {
            startStartFragment();
        }

        // DEBUG
        String baseUrl = manager.getCurrentMastodon();
        if (!baseUrl.isEmpty()) {
            if (currentMastodonPrefs == null) {
                Log.d("CurrentMastodon", "create CurrentMastodonPrefs");
                currentMastodonPrefs = new MastodonPreferences(manager.getMastodonPrefs(getApplicationContext(), baseUrl));
            }
            Log.d("CurrentMastodon", "baseUrl=" + currentMastodonPrefs.getBaseUrl());
            Log.d("CurrentMastodon", "client_id=" + currentMastodonPrefs.getClientId());
            Log.d("CurrentMastodon", "client_secret=" + currentMastodonPrefs.getClientSecret());
            Log.d("CurrentMastodon", "code=" + currentMastodonPrefs.getCode());
            Log.d("CurrentMastodon", "redirect_uri=" + currentMastodonPrefs.getRedirectUri());
            Log.d("CurrentMastodon", "scope=" + currentMastodonPrefs.getScope());
            Log.d("CurrentMastodon", "token=" + currentMastodonPrefs.getToken());
            Log.d("CurrentMastodon", "created_at=" + currentMastodonPrefs.getCreatedAt());
        } else {
            Log.d("CurrentMastodon", "Current Mastodon is NULL");
        }
        //

        Intent intent = getIntent();
        if (intent != null && Intent.ACTION_VIEW.equals(intent.getAction())) {
            Uri uri = intent.getData();
            if ( Constants.URI_MASTODON_SCHEME.equals(uri.getScheme())
                    && Constants.URI_MASTODON_HOST.equals(uri.getHost()) ) {
                doSetCode(uri);
                doGetToken(client.getBaseUrl());
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (loginStartFragment.isAdded()) {
            closetStartFragment();
        }

        if (loginInstanceFragment.isAdded()) {
            closetInstanceFragment();
        }

        if (loginResultFragment.isAdded()) {
            closeResultragment();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override
    public void onClickLogin(Button loginButton, Fragment fragment) {
        closetStartFragment();
        startInstanceFragment();
    }

    @Override
    public void onClickGoMastodon(Button startButton, Fragment fragment) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClickAccept(EditText editText, Button nextButton, Fragment fragment) {
        String url = editText.getText().toString();
        doGetAuth(url);
    }

    @Override
    public void onClickStart(Button startButton, Fragment fragment) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }

    private void startStartFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_login_mastodon, loginStartFragment)
                .commit();
    }

    private void closetStartFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .remove(loginStartFragment)
                .commit();
    }

    private void startInstanceFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_login_mastodon, loginInstanceFragment)
                .commit();
    }

    private void closetInstanceFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .remove(loginInstanceFragment)
                .commit();
    }

    private void startResultFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_login_mastodon, loginResultFragment)
                .commit();
    }

    private void closeResultragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .remove(loginResultFragment)
                .commit();
    }

    /**
     * STEP.1
     * Mastodon OAuth Authorization Codeの取得
     * @param url Mastodon API URL (ex: https://pawoo.ne.jp)
     */
    private void doGetAuth(@NonNull String url) {
        if (HttpUrl.parse(url) == null) {
            Snackbar.make(contentView, "URLが不正です。", Snackbar.LENGTH_LONG).show();
            return;
        }
        client.setBaseUrl(url);
        manager.setCurrentMastodon(url);
        if (currentMastodonPrefs == null || !url.equals(currentMastodonPrefs.getBaseUrl())) {
            currentMastodonPrefs = new MastodonPreferences(manager.getMastodonPrefs(getApplicationContext(), url));
        }

        String appName = "AngelMining";
        final String redirectUri = Constants.URI_MASTODON_OAUTH_REDIRECT;
        final String scopes = "read write follow";

        final ProgressDialog d = ProgressDialog.show(this,"マストドン　ログイン", "マストドンのインスタンスにアクセスしています...", false, false);

        client.registerApplication(appName, redirectUri, scopes, null)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Register>() {
                    @Override
                    public void onCompleted() {
                        Log.d("Register","onCompleted");
                        d.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d("Register","onError");
                        d.dismiss();
                        rollbackOAuth();
                    }

                    @Override
                    public void onNext(Register register) {
                        String baseUrl = client.getBaseUrl();
                        String id = register.getClientId();
                        String secret = register.getClientSecret();
                        String uri = register.getRedirectUri();
                        String nextUrl = baseUrl + "/oauth/authorize?"
                                + "client_id=" + id
                                + "&response_type=code"
                                + "&redirect_uri=" + uri
                                + "&scope=read write follow";

                        Log.d("Register", "client_id=" + id);
                        Log.d("Register", "client_secret=" + secret);
                        Log.d("Register", "redirect_uri=" + uri);

                        currentMastodonPrefs.setClientId(id);
                        currentMastodonPrefs.setClientSecret(secret);
                        currentMastodonPrefs.setBaseUrl(baseUrl);
                        currentMastodonPrefs.setScope(scopes);
                        currentMastodonPrefs.setRedirectUri(redirectUri);
                        currentMastodonPrefs.save();

                        Uri tokenUri = Uri.parse(nextUrl);
                        Intent i = new Intent(Intent.ACTION_VIEW, tokenUri);
                        startActivity(i);
                    }
                });
    }

    /**
     * STEP.2
     * Mastodon OAuth Authorization Codeを設定保存
     * @param uri インスタンスURL
     */
    private void doSetCode(@NonNull Uri uri) {
        Log.d("doSetCode", uri.toString());

        Set<String> queryNames = uri.getQueryParameterNames();
        if( queryNames.contains("error") ) {
            Snackbar.make(contentView, "アプリケーションの利用が承認されていません。", Snackbar.LENGTH_LONG).show();
            rollbackOAuth();
            return;
        }

        String code = uri.getQueryParameter("code");
        String baseUrl = manager.getCurrentMastodon();
        if (baseUrl.isEmpty()) {
            Snackbar.make(contentView, "マストドンアカウント情報がありません。", Snackbar.LENGTH_LONG).show();
            rollbackOAuth();
            return;
        }

        currentMastodonPrefs.setCode(code);
        currentMastodonPrefs.save();
    }

    /**
     * STEP.3
     * マストドンAPIトークンを取得する
     * @param url インスタンスURL
     */
    private void doGetToken(@NonNull String url) {

        if (currentMastodonPrefs == null || !currentMastodonPrefs.getBaseUrl().equals(client.getBaseUrl())) {
            Snackbar.make(contentView, "アプリケーションの利用が承認されていません。", Snackbar.LENGTH_LONG).show();
            return;
        }

        String grantType = AppService.GRANT_TYPE;
        String redirectUri = Constants.URI_MASTODON_OAUTH_REDIRECT;
        String clientId = currentMastodonPrefs.getClientId();
        String clientSecret = currentMastodonPrefs.getClientSecret();
        String code = currentMastodonPrefs.getCode();

        if (clientId.isEmpty() || clientSecret.isEmpty() || code.isEmpty()) {
            Snackbar.make(contentView, "アプリケーションの利用が承認されていません。", Snackbar.LENGTH_LONG).show();
            return;
        }

        final ProgressDialog d = ProgressDialog.show(this,"マストドン　ログイン", "アクセストークンを発行しています...", false, false);
        client.registerAccessToken(grantType, redirectUri, clientId, clientSecret, code).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AccessToken>() {
                    boolean isSuccess = false;
                    @Override
                    public void onCompleted() {
                        Log.d("AccessToken","onCompleted");
                        d.dismiss();

                        Log.d("Register", "doGetToken end");
                        if (isSuccess) {
                            doSetToken(prefs.getString("token", ""));
                        } else {
                            rollbackOAuth();
                            Snackbar.make(contentView, "アクセストークンの発行に失敗しました。", Snackbar.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d("AccessToken","onError");
                        d.dismiss();
                        isSuccess = false;
                    }

                    @Override
                    public void onNext(AccessToken accessToken) {
                        String token = accessToken.getAccessToken();
                        String tokenType = accessToken.getTokenType();
                        Integer createdAt = accessToken.getCreatedAt();
                        String scope = accessToken.getScope();

                        currentMastodonPrefs.setToken(token);
                        currentMastodonPrefs.setTokenType(tokenType);
                        currentMastodonPrefs.setCreatedAt(createdAt);
                        currentMastodonPrefs.setScope(scope);
                        currentMastodonPrefs.save();

                        isSuccess = true;
                    }
                });
    }

    /**
     * HTTPクライアントにマストドンAPIトークンを設定、結果表示
     * @param token マストドンAPIトークン
     */
    private void doSetToken(String token) {
        client.setApiToken(token);
        closetInstanceFragment();
        startResultFragment();
    }

    /**
     * 認証中のマストドン承認情報をクリア
     */
    private void rollbackOAuth() {
        manager.setCurrentMastodon("");
        currentMastodonPrefs.clear();
        currentMastodonPrefs = null;
    }
}
