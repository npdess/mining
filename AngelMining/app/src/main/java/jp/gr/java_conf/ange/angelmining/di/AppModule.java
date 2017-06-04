package jp.gr.java_conf.ange.angelmining.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.gr.java_conf.ange.angelmining.fragment.LoginMastodonInstanceFragment;
import jp.gr.java_conf.ange.angelmining.fragment.LoginMastodonResultFragment;
import jp.gr.java_conf.ange.angelmining.fragment.LoginMastodonStartFragment;

/**
 * Dagger2 DI Application Modules.
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Application app) {
        this.context = app;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    public LoginMastodonStartFragment provideLoginStartFragment() {
        return new LoginMastodonStartFragment();
    }

    @Singleton
    @Provides
    public LoginMastodonInstanceFragment provideLoginInstanceFragment() {
        return new LoginMastodonInstanceFragment();
    }

    @Singleton
    @Provides
    public LoginMastodonResultFragment provideLoginResultFragment() {
        return new LoginMastodonResultFragment();
    }
}
