package com.example.galming_android.ui.busqueda;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.galming_android.R;
import com.example.galming_android.ui.home.productos.adaptador.AdaptadorCompra;
import com.example.galming_android.ui.pedidos.adaptadores.AdaptadorPedidos;
import com.example.galming_android.ui.retro.clases.OperacionProducto;

import java.util.List;

public class BusquedaFragment extends Fragment {

    private BusquedaViewModel mViewModel;
    private RecyclerView rvBusqueda;
    private Context context;
    private AdaptadorCompra adapter;

    public static BusquedaFragment newInstance() {
        return new BusquedaFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new BusquedaViewModel();

        adapter = new AdaptadorCompra(context);

        mViewModel.getProductos(getArguments().getString("busqueda"));
        mViewModel.getmAllProductos().observe(this, new Observer<List<OperacionProducto>>() {
            @Override
            public void onChanged(List<OperacionProducto> operacionProductos) {
                adapter.setProductoList(operacionProductos);
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.busqueda_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvBusqueda = view.findViewById(R.id.rvBusqueda);

        rvBusqueda.setLayoutManager(new LinearLayoutManager(context));
        rvBusqueda.setAdapter(adapter);
    }
}