package com.example.galming_android.ui.home.productos;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.galming_android.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ProductosInicio extends Fragment {
    private TabLayout tabProductos;
    private ViewPager2 vpProductos;
    private RecyclerView rvProductos;
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
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getArguments().getInt("layout"), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        vpProductos = view.findViewById(R.id.vpProductosTabs);
        tabProductos = view.findViewById(R.id.tabProductos);

        if (tabProductos == null) {
            String[] string = {"Compras"};

            ViewPagerAdapter adapter = new ViewPagerAdapter(this, string);
            vpProductos.setAdapter(adapter);
        } else {
            String[] string = {"Compras", "Alquiler"};

            ViewPagerAdapter adapter = new ViewPagerAdapter(this, string);
            vpProductos.setAdapter(adapter);
            new TabLayoutMediator(tabProductos, vpProductos,
                    (tab, position) -> tab.setText(string[position])).attach();
        }


    }

    public static class ViewPagerAdapter extends FragmentStateAdapter {
        private String[] array;

        public ViewPagerAdapter(Fragment fragment, String[] array) {
            super(fragment);
            this.array = array;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if (array[position].equals("Compras")) {
                return new FragmentoCompras();
            } else if (array[position].equals("Alquiler")) {
                return new FragmentoAlquiler();
            }
            return null;
        }

        @Override
        public int getItemCount() {
            return array.length;
        }
    }

}