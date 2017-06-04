package jp.gr.java_conf.ange.angelmining.di;

import android.content.Context;
import android.net.ConnectivityManager;

import com.squareup.picasso.Picasso;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.gr.java_conf.ange.angelmining.BuildConfig;
import jp.gr.java_conf.ange.commons.api.DefaultInterceptor;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Dagger2 DI Network Modules.
 */
@Module
public class NetworkModule {
    public static final long MAX_CACHE_SIZE = 40 * 1024 * 1024;
    public static final String CACHE_FILE_NAME = "okhttp.cache";

    @Singleton
    @Provides
    public ConnectivityManager provideConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Singleton
    @Provides
    public Interceptor provideRequestInterceptor(ConnectivityManager connectivityManager) {
        return new DefaultInterceptor(connectivityManager);
    }

    @Singleton
    @Provides
    public OkHttpClient provideHttpClient(Context context, Interceptor interceptor) {
        File cacheDir = new File(context.getCacheDir(), CACHE_FILE_NAME);
        Cache cache = new Cache(cacheDir, MAX_CACHE_SIZE);
        OkHttpClient.Builder c = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor);
        return c.build();
    }

    @Singleton
    @Provides
    public Picasso providePicasso(Context context) {
        Picasso picasso = Picasso.with(context);
        if (BuildConfig.DEBUG) {
            picasso.areIndicatorsEnabled();
        }

        return picasso;
    }
}
