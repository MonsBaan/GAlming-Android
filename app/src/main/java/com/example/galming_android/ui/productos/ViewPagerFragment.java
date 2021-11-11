package com.example.galming_android.ui.productos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.galming_android.R;

public class ViewPagerFragment extends Fragment
{
    public static final String ARG_OBJECT = "object";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (getArguments().getInt(ARG_OBJECT)==1)
        {
            return  inflater.inflate(R.layout.fragment_fragmento_compras, container, false);
        }
        else
        {
            return inflater.inflate(R.layout.fragment_fragmento_alquiler, container, false);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        Bundle args = getArguments();
    }
}
