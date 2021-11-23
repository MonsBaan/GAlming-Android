package com.example.galming_android.ui.pedidos.detallePedidos;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.galming_android.MainActivity;
import com.example.galming_android.R;
import com.example.galming_android.ui.retro.clases.Servicio;

public class DetallePedidosFragment extends Fragment {

    private DetallePedidosViewModel mViewModel;
    private ImageView ivDetalle;
    private TextView tvPedidoNombre, tvPedidoFecha, tvPedidoPrecio, tvPedidoDesc1, tvPedidoDesc2;
    private Button btnAsistencia;
    private Bundle bundle;
    private Context context;
    private Boolean toggle = false;

    public static DetallePedidosFragment newInstance() {
        return new DetallePedidosFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        bundle = new Bundle();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detalle_pedidos_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Servicio datos = (Servicio) getArguments().getSerializable("producto");

        btnAsistencia = view.findViewById(R.id.btnAsistencia);
        ivDetalle = view.findViewById(R.id.ivDetallePedido);
        tvPedidoNombre = view.findViewById(R.id.tvDetallePedidoNombre);
        tvPedidoFecha = view.findViewById(R.id.tvDetallePedidoFecha);
        tvPedidoPrecio = view.findViewById(R.id.tvDetallePedidoPrecio);
        tvPedidoDesc1 = view.findViewById(R.id.tvDetallePedidoDescripcion1);
        tvPedidoDesc2 = view.findViewById(R.id.tvDetallePedidoDescripcion2);
        tvPedidoDesc2.setVisibility(View.GONE);


        Glide.with(context).load(datos.getServProducto().getProdFoto()).into(ivDetalle);

        tvPedidoNombre.setText(datos.getServDescripcion());
        tvPedidoFecha.setText(datos.getServFecha());
        tvPedidoPrecio.setText(datos.getServPrecioCompra() - ((datos.getServPrecioCompra() * datos.getServDescCompra()) / 100) + "€");
        tvPedidoDesc2.setText(datos.getServProducto().getProdDescripcion());

        tvPedidoDesc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggle) {
                    tvPedidoDesc1.setText(R.string.descripcion_del_producto1);
                    tvPedidoDesc2.setVisibility(View.GONE);
                    toggle = false;

                } else {

                    tvPedidoDesc1.setText(R.string.descripcion_del_producto2);
                    tvPedidoDesc2.setVisibility(View.VISIBLE);
                    toggle = true;
                }


            }
        });

        btnAsistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle.putInt("layout", R.layout.asistencia_fragment);
                bundle.putInt("pedido", datos.getServId());
                ((MainActivity) context).cambiarFragmento(R.id.AsistenciaFragment, bundle);
            }
        });


    }
}