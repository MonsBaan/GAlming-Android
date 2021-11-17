package com.example.galming_android.ui.home.productos.detalleProducto;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.galming_android.PerfilEliminarDialog;
import com.example.galming_android.ProductoCompraDialog;
import com.example.galming_android.R;

public class DetalleProducto extends Fragment {
    private ImageView ivDetalleProducto;
    private Button btnDetalleProducto;
    private TextView tvDetalleProducto;
    private Context context;
    private ProductoCompraDialog dialog;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getArguments().getInt("layout"), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        btnDetalleProducto = v.findViewById(R.id.btnDetalle);

        btnDetalleProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ProductoCompraDialog();
                dialog.show(((FragmentActivity) context).getSupportFragmentManager(), "Compra");
            }
        });



    }
}