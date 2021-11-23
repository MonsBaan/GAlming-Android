package com.example.galming_android.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.galming_android.MainActivity;
import com.example.galming_android.R;

public class CerrarSesion extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = new Bundle();
        bundle.putInt("layout", R.layout.fragment_home);
        ((MainActivity)getContext()).cambiarFragmento(R.id.nav_home,bundle);
        ((MainActivity)getContext()).estadoLogin(false);
        ((MainActivity)getContext()).getLogin().setUsuId(-1);
        Toast.makeText(getContext(), "Sesion cerrada", Toast.LENGTH_SHORT).show();
        ((MainActivity)getContext() ).loginMenu("","https://almi.eus/wp-content/uploads/2018/06/logo-Almi.jpg");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}