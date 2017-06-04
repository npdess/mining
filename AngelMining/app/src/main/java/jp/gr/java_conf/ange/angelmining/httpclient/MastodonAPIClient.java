package jp.gr.java_conf.ange.angelmining.httpclient;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.inject.Inject;
import javax.inject.Singleton;

import jp.gr.java_conf.ange.mastodon.api.AccountService;
import jp.gr.java_conf.ange.mastodon.api.AppService;
import jp.gr.java_conf.ange.mastodon.api.InstanceService;
import jp.gr.java_conf.ange.mastodon.api.StreamingService;
import jp.gr.java_conf.ange.mastodon.api.TimelineService;
import jp.gr.java_conf.ange.mastodon.model.AccessToken;
import jp.gr.java_conf.ange.mastodon.model.Register;
import jp.gr.java_conf.ange.mastodon.model.Status;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Observable;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * MMastodon API Client.
 */
@Singleton
public class MastodonAPIClient {
    private  String apiToken;

    private Retrofit retrofit;
    private Retrofit.Builder builder;
    private final OkHttpClient client;

    private AppService appService;
    private InstanceService instanceService;
    private AccountService accountService;
    private TimelineService timelineService;
    private StreamingService streamingService;

    private Handler handler;

    public interface StreamingServiceListener {
        void onStreamingStart(ResponseBody responseBody);
        void onStreamingEnd(ResponseBody responseBody);
        void onReceive(String event, Status status);
        boolean isKeepStreaming(ResponseBody responseBody);
    }

    @Inject
    public MastodonAPIClient(OkHttpClient client) {
        this.client = client;

        builder = new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create());

        handler = new Handler(Looper.getMainLooper());
    }

    public void setBaseUrl(String url) {
        Retrofit.Builder newBuilder = retrofit != null ? retrofit.newBuilder() : builder;
        retrofit = newBuilder.baseUrl(url).build();
        createServices();
    }

    public String getBaseUrl() {
        return retrofit.baseUrl().toString();
    }

    public OkHttpClient getClient() {
        return client;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getApiToken() {
        return apiToken;
    }

    private void createServices() {
        appService = retrofit.create(AppService.class);
        instanceService = retrofit.create(InstanceService.class);
        accountService = retrofit.create(AccountService.class);
        timelineService = retrofit.create(TimelineService.class);
        streamingService = retrofit.create(StreamingService.class);
    }

    private String authorizationHeader() {
        if (apiToken == null) {
            return "";
        }
        return "Bearer ".concat(apiToken);
    }

    /**
     * @see AppService#apps(String, String, String, String) Register Application.
     */
    public Single<Register> registerApplication(
            @NonNull String clientName,
            @NonNull String redirectUris,
            @NonNull String scopes,
            @Nullable String website) {
        return appService.apps(clientName, redirectUris, scopes, website).map(new Func1<Register, Register>() {
            @Override
            public Register call(Register register) {
                return register;
            }
        });
    }

    /**
     * @see AppService#token(String, String, String, String, String) Pay AccessToken.
     */
    public Single<AccessToken> registerAccessToken(
            @NonNull String grantType,
            @NonNull String redirectUri,
            @NonNull String clientId,
            @NonNull String clientSecret,
            @NonNull String code) {
        return appService.token(grantType, redirectUri, clientId, clientSecret, code).map(new Func1<AccessToken, AccessToken>() {
            @Override
            public AccessToken call(AccessToken accessToken) {
                return accessToken;
            }
        });
    }

    /**
     * Streaming開始（デモ用）
     * @param listener イベントリスナ
     */
    public void streamingPublicTimeline(@NonNull final StreamingServiceListener listener) {
        Observable<ResponseBody> streamingPub = streamingService.pub("Bearer " + apiToken);
        streamingPub.map(new Func1<ResponseBody, Object>() {
            @Override
            public Object call(final ResponseBody responseBody) {
                Log.d("WS", "responseBody="+responseBody);
                if (responseBody != null) {
                    BufferedSource source = responseBody.source();
                    BufferedReader reader = null;
                    String event = null;
                    Status data = null;

                    try {
                        reader = new BufferedReader(new InputStreamReader(source.inputStream()));
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                listener.onStreamingStart(responseBody);
                            }
                        });
                        while (!source.exhausted() && listener.isKeepStreaming(responseBody)) {
                            String line = null;
                            if ((line = reader.readLine()) != null) {
                                if (line.startsWith("event:")) {
                                    event = line.split(":")[1].trim();
                                    data = null;
                                } else if (line.startsWith("data:")) {
                                    String dataString = line.replaceFirst("data: ","");

                                    Log.d("JSON", dataString);
                                    if ("update".equals(event)) {
                                        ObjectMapper mapper = new ObjectMapper();
                                        data = mapper.readValue(dataString, Status.class);
                                    } else {
                                        event = null;
                                        data = null;
                                    }
                                } else {
                                    event = null;
                                    data = null;
                                }
                                Log.d("STREAM",line);
                            }
                            if (event != null && data != null){
                                final String _event = event;
                                final Status _data = data;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        listener.onReceive(_event, _data);
                                    }
                                });
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                listener.onStreamingEnd(responseBody);
                            }
                        });
                        try {
                            if (reader != null ) {
                                reader.close();
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }

                    return responseBody;
                } else {
                    return "";
                }
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}
