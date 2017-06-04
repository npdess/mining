package jp.gr.java_conf.ange.angelmining.di;

import dagger.Component;
import dagger.Subcomponent;
import jp.gr.java_conf.ange.angelmining.MainActivity;
import jp.gr.java_conf.ange.angelmining.activity.LoginMastodonActivity;
import jp.gr.java_conf.ange.angelmining.di.scope.ActivityScope;

/**
 *
 */
@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(LoginMastodonActivity activity);
    void inject(MainActivity activity);
    FragmentComponent createFragmentComponent(FragmentModule module);
}
