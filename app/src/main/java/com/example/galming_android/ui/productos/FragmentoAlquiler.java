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
import com.example.galming_android.ui.productos.adaptador.AdaptadorAlquiler;

import java.util.ArrayList;

public class FragmentoAlquiler extends Fragment
{
    private RecyclerView recyclerAlquiler;
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

        View view = inflater.inflate(R.layout.fragment_fragmento_compras, container, false);
        // Add the following lines to create RecyclerView
        adaptador = new AdaptadorAlquiler(context);
        recyclerAlquiler = view.findViewById(R.id.rvCompra);
        recyclerAlquiler.setLayoutManager(new LinearLayoutManager(context));
        recyclerAlquiler.setAdapter(adaptador);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerAlquiler = view.findViewById(R.id.rvAlquiler);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}