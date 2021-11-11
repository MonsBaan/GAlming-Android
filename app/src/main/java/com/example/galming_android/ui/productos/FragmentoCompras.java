package com.example.galming_android.ui.productos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.galming_android.R;
import com.example.galming_android.ui.productos.adaptador.AdaptadorCompras;

import java.util.ArrayList;

public class FragmentoCompras extends Fragment
{
    private RecyclerView listaproductoCompra;
    private Context contexto;
    private ArrayList<String> arrayProductosCompra;
    private AdaptadorCompras adapter;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.contexto=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        arrayProductosCompra = new ArrayList();

        View view = inflater.inflate(R.layout.fragment_fragmento_compras, container, false);
        // Add the following lines to create RecyclerView
        adapter = new AdaptadorCompras(contexto);
        listaproductoCompra = view.findViewById(R.id.rvCompra);
            listaproductoCompra.setLayoutManager(new LinearLayoutManager(contexto));
            listaproductoCompra.setAdapter(adapter);
            return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        listaproductoCompra = view.findViewById(R.id.rvCompra);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}