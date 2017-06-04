package jp.gr.java_conf.ange.angelmining.di;

import android.support.v7.app.AppCompatActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Application DI Root Component.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                DataModule.class,
                NetworkModule.class
        }
)
public interface AppComponent {
    void inject(AppCompatActivity activity);
    ActivityComponent createActivityComponent(ActivityModule module);
}
