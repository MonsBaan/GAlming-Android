package com.example.galming_android.ui.productos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.galming_android.R;
import com.example.galming_android.adaptador.MainAdaptador;
import com.example.galming_android.databinding.FragmentGalleryBinding;
import com.example.galming_android.ui.gallery.GalleryViewModel;
import com.example.galming_android.ui.home.HomeViewModel;

import java.util.ArrayList;

public class ComprasConTabs extends Fragment
{
    private ComprasViewModel comprasViewModel;
    private Context context;
    private ArrayList<String> arrayString;
    private RecyclerView listaproductoCompra;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
        arrayString = new ArrayList<String>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rellenarDatos();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_compras_con_tabs, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        listaproductoCompra=view.findViewById(R.id.rvProducto);
        listaproductoCompra.setLayoutManager(new LinearLayoutManager(context));

        MainAdaptador adapter = new MainAdaptador(context, arrayString);
        listaproductoCompra.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    private void rellenarDatos(){
        arrayString.add("PSP");
        arrayString.add("PC");
        arrayString.add("PS1");
        arrayString.add("PS2");
        arrayString.add("XBOX");
        arrayString.add("NontengoSwitch");
    }
}