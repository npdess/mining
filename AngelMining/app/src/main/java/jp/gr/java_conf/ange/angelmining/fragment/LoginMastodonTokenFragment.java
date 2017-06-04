package jp.gr.java_conf.ange.angelmining.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;

import jp.gr.java_conf.ange.angelmining.R;
import jp.gr.java_conf.ange.angelmining.di.AngelminingApplication;

/**
 * Login Mastodon Input Token Fragment
 */
public class LoginMastodonTokenFragment extends Fragment {

    public interface LoginMastodonTokeneListener {
        void onClickAccept(EditText instanceUrlText, Button nextButton, Fragment fragment);
    }

    private EditText editToken;
    private Button nextButton;
    private LoginMastodonTokeneListener nextListener;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_mastodon_token, container, false);

        AngelminingApplication.getComponent(this).inject(this);

        editToken = (EditText) view.findViewById(R.id.edit_mastodon_token);
        nextButton = (Button) view.findViewById(R.id.button_next_mastodon_token);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nextListener != null) {
                    nextListener.onClickAccept(editToken, nextButton, LoginMastodonTokenFragment.this);
                }
            }
        });
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
            throw new ClassCastException("Activity is not support next button");
        }
        this.nextListener = (LoginMastodonTokenFragment.LoginMastodonTokeneListener) context;
    }
}
