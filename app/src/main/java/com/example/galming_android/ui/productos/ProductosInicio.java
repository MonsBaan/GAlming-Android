package com.example.galming_android.ui.productos;

import android.content.Context;
import android.os.Bundle;

import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.example.galming_android.R;
import com.example.galming_android.ui.productos.adaptador.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ProductosInicio extends Fragment
{
    private TabLayout tabProductos = null;
    private ViewPager2 vpProductos = null;
    private Context context;

    public static ProductosInicio newInstance() {
        return new ProductosInicio();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
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
        return inflater.inflate(getArguments().getInt("layout"), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vpProductos = view.findViewById(R.id.vpProductos);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        vpProductos.setAdapter(adapter);

        if (view.findViewById(R.id.tabProductos)!=null){
            tabProductos = view.findViewById(R.id.tabProductos);


            String[] string = {"Compras", "Alquiler"};

            new TabLayoutMediator(tabProductos, vpProductos,
                    (tab, position) -> tab.setText(string[position])).attach();
        }

    }

}