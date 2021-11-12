package com.example.galming_android.ui.home.productos.adaptador;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.galming_android.R;
import com.example.galming_android.ui.home.productos.ProductosInicio;

public class Compras_Sin_Tabs extends Fragment
{

    private ViewPager2 vpProductos = null;

    public static ProductosInicio newInstance() {
        return new ProductosInicio();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slideman));
         */
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_compras__sin__tabs, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vpProductos = view.findViewById(R.id.vpProductos);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        vpProductos.setAdapter(adapter);

    }

}