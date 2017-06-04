package jp.gr.java_conf.ange.angelmining;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Manager
 */
@Singleton
public class Manager {

    @Inject
    SharedPreferences prefs;

    @Inject
    public Manager(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    public void setCurrentMastodon(@NonNull String baseUrl) {
        prefs.edit().putString(Constants.KEY_CURRENT_MASTODON, baseUrl).apply();
    }

    public String getCurrentMastodon() {
        return prefs.getString(Constants.KEY_CURRENT_MASTODON, "");
    }

    public SharedPreferences getMastodonPrefs(Context context, @NonNull String baseUrl) {
        if (baseUrl.isEmpty()) {
            return null;
        }
        return context.getSharedPreferences(
                Constants.PREF_BY_SERVICE(Constants.KEY_SERVICE_MASTODON, baseUrl),
                Context.MODE_PRIVATE);
    }

}
