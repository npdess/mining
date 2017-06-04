package jp.gr.java_conf.ange.mastodon.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import jp.gr.java_conf.ange.mastodon.model.Status;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Single;

/**
 * Mastodon API Timeline.
 */
public interface TimelineService {
    @GET("/api/v1/timelines/home")
    Single<List<Status>> home(
            @NonNull @Header("Authorization") String authorization,
            @Nullable @Query("max_id") Integer max_id,
            @Nullable @Query("since_id") Integer since_id,
            @Nullable @Query("limit") Integer limit);

    @GET("/api/v1/timelines/public")
    Single<List<Status>> pub(
            @Nullable @Query("local") Boolean local,
            @Nullable @Query("max_id") Integer max_id,
            @Nullable @Query("since_id") Integer since_id,
            @Nullable @Query("limit") Integer limit);

    @GET("/api/v1/timelines/tag/{hashtag}")
    Single<List<Status>> tags(
            @Field("hashtag") String hashtag,
            @Nullable @Query("local") Boolean local,
            @Nullable @Query("max_id") Integer max_id,
            @Nullable @Query("since_id") Integer since_id,
            @Nullable @Query("limit") Integer limit);
}
