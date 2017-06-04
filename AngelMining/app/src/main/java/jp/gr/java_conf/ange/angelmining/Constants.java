package jp.gr.java_conf.ange.angelmining;

import android.support.annotation.NonNull;

/**
 * Angel Minging App Constants.
 */
public class Constants {

    public static final String APP_NAME = "AngelMining";
    public static final String URI_MASTODON_SCHEME = "angelmining.mastodon.oauth";
    public static final String URI_MASTODON_HOST = "callback";
    public static final String URI_MASTODON_OAUTH_REDIRECT = URI_MASTODON_SCHEME + "://" + URI_MASTODON_HOST;

    public static final String KEY_OAUTH_AUTHORIZATION_CODE = "code";
    public static final String KEY_OAUTH_CLIENT_ID = "client_id";
    public static final String KEY_OAUTH_CLIENT_SECRET = "client_secret";
    public static final String KEY_OAUTH_REDIRECT_URI = "redirect_uri";
    public static final String KEY_OAUTH_MASTODON_SCOPE = "scope";
    public static final String KEY_OAUTH_MASTODON_TOKEN = "token";
    public static final String KEY_OAUTH_MASTODON_TOKEN_TYPE = "token_type";
    public static final String KEY_OAUTH_MASTODON_CREATED_AT = "created_at";
    public static final String KEY_SCOPE_BASE_URL = "baseUrl";
    public static final String KEY_SERVICE_MASTODON = "mastodon";
    public static final String KEY_CURRENT_MASTODON = "current_mastodon";

    public static final String PREF_BY_SERVICE(@NonNull String SERVICE, @NonNull String baseUrl) {
        return SERVICE
                .concat(".")
                .concat(baseUrl
                        .replace("https://", "")
                        .replaceAll("/", ""));
    }
}
