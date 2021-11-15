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
import android.widget.Spinner;

import com.example.galming_android.ui.productos.adaptadores.AdaptadorProductos;
import com.example.galming_android.R;
import com.example.galming_android.ui.productos.adaptadores.SpinnerAdapter;

import java.util.ArrayList;

public class Productos extends Fragment {

    private ProductosViewModel mViewModel;
    private RecyclerView listaPedidos;
    private Context context;
    private ArrayList<String> arrayPedidos;
    private AdaptadorProductos adapter;
    private Spinner sp = null;
    private int ver=0;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        arrayPedidos = new ArrayList<>();

        View view = inflater.inflate(R.layout.pedidos_fragment, container, false);
        adapter = new AdaptadorProductos(context);
        listaPedidos = view.findViewById(R.id.rvPedidos);
        listaPedidos.setLayoutManager(new LinearLayoutManager(context));
        listaPedidos.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listaPedidos=view.findViewById(R.id.rvPedidos);
        /*-----------*/
        sp=view.findViewById(R.id.spPedidos);
        String[] datos = getResources().getStringArray(R.array.cursos);
        SpinnerAdapter adapter = new SpinnerAdapter(context, R.layout.spinner_per, datos);
        sp.setAdapter(adapter);
        /*----------*/
    }

    @Override
    public void onDestroyView()
        {
            super.onDestroyView();
        }
}