package com.example.galming_android;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils
{
    private static RetrofitUtils retrofitUtils;

    private RetrofitUtils()
    {
    }

    public static RetrofitUtils getInstance()
    {
        if (retrofitUtils == null)
        {
            synchronized (RetrofitUtils.class)
            {
                if (retrofitUtils == null)
                {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    // Obtener el método Retrofit
    private static Retrofit retrofit;

    private static synchronized Retrofit getRetrofit(String BASE_URL)
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    // obtener el método
    public <T> T doGet(String BASE_URL, Class<T> apiService)
    {
        // Obtenga una actualización
        Retrofit retrofit = getRetrofit(BASE_URL);
        // Obtener objetos de proxy dinámico a través del proxy dinámico de Java
        T t = retrofit.create(apiService);
        return t;
    }
}