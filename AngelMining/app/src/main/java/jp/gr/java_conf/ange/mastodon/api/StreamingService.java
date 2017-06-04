package jp.gr.java_conf.ange.mastodon.api;

import android.support.annotation.NonNull;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Streaming;
import rx.Observable;

/**
 * Mastodon API Streaming Timeline.
 */
public interface StreamingService {
    @Streaming
    @GET("/api/v1/streaming/home")
    Observable<ResponseBody> home(@NonNull @Header("Authorization") String authorization);

    @Streaming
    @GET("/api/v1/streaming/public")
    Observable<ResponseBody> pub(@NonNull @Header("Authorization") String authorization);

    @Streaming
    @GET("/api/v1/streaming/tags")
    Observable<ResponseBody> tags(@NonNull @Header("Authorization") String authorization);


}
