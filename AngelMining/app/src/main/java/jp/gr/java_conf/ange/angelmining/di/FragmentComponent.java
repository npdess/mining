package jp.gr.java_conf.ange.angelmining.di;

import dagger.Subcomponent;
import jp.gr.java_conf.ange.angelmining.di.scope.FragmentScope;
import jp.gr.java_conf.ange.angelmining.fragment.LoginMastodonInstanceFragment;
import jp.gr.java_conf.ange.angelmining.fragment.LoginMastodonResultFragment;
import jp.gr.java_conf.ange.angelmining.fragment.LoginMastodonStartFragment;
import jp.gr.java_conf.ange.angelmining.fragment.LoginMastodonTokenFragment;

@FragmentScope
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(LoginMastodonInstanceFragment fragment);
    void inject(LoginMastodonTokenFragment fragment);
    void inject(LoginMastodonResultFragment fragment);
    void inject(LoginMastodonStartFragment fragment);
}