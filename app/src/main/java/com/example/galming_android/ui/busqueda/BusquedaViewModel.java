package com.example.galming_android.ui.busqueda;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.galming_android.ui.retro.APIRetroFit;
import com.example.galming_android.ui.retro.RetrofitUtils;
import com.example.galming_android.ui.retro.clases.OperacionProducto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusquedaViewModel extends ViewModel {
    private final MutableLiveData<List<OperacionProducto>> mAllProductos;
    // TODO: Implement the ViewModel

    public BusquedaViewModel() {
        mAllProductos = new MutableLiveData<>();
    }

    public void getProductos(String busqueda) {
        Call<List<OperacionProducto>> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).getProductosBusqueda(busqueda);
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

    public MutableLiveData<List<OperacionProducto>> getmAllProductos() {
        return mAllProductos;
    }
}