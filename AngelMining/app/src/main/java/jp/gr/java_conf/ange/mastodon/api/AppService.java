package jp.gr.java_conf.ange.mastodon.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Map;

import jp.gr.java_conf.ange.mastodon.model.AccessToken;
import jp.gr.java_conf.ange.mastodon.model.Register;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import rx.Single;

/**
 * Mastodon API App Register, OAuth.
 */
public interface AppService {
    String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";
    String SCOPE_READ = "read";
    String SCOPE_WRITE = "write";
    String SCOPE_FOLLOW = "follow";

    String GRANT_TYPE = "authorization_code";


    /**
     * Register Application.
     * @param client_name client application name.
     * @param redirect_uris redirect website, or activity.
     * @param scopes split the space, "read", "write", "follow". ex: "read write follow"
     * @param website option. web site uri.
     * @return {@link Register}
     */
    @Headers({
            "Accept: application/json"})
    @FormUrlEncoded
    @POST("/api/v1/apps")
    Single<Register> apps(
            @NonNull @Field("client_name") String client_name,
            @NonNull @Field("redirect_uris") String redirect_uris,
            @NonNull @Field("scopes") String scopes,
            @Nullable @Field("website") String website);

    /**
     * Pay AccessToken.
     * @param grant_type authorization_code
     * @param redirect_uri redirect_uri
     * @param client_id {@link Register#clientId}
     * @param client_secret {@link Register#clientSecret}
     * @param authorization_code authorization code.
     * @return {@link AccessToken}
     */
    @Headers({
            "Accept: application/json"})
    @FormUrlEncoded
    @POST("/oauth/token")
    Single<AccessToken> token(
            @NonNull @Field("grant_type") String grant_type,
            @NonNull @Field("redirect_uri") String redirect_uri,
            @NonNull @Field("client_id") String client_id,
            @NonNull @Field("client_secret") String client_secret,
            @NonNull @Field("code") String authorization_code);
}
