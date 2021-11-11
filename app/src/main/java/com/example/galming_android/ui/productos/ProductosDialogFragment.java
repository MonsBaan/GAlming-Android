package com.example.galming_android.ui.productos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.example.galming_android.R;

public class ProductosDialogFragment extends DialogFragment
{
    private TextView tvDialog;
    private ImageView ivDialog;
    private Context context;

    public ProductosDialogFragment() {
        super();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setTitle("Imagen");

        return dialog;
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_productos_view_pager, container, false);

        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String texto = getArguments().getString("texto");
        String imagenUrl = getArguments().getString("imagen");

        ivDialog = view.findViewById(R.id.ivDialog);

        Glide.with(context)
                .load(imagenUrl)
                .into(ivDialog);

        Toast.makeText(context, texto, Toast.LENGTH_SHORT).show();



        //IBAI: Esto me parece un poco overkill, pero ha servido para cerrar el dialog al presionar en cualquier lado
        LinearLayout LLDialog = view.findViewById(R.id.LLDialog);
        LLDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }

}
