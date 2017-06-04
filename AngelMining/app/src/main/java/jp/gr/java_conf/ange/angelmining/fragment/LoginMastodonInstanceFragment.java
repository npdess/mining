package jp.gr.java_conf.ange.angelmining.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import jp.gr.java_conf.ange.angelmining.R;
import jp.gr.java_conf.ange.angelmining.di.AngelminingApplication;

/**
 * Login Mastodon Input Domain Fragment.
 */
public class LoginMastodonInstanceFragment extends Fragment {

    public interface LoginMastodonInstanceListener {
        void onClickAccept(EditText instanceUrlText, Button nextButton, Fragment fragment);
    }

    private AutoCompleteTextView editDomain;
    private Button nextButton;
    private LoginMastodonInstanceListener nextListener;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_mastodon_instance, container, false);

        AngelminingApplication.getComponent(this).inject(this);

        editDomain = (AutoCompleteTextView) view.findViewById(R.id.edit_mastodon_domain);
        editDomain.setText("https://");
        editDomain.addTextChangedListener(new TextWatcher() {
            String currentText;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                currentText = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String value = s.toString();
                if (!value.startsWith("https://")) {
                    if (currentText != null && currentText.startsWith("https://")) {
                        s.replace(0, s.length(), currentText);
                    } else {
                        s.replace(0, s.length(), "https://");
                    }
                    Selection.setSelection(s, s.length());
                }
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(),
                R.layout.row_mastodon_instances,
                R.id.domain,
                getResources().getStringArray(R.array.mastodon_instances));
        editDomain.setAdapter(adapter);

        nextButton = (Button) view.findViewById(R.id.button_next_mastodon_domain);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nextListener != null) {
                    nextListener.onClickAccept(editDomain, nextButton, LoginMastodonInstanceFragment.this);
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
        if (!(context instanceof LoginMastodonInstanceListener)) {
            throw new ClassCastException("Activity is not support next button");
        }
        this.nextListener = (LoginMastodonInstanceListener) context;
    }
}
