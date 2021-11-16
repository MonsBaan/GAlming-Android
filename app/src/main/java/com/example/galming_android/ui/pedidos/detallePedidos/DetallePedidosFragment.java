package com.example.galming_android.ui.pedidos.detallePedidos;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.galming_android.MainActivity;
import com.example.galming_android.R;

public class DetallePedidosFragment extends Fragment {

    private DetallePedidosViewModel mViewModel;
    private Button btnAsistencia;
    private Bundle bundle;
    private Context context;

    public static DetallePedidosFragment newInstance() {
        return new DetallePedidosFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        bundle = new Bundle();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detalle_pedidos_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnAsistencia = view.findViewById(R.id.btnAsistencia);

        btnAsistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putInt("layout", R.layout.asistencia_fragment);
                ((MainActivity) context).cambiarFragmento(R.id.AsistenciaFragment, bundle);
            }
        });

    }
}