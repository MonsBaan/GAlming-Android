package com.example.galming_android.ui.home.productos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AlquilerViewModel extends ViewModel
{
    private MutableLiveData<String> compras;

    public AlquilerViewModel() {
        compras = new MutableLiveData<>();
        compras.setValue("This is compras fragment");
    }

    public LiveData<String> getText() {
        return compras;
    }
}
