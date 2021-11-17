package com.example.galming_android.ui.perfil;

import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.galming_android.PerfilEliminarDialog;
import com.example.galming_android.R;

public class PerfilFragment extends Fragment {

    private PerfilViewModel mViewModel;
    private Button btnEliminar;
    private PerfilEliminarDialog dialog;
    private Context context;

    public static PerfilFragment newInstance() {
        return new PerfilFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.perfil_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnEliminar = view.findViewById(R.id.btnEliminar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new PerfilEliminarDialog();
                dialog.show(((FragmentActivity) context).getSupportFragmentManager(), "Eliminar Usuario");
            }
        });
    }


}
