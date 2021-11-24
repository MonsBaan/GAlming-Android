package com.example.galming_android.ui.pedidos;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.galming_android.ui.retro.APIRetroFit;
import com.example.galming_android.ui.retro.RetrofitUtils;
import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.Servicio;
import com.example.galming_android.ui.retro.clases.TipoProducto;
import com.example.galming_android.ui.retro.clases.TipoServicio;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PedidosViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<List<Servicio>> mServicios;
    private MutableLiveData<List<TipoServicio>> mTipoProducto;

    public PedidosViewModel() {
        mServicios = new MutableLiveData<>();
        mTipoProducto = new MutableLiveData<>();
    }

    public void getServiciosUser(int idUser) {
        Call<List<Servicio>> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).getServiciosUser(idUser);
        call.enqueue(new Callback<List<Servicio>>() {
            @Override
            public void onResponse(Call<List<Servicio>> call, Response<List<Servicio>> response) {
                mServicios.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Servicio>> call, Throwable t) {
                Log.d("ibai", t.getCause() + "");

            }
        });
    }

    public void getServiciosTipoUser(String idTipo, String idUser) {
        Call<List<Servicio>> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).getServiciosTipoUser(idTipo, idUser);
        call.enqueue(new Callback<List<Servicio>>() {
            @Override
            public void onResponse(Call<List<Servicio>> call, Response<List<Servicio>> response) {
                mServicios.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Servicio>> call, Throwable t) {

            }
        });

    }

    public void getTipoServicios() {
        Call<List<TipoServicio>> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).getTiposServicio();

        call.enqueue(new Callback<List<TipoServicio>>() {
                         @Override
                         public void onResponse(@NonNull Call<List<TipoServicio>> call, @NonNull Response<List<TipoServicio>> response) {
                             //METEMOS LOS DATOS RECIBIDOS EN EL OBJETO CREADO
                             mTipoProducto.setValue(response.body());
                         }

                         @Override
                         public void onFailure(Call<List<TipoServicio>> call, Throwable t) {
                         }
                     }
        );
    }

    public MutableLiveData<List<Servicio>> getmServicios() {
        return mServicios;
    }

    public void setmServicios(MutableLiveData<List<Servicio>> mServicios) {
        this.mServicios = mServicios;
    }

    public MutableLiveData<List<TipoServicio>> getmTipoProducto() {
        return mTipoProducto;
    }

    public void setmTipoProducto(MutableLiveData<List<TipoServicio>> mTipoProducto) {
        this.mTipoProducto = mTipoProducto;
    }
}