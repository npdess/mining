package jp.gr.java_conf.ange.commons.api;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

import java.io.IOException;

import jp.gr.java_conf.ange.angelmining.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class DefaultInterceptor implements Interceptor {

    final ConnectivityManager connectivityManager;

    final String userAgent;

    public DefaultInterceptor(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
        userAgent = BuildConfig.APPLICATION_ID + "/" + BuildConfig.VERSION_NAME
                + "; Android/" + Build.VERSION.RELEASE
                + "; " + Build.DEVICE
                + "; " + Build.BRAND
                + "; " + Build.MODEL;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request.Builder r = chain.request().newBuilder();
        if(isConnected()) {
            int maxAge = 2 * 60;
            r.addHeader("cache-control", "public, max-age=" + maxAge);
        }else {
            int maxStale = 30 * 24 * 60 * 60; // 30 days
            r.addHeader("cache-control", "public, only-if-cached, max-stale=" + maxStale);
        }
        r.addHeader("user-agent", userAgent);

        return chain.proceed(r.build());
    }

    protected boolean isConnected() {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
