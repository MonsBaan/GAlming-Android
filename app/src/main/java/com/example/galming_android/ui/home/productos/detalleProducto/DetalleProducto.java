package com.example.galming_android.ui.home.productos.detalleProducto;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;

import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.galming_android.MainActivity;
import com.example.galming_android.PerfilEliminarDialog;
import com.example.galming_android.ProductoCompraDialog;
import com.example.galming_android.R;
import com.example.galming_android.ui.home.HomeViewModel;
import com.example.galming_android.ui.retro.clases.OperacionProducto;

public class DetalleProducto extends Fragment {
    private TextView tvDetalleNombre, tvDetalleStock, tvDetallePrecio, tvDetalleDescuento, tvDetalleDescripcion, tvDesc, tvDetallePrecioViejo;
    private ImageView ivDetalleProducto;

    private Button btnDetalleProducto;
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
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getArguments().getInt("layout"), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        OperacionProducto producto = (OperacionProducto) getArguments().getSerializable("producto");


        tvDetalleNombre = v.findViewById(R.id.tvDetalleNombre);
        ivDetalleProducto = v.findViewById(R.id.ivDetalle);
        btnDetalleProducto = v.findViewById(R.id.btnDetalle);
        tvDetalleStock = v.findViewById(R.id.tvDetalleStock);
        tvDetallePrecio = v.findViewById(R.id.tvDetallePrecio);
        tvDetallePrecioViejo = v.findViewById(R.id.tvDetallePrecioViejo);
        tvDetalleDescuento = v.findViewById(R.id.tvDetalleDescuento);
        tvDetalleDescripcion = v.findViewById(R.id.tvDetalleDescripcion);
        tvDesc = v.findViewById(R.id.detalleTextView);

        tvDetalleNombre.setText(producto.getOpProdProductos().getProdNombre());
        Glide.with(context)
                .load(producto.getOpProdProductos().getProdFoto())
                .into(ivDetalleProducto);
        btnDetalleProducto.setText(producto.getOpProdOperacion().getOperacionDescripcion());
        tvDetalleStock.setText(producto.getOpProdStock() + " en stock");

        float precio = producto.getOpProdPrecio() - ((producto.getOpProdPrecio() * producto.getOpProdDescuento()) / 100);
        tvDetallePrecio.setText(precio + "€");

        tvDetallePrecioViejo.setText(producto.getOpProdPrecio() + "€");
        tvDetallePrecioViejo.setPaintFlags(tvDetallePrecio.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        tvDetalleDescuento.setText("-" + producto.getOpProdDescuento() + "%");
        tvDetalleDescripcion.setText(producto.getOpProdProductos().getProdDescripcion());

        if(producto.getOpProdDescuento() == 0){
            tvDetallePrecioViejo.setVisibility(View.GONE);
            tvDetalleDescuento.setVisibility(View.GONE);
        }

        if (producto.getOpProdStock() <= 0) {
            btnDetalleProducto.setEnabled(false);
        }
        if (((MainActivity) context).getLogin().getUsuId() < 0) {
            btnDetalleProducto.setVisibility(View.GONE);
        }


        btnDetalleProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ProductoCompraDialog();
                dialog.show(((FragmentActivity) context).getSupportFragmentManager(), "Compra");
            }
        });


    }

}