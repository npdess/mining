package jp.gr.java_conf.ange.angelmining.di;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.gr.java_conf.ange.angelmining.fragment.LoginMastodonInstanceFragment;
import jp.gr.java_conf.ange.angelmining.fragment.LoginMastodonResultFragment;

/**
 * Dagger2 DI Fragment Modules.
 */
@Module
public class FragmentModule {
    final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    public Context getContext() {
        return fragment.getContext();
    }

    @Provides
    public FragmentManager provideFragmentManager() {
        return fragment.getFragmentManager();
    }
}
