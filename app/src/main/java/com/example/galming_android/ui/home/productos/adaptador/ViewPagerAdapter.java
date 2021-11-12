package com.example.galming_android.ui.home.productos.adaptador;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.galming_android.ui.home.productos.FragmentoCompras;
import com.example.galming_android.ui.home.productos.FragmentoAlquiler;

public class ViewPagerAdapter extends FragmentStateAdapter{



        public ViewPagerAdapter(Fragment fragment)
        {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {

            if (position == 0)
            {
                return new FragmentoCompras();

            }
            else
            {
                return new FragmentoAlquiler();
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }


