package com.example.galming_android.ui.pedidos;

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
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.galming_android.MainActivity;
import com.example.galming_android.ui.pedidos.adaptadores.AdaptadorPedidos;
import com.example.galming_android.R;
import com.example.galming_android.ui.pedidos.adaptadores.SpinnerAdapter;
import com.example.galming_android.ui.retro.clases.Servicio;
import com.example.galming_android.ui.retro.clases.TipoProducto;
import com.example.galming_android.ui.retro.clases.TipoServicio;

import java.util.ArrayList;
import java.util.List;

public class Pedidos extends Fragment {

    private PedidosViewModel vmPedidos;
    private RecyclerView listaPedidos;
    private Context context;
    private AdaptadorPedidos adapter;
    private SpinnerAdapter adapterSP;
    private Spinner sp;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        vmPedidos = new PedidosViewModel();
        adapter = new AdaptadorPedidos(context);
        adapterSP = new SpinnerAdapter(context, R.layout.spinner_per);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));

        vmPedidos.getTipoServicios();
        vmPedidos.getmTipoProducto().observe(this, new Observer<List<TipoServicio>>() {
            @Override
            public void onChanged(List<TipoServicio> tipoProductos) {
                adapterSP.setArrayTipos(tipoProductos);
            }
        });

        vmPedidos.getmServicios().observe(this, new Observer<List<Servicio>>() {
            @Override
            public void onChanged(List<Servicio> servicios) {
                adapter.setArrayPedidos(servicios);

            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pedidos_fragment, container, false);
        listaPedidos = view.findViewById(R.id.rvPedidos);
        listaPedidos.setLayoutManager(new LinearLayoutManager(context));
        listaPedidos.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listaPedidos = view.findViewById(R.id.rvPedidos);
        /*-----------*/
        sp = view.findViewById(R.id.spPedidos);
        sp.setAdapter(adapterSP);
        /*----------*/


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                vmPedidos.getServiciosTipoUser(vmPedidos.getmTipoProducto().getValue().get(i).getTipoServId()+"", ((MainActivity)context).getLogin().getUsuId()+"");

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}