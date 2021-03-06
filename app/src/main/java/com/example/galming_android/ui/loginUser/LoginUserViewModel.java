package com.example.galming_android.ui.loginUser;

import android.content.Context;
import android.location.LocationManager;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.galming_android.ui.retro.APIRetroFit;
import com.example.galming_android.ui.retro.RetrofitUtils;
import com.example.galming_android.ui.retro.clases.Geolocalizacion;
import com.example.galming_android.ui.retro.clases.Usuario;
import com.google.android.gms.location.FusedLocationProviderClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserViewModel extends ViewModel {

    private MutableLiveData<Usuario> mText;
    private MutableLiveData<Geolocalizacion> gmText;
    private MutableLiveData<Usuario> mUserError;


    public LoginUserViewModel() {
        mText = new MutableLiveData<>();
        gmText = new MutableLiveData<>();
        mUserError = new MutableLiveData<>();

    }

    public void loginUsuario(String dni, String password) {

        Call<Usuario> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).loginUsuario(dni, password);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.body()!=null){
                    mText.setValue(response.body());
                }else {
                    mUserError.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
            }
        });

    }

    public void insertarGeolocalizacion(Geolocalizacion datos) {
        Call<Geolocalizacion> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).insertGeo(datos);
        call.enqueue(new Callback<Geolocalizacion>() {
            @Override
            public void onResponse(Call<Geolocalizacion> call, Response<Geolocalizacion> response) {

            }

            @Override
            public void onFailure(Call<Geolocalizacion> call, Throwable t) {

            }
        });

    }

    public MutableLiveData<Geolocalizacion> getGmText() { return gmText; }

    public void setGmText(MutableLiveData<Geolocalizacion> gmText) {
        this.gmText = gmText;
    }

    public MutableLiveData<Usuario> getmText() {
        return mText;
    }

    public void setmText(MutableLiveData<Usuario> mText) {
        this.mText = mText;
    }

    public MutableLiveData<Usuario> getmUserError() {
        return mUserError;
    }

    public void setmUserError(MutableLiveData<Usuario> mUserError) {
        this.mUserError = mUserError;
    }
}
