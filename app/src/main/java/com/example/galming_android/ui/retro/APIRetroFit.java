package com.example.galming_android.ui.retro;

import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.Usuario;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIRetroFit
{
    @GET("productos")
    Call<List<OperacionProducto>> getProductos();

    @GET("usuario/{id}")
    Call<List<Usuario>> getUsuario(@Path("id") int usuId);

    @POST("updateusuario")
    Call<Usuario> actualizarUsuario2(@Body Usuario usuario);

/*
    @FormUrlEncoded
    @POST("updateusuario/{id}")
    Call<List<Usuario>> actualizarUsuario(@Path("id") int usuId, @Field("usuDni") String usuDni);
*/

}
