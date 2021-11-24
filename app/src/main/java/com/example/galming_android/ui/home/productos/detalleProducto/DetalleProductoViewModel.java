package com.example.galming_android.ui.home.productos.detalleProducto;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.galming_android.ui.retro.APIRetroFit;
import com.example.galming_android.ui.retro.RetrofitUtils;
import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.Servicio;
import com.example.galming_android.ui.retro.clases.ServicioEnvio;
import com.example.galming_android.ui.retro.clases.StockChange;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleProductoViewModel extends ViewModel {
    private MutableLiveData<StockChange> mServ;


    public DetalleProductoViewModel() {
        mServ = new MutableLiveData<>();
    }

    public void comprarProducto(int usuID, int prodID, int idTipo, String desc, String fechaDev, float precioCompra, int descuentoCompra) {
        ServicioEnvio servicioEnvio = new ServicioEnvio(fechaDev, desc, precioCompra, descuentoCompra, usuID, idTipo, prodID);

        Call<ServicioEnvio> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).comprarProducto(servicioEnvio);

        call.enqueue(new Callback<ServicioEnvio>() {
            @Override
            public void onResponse(Call<ServicioEnvio> call, Response<ServicioEnvio> response) {
                cambiarStock(prodID);
            }

            @Override
            public void onFailure(Call<ServicioEnvio> call, Throwable t) {

            }
        });
    }

    private void cambiarStock(int prodID){
        StockChange stockChange = new StockChange(prodID+"");
        Call<StockChange> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).updateStock(stockChange);
            call.enqueue(new Callback<StockChange>() {
                @Override
                public void onResponse(Call<StockChange> call, Response<StockChange> response) {
                    mServ.setValue(response.body());

                }

                @Override
                public void onFailure(Call<StockChange> call, Throwable t) {

                }
            });

    }



    public MutableLiveData<StockChange> getmServ() {
        return mServ;
    }

}
