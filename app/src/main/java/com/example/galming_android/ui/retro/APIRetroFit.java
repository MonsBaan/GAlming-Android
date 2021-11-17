package com.example.galming_android.ui.retro;

import com.example.galming_android.ui.retro.clases.OperacionProducto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRetroFit
{
    @GET("productos")
    Call<List<OperacionProducto>> getProductos();


}
