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

import com.bumptech.glide.Glide;

import java.util.ArrayList;


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
        
        Glide.with(this).load(R.drawable.galeria1).into(ivGaleria1);
        Glide.with(this).load(R.drawable.galeria2).into(ivGaleria2);
        Glide.with(this).load(R.drawable.galeria3).into(ivGaleria3);
        Glide.with(this).load(R.drawable.galeria4).into(ivGaleria4);
        Glide.with(this).load(R.drawable.galeria5).into(ivGaleria5);
        Glide.with(this).load(R.drawable.galeria6).into(ivGaleria6);
        Glide.with(this).load(R.drawable.galeria7).into(ivGaleria7);

    }
}