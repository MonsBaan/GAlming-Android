package com.example.galming_android.ui.home.productos;

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
import com.example.galming_android.ui.home.productos.adaptador.AdaptadorAlquiler;

import java.util.ArrayList;

public class FragmentoAlquiler extends Fragment
{
    private RecyclerView recyclerCompra;
    private Context context;
    private ArrayList<String> arrayProductosAlquiler;
    private AdaptadorAlquiler adaptador;



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        arrayProductosAlquiler = new ArrayList();

        View view = inflater.inflate(R.layout.fragment_lista_productos, container, false);
        // Add the following lines to create RecyclerView
        adaptador = new AdaptadorAlquiler(context);
        recyclerCompra = view.findViewById(R.id.rvProductos);
        recyclerCompra.setLayoutManager(new LinearLayoutManager(context));
        recyclerCompra.setAdapter(adaptador);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerCompra = view.findViewById(R.id.rvProductos);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}