package com.example.galming_android.ui.pedidos.asistencia;

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
import com.example.galming_android.ui.pedidos.asistencia.adaptadores.AdaptadorAsistencia;
import com.example.galming_android.ui.retro.clases.Mensajes;

import java.util.List;

public class AsistenciaFragment extends Fragment {

    private AsistenciaViewModel vmAsistencia;
    private Context context;
    private RecyclerView rvMensajes;
    private AdaptadorAsistencia adaptadorAsistencia;

    public static AsistenciaFragment newInstance() {
        return new AsistenciaFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        vmAsistencia = new AsistenciaViewModel();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));
        adaptadorAsistencia = new AdaptadorAsistencia(context);

        vmAsistencia.getMensajes(getArguments().getInt("pedido"));
        vmAsistencia.getmMensajes().observe(this, new Observer<List<Mensajes>>() {
            @Override
            public void onChanged(List<Mensajes> mensajes) {
                adaptadorAsistencia.setMensajesList(mensajes);
            }
        });

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.asistencia_fragment, container, false);

        // Add the following lines to create RecyclerView
        rvMensajes = view.findViewById(R.id.rvMensajesAsistencia);
        rvMensajes.setLayoutManager(new LinearLayoutManager(context));
        rvMensajes.setAdapter(adaptadorAsistencia);
        return view;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}