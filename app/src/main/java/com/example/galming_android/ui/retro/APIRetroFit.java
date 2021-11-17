package com.example.galming_android.ui.retro;

import com.example.galming_android.ui.retro.clases.TipoProducto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRetroFit
{
    @GET("producto/get_tipos")
    Call<List<TipoProducto>> getTipoProductos();

    @GET("producto/get_tipos")
    Call<List<TipoProducto>> getProductosByTipo();


}
