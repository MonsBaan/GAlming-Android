package com.example.galming_android.ui.retro;

import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.TipoProducto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIRetroFit
{

    @GET("producto/get_tipos")
    Call<List<TipoProducto>> getTipoProductos();

    @GET("producto")
    Call<List<OperacionProducto>> getProductos();




}
