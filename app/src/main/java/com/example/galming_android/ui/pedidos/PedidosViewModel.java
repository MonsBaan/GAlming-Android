package com.example.galming_android.ui.pedidos;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.galming_android.ui.retro.APIRetroFit;
import com.example.galming_android.ui.retro.RetrofitUtils;
import com.example.galming_android.ui.retro.clases.Servicio;
import com.example.galming_android.ui.retro.clases.TipoProducto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PedidosViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<List<Servicio>> mServicios;

    public PedidosViewModel() {
        mServicios = new MutableLiveData<>();
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

    public MutableLiveData<List<Servicio>> getmServicios() {
        return mServicios;
    }

    public void setmServicios(MutableLiveData<List<Servicio>> mServicios) {
        this.mServicios = mServicios;
    }
}