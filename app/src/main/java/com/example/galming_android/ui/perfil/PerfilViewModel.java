package com.example.galming_android.ui.perfil;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.galming_android.ui.retro.clases.Usuario;

public class PerfilViewModel extends ViewModel {

    // TODO: Implement the ViewModel



    private MutableLiveData<Usuario> usuarioMutableLiveData;

    public PerfilViewModel()
    {
        usuarioMutableLiveData = new MutableLiveData<>();
        Usuario usu = new Usuario();
        usuarioMutableLiveData.postValue(usu);
    }

    public MutableLiveData<Usuario> getUsuarioMutableLiveData()
    {
        return usuarioMutableLiveData;
    }

    public void setUsuarioMutableLiveData(Usuario usuarioMutableLiveData)
    {
        this.usuarioMutableLiveData = new MutableLiveData<>();
        this.usuarioMutableLiveData.postValue(usuarioMutableLiveData);
    }
}