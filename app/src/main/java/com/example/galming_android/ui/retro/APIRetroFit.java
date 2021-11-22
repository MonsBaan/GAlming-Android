package com.example.galming_android.ui.retro;

import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.Usuario;
import com.example.galming_android.ui.retro.clases.TipoProducto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIRetroFit {


    @GET("producto")
    Call<List<OperacionProducto>> getProductos();

    @GET("producto/get_tipos")
    Call<List<TipoProducto>> getTipoProductos();

    @GET("producto/get_by_tipo/{id}")
    Call<List<OperacionProducto>> getProductosByTipo(@Path("id")int id);

    @GET("usuario/{id}")
    Call<List<Usuario>> getUsuario(@Path("id") int usuId);

    @GET("usuario/login/{dni}/{password}")
    Call<Usuario> loginUsuario(@Path("dni") String dni, @Path("password") String password);

    @POST("updateusuario")
    Call<Usuario> actualizarUsuario2(@Body Usuario usuario);

    @DELETE("borrarusuario/{id}")
    Call<List<Usuario>> borrarUsuario(@Path("id") int usuId);



}
