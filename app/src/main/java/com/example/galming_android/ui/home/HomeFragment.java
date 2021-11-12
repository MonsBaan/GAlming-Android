package com.example.galming_android.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galming_android.R;
import com.example.galming_android.ui.home.productos.adaptador.MainAdaptador;
import com.example.galming_android.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private Context context;
    private RecyclerView listaTipoProductos;
    private ArrayList<String> arrayString;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
        arrayString = new ArrayList<String>();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rellenarDatos();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        listaTipoProductos=view.findViewById(R.id.rvProducto);
        listaTipoProductos.setLayoutManager(new LinearLayoutManager(context));

        MainAdaptador adapter = new MainAdaptador(context, arrayString);
        listaTipoProductos.setAdapter(adapter);
    }


    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }

    private void rellenarDatos()
    {
        arrayString.add("PSP");
        arrayString.add("PC");
        arrayString.add("PS1");
        arrayString.add("PS2");
        arrayString.add("XBOX");
        arrayString.add("NontengoSwitch");
    }
}