package jp.gr.java_conf.ange.mastodon.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Single;

/**
 * Mastodon API Account.
 */
public interface AccountService {
    @GET("/api/v1/accounts/{id}")
    Single<Object> account(@Path("id") Integer id);

    @GET("/api/v1/accounts/verify_credentials")
    Single<Object> verifyCredential();

    @PATCH("/api/v1/accounts/update_credentials")
    Single<Object> updateCredential();

    @GET("/api/v1/accounts/{id}/followers")
    Single<Object> followers(@Path("id") Integer id);

    @GET("/api/v1/accounts/{id}/following")
    Single<Object> following(@Path("id") Integer id);

    @GET("/api/v1/accounts/{id}/statuses")
    Single<Object> statuses(@Path("id") Integer id);

    @POST("/api/v1/accounts/{id}/follow")
    Single<Object> follow(@Path("id") Integer id);

    @POST("/api/v1/accounts/{id}/unfollow")
    Single<Object> unFollow(@Path("id") Integer id);

    @POST("/api/v1/accounts/{id}/block")
    Single<Object> block(@Path("id") Integer id);

    @POST("/api/v1/accounts/{id}/unblock")
    Single<Object> unBlock(@Path("id") Integer id);

    @POST("/api/v1/accounts/{id}/mute")
    Single<Object> mute(@Path("id") Integer id);

    @POST("/api/v1/accounts/{id}/unmute")
    Single<Object> unMute(@Path("id") Integer id);

    @GET("/api/v1/accounts/relationships")
    Single<Object> relationships(@Query("id") Integer... ids);

    @GET("/api/v1/accounts/search")
    Single<Object> search(
            @NonNull @Query("q") String q,
            @Nullable @Query("limit") Integer limit);
}
