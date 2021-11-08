package com.example.galming_android.ui.productos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ComprasViewModel extends ViewModel
{
    private MutableLiveData<String> compras;

    public ComprasViewModel() {
        compras = new MutableLiveData<>();
        compras.setValue("This is compras fragment");
    }

    public LiveData<String> getText() {
        return compras;
    }
}
