package com.example.galming_android.ui.pedidos.asistencia;

import androidx.lifecycle.ViewModelProvider;

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

public class AsistenciaFragment extends Fragment {

    private AsistenciaViewModel mViewModel;
    private Context context;
    private RecyclerView rvMensajes;
    private AdaptadorAsistencia adaptadorAsistencia;

    public static AsistenciaFragment newInstance() {
        return new AsistenciaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        String[] mensajes = {"HolaHolaHolaHolaHolaHolaHolaHolaHolaHola", "hola"};

        View view = inflater.inflate(R.layout.asistencia_fragment, container, false);

        // Add the following lines to create RecyclerView
        adaptadorAsistencia = new AdaptadorAsistencia(context, mensajes);
        rvMensajes = view.findViewById(R.id.rvMensajesAsistencia);
        rvMensajes.setLayoutManager(new LinearLayoutManager(context));
        rvMensajes.setAdapter(adaptadorAsistencia);
        return view;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}