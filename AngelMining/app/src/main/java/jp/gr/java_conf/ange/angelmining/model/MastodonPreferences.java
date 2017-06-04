package jp.gr.java_conf.ange.angelmining.model;

import android.content.SharedPreferences;

/**
 * Mastodon アカウント情報保存用のデータモデル
 */
public class MastodonPreferences {
    public static final String KEY_OAUTH_AUTHORIZATION_CODE = "code";
    public static final String KEY_OAUTH_CLIENT_ID = "client_id";
    public static final String KEY_OAUTH_CLIENT_SECRET = "client_secret";
    public static final String KEY_OAUTH_REDIRECT_URI = "redirect_uri";
    public static final String KEY_OAUTH_MASTODON_SCOPE = "scope";
    public static final String KEY_OAUTH_MASTODON_TOKEN = "token";
    public static final String KEY_OAUTH_MASTODON_TOKEN_TYPE = "token_type";
    public static final String KEY_OAUTH_MASTODON_CREATED_AT = "created_at";
    public static final String KEY_BASE_URL = "baseUrl";

    private SharedPreferences prefs;

    private String code;
    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String scope;
    private String token;
    private String tokenType;
    private Integer createdAt;
    private String baseUrl;

    public MastodonPreferences(SharedPreferences prefs) {
        if (prefs == null) {
            code = "";
            clientId = "";
            clientSecret = "";
            redirectUri = "";
            scope = "";
            token = "";
            tokenType = "";
            createdAt = 0;
            baseUrl = "";
            return;
        }
        this.prefs = prefs;
        code = prefs.getString(KEY_OAUTH_AUTHORIZATION_CODE, "");
        clientId = prefs.getString(KEY_OAUTH_CLIENT_ID, "");
        clientSecret = prefs.getString(KEY_OAUTH_CLIENT_SECRET, "");
        redirectUri = prefs.getString(KEY_OAUTH_REDIRECT_URI, "");
        scope = prefs.getString(KEY_OAUTH_MASTODON_SCOPE, "");
        token = prefs.getString(KEY_OAUTH_MASTODON_TOKEN, "");
        tokenType = prefs.getString(KEY_OAUTH_MASTODON_TOKEN_TYPE, "");
        createdAt = prefs.getInt(KEY_OAUTH_MASTODON_CREATED_AT, 0);
        baseUrl = prefs.getString(KEY_BASE_URL, "");
    }

    public boolean save() {
        if (prefs == null) {
            return false;
        }
        return prefs.edit()
                .putString(KEY_OAUTH_AUTHORIZATION_CODE, code)
                .putString(KEY_OAUTH_CLIENT_ID, clientId)
                .putString(KEY_OAUTH_CLIENT_SECRET, clientSecret)
                .putString(KEY_OAUTH_REDIRECT_URI, redirectUri)
                .putString(KEY_OAUTH_MASTODON_SCOPE, scope)
                .putString(KEY_OAUTH_MASTODON_TOKEN, token)
                .putString(KEY_OAUTH_MASTODON_TOKEN_TYPE, tokenType)
                .putInt(KEY_OAUTH_MASTODON_CREATED_AT, createdAt)
                .putString(KEY_BASE_URL, baseUrl)
                .commit();
    }

    public boolean clear() {
        if (prefs == null) {
            return false;
        }
        return prefs.edit().clear().commit();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
