package com.example.galming_android;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SobreNosotrosFragment extends Fragment
{
    private Context context;

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_sobre_nosotros, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        final ImageView ivFotoAlmi = view.findViewById(R.id.ivSobreNosotros);
        final TextView tvSobre = view.findViewById(R.id.tvSobreNosotros);

        ivFotoAlmi.setImageResource(R.drawable.sobre);
        tvSobre.setText("El Centro de Estudios ALMI es un centro privado, concertado y homologado por el Departamento de Educación, Política Lingüística y Cultura para impartir enseñanzas de FP, en las ramas administrativa, informática y sanitaria. La formación se imparte tanto a alumnado procedente de sistema educativo, como a personas en activo que desean reciclarse o están en situación de desempleo. La adaptación constante de la oferta formativa a las necesidades del mercado laboral y el mantenimiento del compromiso con el entorno económico-social se encuentra recogida en la Misión y Valores del Centro.");
    }
}