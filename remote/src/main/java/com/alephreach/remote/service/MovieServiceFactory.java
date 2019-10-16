package com.alephreach.remote.service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieServiceFactory {

    private static final String API_KEY = "6fffa22d1ba58423a952b48709479f7d";

    public static MovieService getMovieSerivice(Boolean isDebug) {
        OkHttpClient client = getOkHttpClient(getLoggingIntercepter(isDebug));
        return getMovieService(client, GsonConverterFactory.create());
    }

    private static MovieService getMovieService(OkHttpClient client, GsonConverterFactory gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/popular?api_key=" + API_KEY)
                .client(client)
                .build();

        return retrofit.create(MovieService.class);
    }

    private static HttpLoggingInterceptor getLoggingIntercepter(Boolean isDeug) {

        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        if (isDeug) {
            logger.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logger.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        return logger;
    }

    private static OkHttpClient getOkHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder().addInterceptor(interceptor)
                .callTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build();
    }





}
