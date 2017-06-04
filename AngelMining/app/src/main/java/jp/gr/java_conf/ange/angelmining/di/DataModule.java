package jp.gr.java_conf.ange.angelmining.di;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.gr.java_conf.ange.angelmining.Manager;
import jp.gr.java_conf.ange.angelmining.model.MastodonPreferences;

/**
 * Dagger2 DI Data Modules.
 */
@Module
public class DataModule {
    public static final String SHARED_PREFS_NAME = "preferences";

    @Provides
    public SharedPreferences providePrefs(Context context) {
        return context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    public MastodonPreferences provideCurrentMastodonPreferences(Context context, Manager manager) {
        String baseUrl = manager.getCurrentMastodon();
        SharedPreferences prefs = manager.getMastodonPrefs(context, baseUrl);
        return new MastodonPreferences(prefs);
    }
}
