package com.example.galming_android.ui.Pedidos.Adaptador;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.galming_android.MainActivity;
import com.example.galming_android.R;
import com.example.galming_android.ui.home.productos.adaptador.AdaptadorCompras;

import java.util.ArrayList;

public class AdaptadorPedidos extends RecyclerView.Adapter<AdaptadorPedidos.ViewHolder>
{

    Context context;

    private ArrayList<String> arrayPedidos;
    private Bundle bundle;

    public AdaptadorPedidos(Context context)
    {
        this.context=context;
        bundle = new Bundle();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivPedido;
        TextView tvNombrePedido;
        TextView tvPrecioPedido;
        LinearLayout LlItem_Pedido;

        public ViewHolder(@NonNull View v) {
            super(v);
            ivPedido = v.findViewById(R.id.ivPedido);
            tvNombrePedido = v.findViewById(R.id.tvNombrePedido);
            tvPrecioPedido = v.findViewById(R.id.tvPrecioPedido);
            LlItem_Pedido = v.findViewById(R.id.LinearPedido);
        }
    }

    @NonNull
    @Override
    public AdaptadorPedidos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(context).inflate(R.layout.item_pedido, parent, false);
        return new AdaptadorPedidos.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.tvNombrePedido.setText("Nombre Pedido");
        holder.tvPrecioPedido.setText(("45€"));
        Glide
                .with(context)
                .load("https://as01.epimg.net/meristation/imagenes/2017/12/26/game_cover/1514294485.jpg")
                .into(holder.ivPedido);

        holder.LlItem_Pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Prueba de que funciona
                Toast.makeText(context, holder.tvTipo.getText(), Toast.LENGTH_SHORT).show();
                */
                bundle.putInt("layout", R.layout.fragment_detalle__producto);
                ((MainActivity) context).cambiarFragmento(R.id.detalle_Producto, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
