package com.example.galming_android.ui.retro;

import androidx.annotation.AnyRes;

import com.example.galming_android.ui.retro.clases.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRetroFit
{
    @GET("productos")
    Call<List<Producto>> getProductos();


}
