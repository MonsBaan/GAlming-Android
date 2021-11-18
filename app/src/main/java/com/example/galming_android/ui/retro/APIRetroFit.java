package com.example.galming_android.ui.retro;

import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIRetroFit
{
    @GET("productos")
    Call<List<OperacionProducto>> getProductos();

    @GET("usuario/{id}")
    Call<List<Usuario>> getUsuario(@Path("id") int usuId);

    @POST("usuario/{id}")
    Call<List<Usuario>> actualizarUsuario(@Path("id") int usuId);


}
