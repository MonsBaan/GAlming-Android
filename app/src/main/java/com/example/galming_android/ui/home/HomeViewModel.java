package com.example.galming_android.ui.home;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.galming_android.ui.retro.APIRetroFit;
import com.example.galming_android.ui.retro.RetrofitUtils;
import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.TipoProducto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<List<TipoProducto>> mTipoProducto;
    private final MutableLiveData<List<OperacionProducto>> mAllProductos;

    public HomeViewModel() {
        mTipoProducto = new MutableLiveData<>();
        mAllProductos = new MutableLiveData<>();
    }


    public void getTiposProducto() {
        Call<List<TipoProducto>> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).getTipoProductos();

        call.enqueue(new Callback<List<TipoProducto>>() {
                         @Override
                         public void onResponse(@NonNull Call<List<TipoProducto>> call, @NonNull Response<List<TipoProducto>> response) {
                             //METEMOS LOS DATOS RECIBIDOS EN EL OBJETO CREADO
                             mTipoProducto.setValue(response.body());
                         }

                         @Override
                         public void onFailure(Call<List<TipoProducto>> call, Throwable t) {
                         }
                     }
        );
    }

    public void getProductos() {
        Call<List<OperacionProducto>> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).getProductos();
        call.enqueue(new Callback<List<OperacionProducto>>() {
            @Override
            public void onResponse(Call<List<OperacionProducto>> call, Response<List<OperacionProducto>> response) {
                mAllProductos.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<OperacionProducto>> call, Throwable t) {

            }
        });


    }

    //Creamos este getter para colarle un observer y que nos refresque la vista en caso de que haya un cambio de datos (O en nuestro caso, que recojamos esos datos)
    public MutableLiveData<List<TipoProducto>> getmTipoProducto() {
        return mTipoProducto;
    }

    public MutableLiveData<List<OperacionProducto>> getmAllProductos() {
        return mAllProductos;
    }
}