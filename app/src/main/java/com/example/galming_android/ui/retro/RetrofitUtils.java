package com.example.galming_android.ui.retro;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private static final String url = "https://galming.duckdns.org/";
    private RetrofitUtils() {
    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    private static synchronized Retrofit getRetrofit() {
        // Obtener el método Retrofit
        return new Retrofit.Builder()
                .baseUrl(RetrofitUtils.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // obtener el método
    public <T> T doGet(Class<T> apiService) {
        // Obtenga una actualización
        Retrofit retrofit = getRetrofit();
        // Obtener objetos de proxy dinámico a través del proxy dinámico de Java
        return retrofit.create(apiService);
    }
}