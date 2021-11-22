package com.example.galming_android.ui.home.productos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.galming_android.R;
import com.example.galming_android.ui.home.productos.adaptador.AdaptadorAlquiler;
import com.example.galming_android.ui.retro.clases.OperacionProducto;

import java.util.ArrayList;
import java.util.List;

public class FragmentoAlquiler extends Fragment
{
    private RecyclerView recyclerCompra;
    private Context context;
    private List<OperacionProducto> productosList;
    private AdaptadorAlquiler adaptador;
    private AlquilerViewModel vmAlquiler;
    private Bundle bundle;


    public FragmentoAlquiler(Bundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));
        productosList = new ArrayList<>();
        vmAlquiler = new AlquilerViewModel();

        adaptador = new AdaptadorAlquiler(context);

        vmAlquiler.getProductosById(bundle.getInt("id"));
        vmAlquiler.getmProductosByTipo().observe(this, new Observer<List<OperacionProducto>>() {
            @Override
            public void onChanged(List<OperacionProducto> operacionProductos) {
                for (OperacionProducto dato : operacionProductos) {
                    if (dato.getOpProdOperacion().getOperacionId() == 1) {
                        productosList.add(dato);
                    }
                }
                adaptador.setProductoList(productosList);
            }
        });


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_productos, container, false);
        // Add the following lines to create RecyclerView
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