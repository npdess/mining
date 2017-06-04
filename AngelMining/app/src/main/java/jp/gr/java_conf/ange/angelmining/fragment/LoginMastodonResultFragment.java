package jp.gr.java_conf.ange.angelmining.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import jp.gr.java_conf.ange.angelmining.R;
import jp.gr.java_conf.ange.angelmining.di.AngelminingApplication;
import jp.gr.java_conf.ange.angelmining.model.MastodonPreferences;

/**
 * Login Mastodon Result.
 */
public class LoginMastodonResultFragment extends Fragment {
    public interface LoginMastodonResultListener {
        void onClickStart(Button startButton, Fragment fragment);
    }

    private LoginMastodonResultListener startListener;

    private Button startButton;
    private TextView resultText;

    @Inject
    MastodonPreferences currentMastodonPreferences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_mastodon_result, container, false);
        AngelminingApplication.getComponent(this).inject(this);

        startButton = (Button) view.findViewById(R.id.button_start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startListener != null) {
                    startListener.onClickStart(startButton, LoginMastodonResultFragment.this);
                }
            }
        });
        resultText = (TextView) view.findViewById(R.id.text_result);
        resultText.setText(getResources().getString(R.string.login_mastodon_result, currentMastodonPreferences.getBaseUrl()));

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAttachContext(context);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) return;
        onAttachContext(activity);
    }

    private void onAttachContext(Context context) {
        if (!(context instanceof LoginMastodonInstanceFragment.LoginMastodonInstanceListener)) {
            throw new ClassCastException("Activity is not support start button");
        }
        this.startListener = (LoginMastodonResultFragment.LoginMastodonResultListener) context;
    }
}
