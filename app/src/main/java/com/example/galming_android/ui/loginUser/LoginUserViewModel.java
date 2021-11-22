package com.example.galming_android.ui.loginUser;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.galming_android.ui.retro.APIRetroFit;
import com.example.galming_android.ui.retro.RetrofitUtils;
import com.example.galming_android.ui.retro.clases.Usuario;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserViewModel extends ViewModel {

    private MutableLiveData<Usuario> mText;

    public LoginUserViewModel() {
        mText = new MutableLiveData<>();


    }

    public void loginUsuario(String dni, String password){

        Call<Usuario> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).loginUsuario(dni, password);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Log.d("ibai", response.body().getUsuNombre()+"");

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.d("ibai", t.getLocalizedMessage()+"");

            }
        });

    }
}
