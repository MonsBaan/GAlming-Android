package com.example.galming_android.ui.home.productos;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.galming_android.ui.retro.APIRetroFit;
import com.example.galming_android.ui.retro.RetrofitUtils;
import com.example.galming_android.ui.retro.clases.OperacionProducto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlquilerViewModel extends ViewModel
{
    private MutableLiveData<List<OperacionProducto>> mProductosByTipo;

    public AlquilerViewModel() {
        mProductosByTipo = new MutableLiveData<>();
    }

    public void getProductosById(int id) {
        Call<List<OperacionProducto>> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).getProductosByTipo(id);
        call.enqueue(new Callback<List<OperacionProducto>>() {
            @Override
            public void onResponse(Call<List<OperacionProducto>> call, Response<List<OperacionProducto>> response) {
                mProductosByTipo.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<OperacionProducto>> call, Throwable t) {
                Log.d("ibai", t.getLocalizedMessage() + "");
            }
        });

    }

    public MutableLiveData<List<OperacionProducto>> getmProductosByTipo() {
        return mProductosByTipo;
    }

    public void setmProductosByTipo(MutableLiveData<List<OperacionProducto>> mProductosByTipo) {
        this.mProductosByTipo = mProductosByTipo;
    }}
