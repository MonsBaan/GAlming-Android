package com.example.galming_android;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class GaleriaFragment extends Fragment
{

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_galeria, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        final ImageView ivGaleria1 = view.findViewById(R.id.ivGaleria1);
        final ImageView ivGaleria2 = view.findViewById(R.id.ivGaleria2);
        final ImageView ivGaleria3 = view.findViewById(R.id.ivGaleria3);
        final ImageView ivGaleria4 = view.findViewById(R.id.ivGaleria4);
        final ImageView ivGaleria5 = view.findViewById(R.id.ivGaleria5);
        final ImageView ivGaleria6 = view.findViewById(R.id.ivGaleria6);
        final ImageView ivGaleria7 = view.findViewById(R.id.ivGaleria7);

        ivGaleria1.setImageResource(R.drawable.galeria1);
        ivGaleria2.setImageResource(R.drawable.galeria2);
        ivGaleria3.setImageResource(R.drawable.galeria3);
        ivGaleria4.setImageResource(R.drawable.galeria4);
        ivGaleria5.setImageResource(R.drawable.galeria5);
        ivGaleria6.setImageResource(R.drawable.galeria6);
        ivGaleria7.setImageResource(R.drawable.galeria7);
    }
}