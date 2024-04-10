package com.orquitech.development.cuencaVerde.data.api.interceptors;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    private final String accessToken;

    public HeaderInterceptor(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public Response intercept(Chain chain)
            throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + accessToken)
                .build();
        return chain.proceed(request);
    }
}
