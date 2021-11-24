package com.example.galming_android.ui.perfil;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.galming_android.ui.retro.APIRetroFit;
import com.example.galming_android.ui.retro.RetrofitUtils;
import com.example.galming_android.ui.retro.clases.Usuario;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PerfilViewModel extends ViewModel
{

    // TODO: Implement the ViewModel
    private MutableLiveData<List<Usuario>> usuarioMutableLiveData;
    private MutableLiveData<Usuario> mUsuarioR;

    public PerfilViewModel()
    {
        usuarioMutableLiveData = new MutableLiveData<>();
        mUsuarioR = new MutableLiveData<>();
    }

    public MutableLiveData<List<Usuario>> getUsuarioMutableLiveData()
    {
        return usuarioMutableLiveData;
    }



    public MutableLiveData<Usuario> getmUsuarioR()
    {
        return mUsuarioR;
    }

    public void setmUsuarioR(MutableLiveData<Usuario> mUsuarioR)
    {
        this.mUsuarioR = mUsuarioR;
    }

    public void setUsuarioMutableLiveData(MutableLiveData<List<Usuario>> usuarioMutableLiveData)
    {
        this.usuarioMutableLiveData = usuarioMutableLiveData;
    }

    public void getUsuario(int usuId)
    {
        Call<List<Usuario>> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).getUsuario(usuId);

        call.enqueue(new Callback<List<Usuario>>()
        {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response)
            {
                //METEMOS DATOS
                usuarioMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t)
            {
            }
        });
    }

    public void actualizarUsuario(Usuario dato)
    {
        Call<Usuario> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).actualizarUsuario2(dato);

        call.enqueue(new Callback<Usuario>()
        {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response)
            {
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t)
            {

            }
        });
    }

    public void borrarUsuario(int usuId)
    {
        Call<List<Usuario>> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).borrarUsuario(usuId);
        call.enqueue(new Callback<List<Usuario>>()
        {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response)
            {
                // use response.code, response.headers, etc.
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t)
            {
                // handle failure
            }
        });
    }

    public void insertarUsuario(Usuario usuario)
    {
        Call<Usuario> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).insertarUsuario(usuario);
        call.enqueue(new Callback<Usuario>()
        {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response)
            {
                mUsuarioR.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t)
            {

            }
        });

    }
}