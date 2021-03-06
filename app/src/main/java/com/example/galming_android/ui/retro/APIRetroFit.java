package com.example.galming_android.ui.retro;

import com.example.galming_android.ui.retro.clases.Geolocalizacion;
import com.example.galming_android.ui.retro.clases.MensajeSend;
import com.example.galming_android.ui.retro.clases.Mensajes;
import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.Servicio;
import com.example.galming_android.ui.retro.clases.ServicioEnvio;
import com.example.galming_android.ui.retro.clases.StockChange;
import com.example.galming_android.ui.retro.clases.TipoServicio;
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
    Call<List<OperacionProducto>> getProductosByTipo(@Path("id") int id);

    @GET("usuario/{id}")
    Call<List<Usuario>> getUsuario(@Path("id") int usuId);

    @GET("usuario/login/{dni}/{password}")
    Call<Usuario> loginUsuario(@Path("dni") String dni, @Path("password") String password);

    @POST("updateusuario")
    Call<Usuario> actualizarUsuario2(@Body Usuario usuario);

    @DELETE("borrarusuario/{id}")
    Call<List<Usuario>> borrarUsuario(@Path("id") int usuId);

    @POST("addlocalizacion/plus/")
    Call<Geolocalizacion> insertGeo(@Body Geolocalizacion geolocalizacion);

    @GET("/servicio/user/{id}")
    Call<List<Servicio>> getServiciosUser(@Path("id") int usuId);

    @GET("/asistencia/mensajes/{id}")
    Call<List<Mensajes>> getMensajes(@Path("id") int servicioId);

    @POST("servicio/add")
    Call<ServicioEnvio> comprarProducto(@Body ServicioEnvio servicioEnvio);

    @POST("servicio/stock")
    Call<StockChange> updateStock(@Body StockChange stockChange);

    @POST("addusuario/")
    Call<Usuario> insertarUsuario(@Body Usuario usuario);

    @GET("producto/getBusqueda/{buscar}")
    Call<List<OperacionProducto>> getProductosBusqueda(@Path("buscar") String busqueda);

    @GET("servicio/tipo/{idTipo}/{idUser}")
    Call<List<Servicio>> getServiciosTipoUser(@Path("idTipo") String idTipo, @Path("idUser") String idUser);

    @GET("tipo/servicio")
    Call<List<TipoServicio>> getTiposServicio();

    @POST("asistencia/mensajes")
    Call<MensajeSend> sendMensaje(@Body MensajeSend mensajeSend);

}
