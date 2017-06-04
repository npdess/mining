package jp.gr.java_conf.ange.angelmining.di;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Application Root
 */
public class AngelminingApplication extends Application {
    private AppComponent appComponent;

    public AppComponent getComponent() {
        return appComponent;
    }

    public static FragmentComponent getComponent(Fragment fragment) {
        assert fragment.getActivity() != null;
        AppCompatActivity activity = (AppCompatActivity) fragment.getActivity();
        AngelminingApplication application = (AngelminingApplication) activity.getApplicationContext();
        return application.getComponent()
                .createActivityComponent(new ActivityModule(activity))
                .createFragmentComponent(new FragmentModule(fragment));
    }

    public static ActivityComponent getComponent(AppCompatActivity activity) {
        AngelminingApplication application = (AngelminingApplication) activity.getApplicationContext();
        return application.getComponent().createActivityComponent(new ActivityModule(activity));
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}
