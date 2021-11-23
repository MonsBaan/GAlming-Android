package com.example.galming_android.ui.pedidos.asistencia;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.galming_android.ui.retro.APIRetroFit;
import com.example.galming_android.ui.retro.RetrofitUtils;
import com.example.galming_android.ui.retro.clases.Mensajes;
import com.example.galming_android.ui.retro.clases.TipoProducto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsistenciaViewModel extends ViewModel {
    private MutableLiveData<List<Mensajes>> mMensajes;

    public AsistenciaViewModel() {
        mMensajes = new MutableLiveData<>();
    }

    public void getMensajes(int idPedido) {
        Call<List<Mensajes>> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).getMensajes(idPedido);
        call.enqueue(new Callback<List<Mensajes>>() {
            @Override
            public void onResponse(Call<List<Mensajes>> call, Response<List<Mensajes>> response) {
                mMensajes.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Mensajes>> call, Throwable t) {
                Log.d("ibai", t.getLocalizedMessage()+"");

            }
        });
    }


    public MutableLiveData<List<Mensajes>> getmMensajes() {
        return mMensajes;
    }

    public void setmMensajes(MutableLiveData<List<Mensajes>> mMensajes) {
        this.mMensajes = mMensajes;
    }

}