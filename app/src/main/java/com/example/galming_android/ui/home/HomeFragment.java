package com.example.galming_android.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galming_android.MainActivity;
import com.example.galming_android.R;
import com.example.galming_android.ui.home.adaptador.MainAdaptador;
import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.TipoProducto;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private Context context;
    private RecyclerView listaTipoProductos;
    private HomeViewModel vmHome;
    private MainAdaptador adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));

        adapter = new MainAdaptador(context,this, new ArrayList<>());

        vmHome = new HomeViewModel();
        //IBAI: Me he matado para conseguir esto, pero ha valido la pena
        //Lanzamos la funcion de la cual queremos recoger datos
        vmHome.getTiposProducto();
        //Observamos el Array de los tipos de producto, para que cuando haya un cambio, refrescar la pantalla usando el onViewCreated
        vmHome.getmTipoProducto().observe(this, new Observer<List<TipoProducto>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChanged(List<TipoProducto> tipoProductos) {
                adapter.setArrayTipoProducto(tipoProductos);
            }
        });


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vmHome.getmTipoProducto();

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listaTipoProductos = view.findViewById(R.id.rvProducto);
        listaTipoProductos.setLayoutManager(new LinearLayoutManager(context));
        listaTipoProductos.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MainActivity main = (MainActivity) getActivity();
        main.removeBar(View.GONE);
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity main = (MainActivity) getActivity();
        main.removeBar(View.VISIBLE);
    }

}