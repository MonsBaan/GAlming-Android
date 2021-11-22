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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.galming_android.R;
import com.example.galming_android.ui.home.productos.adaptador.AdaptadorCompra;
import com.example.galming_android.ui.retro.clases.OperacionProducto;

import java.util.ArrayList;
import java.util.List;

public class FragmentoCompras extends Fragment {
    private RecyclerView listaproductoCompra;
    private Context contexto;
    private List<OperacionProducto> productosList;
    private AdaptadorCompra adapter;
    private ComprasViewModel vmCompras;
    private Bundle bundle;

    public FragmentoCompras(Bundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));
        productosList = new ArrayList<>();
        vmCompras = new ComprasViewModel();
        adapter = new AdaptadorCompra(contexto);


        vmCompras.getProductosById(bundle.getInt("id"));
        vmCompras.getmProductosByTipo().observe(this, new Observer<List<OperacionProducto>>() {
            @Override
            public void onChanged(List<OperacionProducto> operacionProductos) {
                for (OperacionProducto dato : operacionProductos) {
                    if (dato.getOpProdOperacion().getOperacionId() == 2) {
                        productosList.add(dato);
                    }
                }
                adapter.setProductoList(productosList);
            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.contexto = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_productos, container, false);
        // Add the following lines to create RecyclerView
        listaproductoCompra = view.findViewById(R.id.rvProductos);
        listaproductoCompra.setLayoutManager(new LinearLayoutManager(contexto));
        listaproductoCompra.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listaproductoCompra = view.findViewById(R.id.rvProductos);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}