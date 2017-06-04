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

import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;

import jp.gr.java_conf.ange.angelmining.R;
import jp.gr.java_conf.ange.angelmining.di.AngelminingApplication;
import jp.gr.java_conf.ange.angelmining.model.MastodonPreferences;

/**
 *
 */
public class LoginMastodonStartFragment extends Fragment {
    public interface LoginMastodonStartListener {
        void onClickGoMastodon(Button startButton, Fragment fragment);
        void onClickLogin(Button loginButton, Fragment fragment);
    }

    private LoginMastodonStartListener startListener;
    private Button startButton;
    private Button loginButton;

    @Inject
    MastodonPreferences currentMastodonPreferences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_mastodon_start, container, false);
        AngelminingApplication.getComponent(this).inject(this);

        startButton = (Button) view.findViewById(R.id.button_go_mastodon);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startListener != null) {
                    startListener.onClickGoMastodon(startButton, LoginMastodonStartFragment.this);
                }
            }
        });

        loginButton = (Button) view.findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startListener != null) {
                    startListener.onClickLogin(loginButton, LoginMastodonStartFragment.this);
                }
            }
        });

        if (currentMastodonPreferences != null && !StringUtils.isEmpty(currentMastodonPreferences.getToken())) {
            startButton.setEnabled(true);
        }

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
        if (!(context instanceof LoginMastodonStartListener)) {
            throw new ClassCastException("Activity is not support start button");
        }
        this.startListener = (LoginMastodonStartListener) context;
    }
}
