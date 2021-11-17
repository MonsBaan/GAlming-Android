package com.example.galming_android.ui.home;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.galming_android.ui.retro.APIRetroFit;
import com.example.galming_android.ui.retro.RetrofitUtils;
import com.example.galming_android.ui.retro.clases.TipoProducto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<List<TipoProducto>> mTipoProducto;
    private List<TipoProducto> arrayTipos;

    public HomeViewModel() {
        mTipoProducto = new MutableLiveData<>();
        arrayTipos = new ArrayList<>();
        mTipoProducto.setValue(arrayTipos);

        getTipoProducto();
    }

    public MutableLiveData<List<TipoProducto>> getTipoProducto() {
        Call<List<TipoProducto>> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).getTipoProductos();

        call.enqueue(new Callback<List<TipoProducto>>() {
                         @Override
                         public void onResponse(@NonNull Call<List<TipoProducto>> call, @NonNull Response<List<TipoProducto>> response) {
                             mTipoProducto.getValue().addAll(response.body());

                             Log.d("ibai", "Antes");
                         }

                         @Override
                         public void onFailure(Call<List<TipoProducto>> call, Throwable t) {

                         }
                     }

        );



        /*while (mTipoProducto.getValue().size() == 0){
            if (mTipoProducto.getValue().size()!=0){
                Log.d("ibai", "Despues");
                return mTipoProducto;
            }


        }*/
        Log.d("ibai", "Despues");
        return mTipoProducto;


    }

}