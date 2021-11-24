package com.example.galming_android.ui.pedidos.adaptadores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.galming_android.MainActivity;
import com.example.galming_android.R;
import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.Servicio;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPedidos extends RecyclerView.Adapter<AdaptadorPedidos.ViewHolder> {

    private Context context;

    private List<Servicio> arrayPedidos;
    private Bundle bundle;

    public AdaptadorPedidos(Context context) {
        this.context = context;
        bundle = new Bundle();
        arrayPedidos = new ArrayList<>();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
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
    public AdaptadorPedidos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_pedido, parent, false);
        return new AdaptadorPedidos.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Servicio objeto = arrayPedidos.get(position);
        holder.tvNombrePedido.setText(objeto.getServDescripcion());
        holder.tvNombrePedido.setTag(objeto);

        holder.tvPrecioPedido.setText(objeto.getServPrecioCompra() - ((objeto.getServPrecioCompra() * objeto.getServDescCompra())/100)+"€");
        Glide
                .with(context)
                .load(objeto.getServProducto().getProdFoto())
                .into(holder.ivPedido);

        holder.LlItem_Pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Prueba de que funciona
                Toast.makeText(context, holder.tvTipo.getText(), Toast.LENGTH_SHORT).show();
                */

                Servicio tag = (Servicio) holder.tvNombrePedido.getTag();

                bundle.putInt("layout", R.layout.detalle_pedidos_fragment);
                bundle.putSerializable("producto", tag);
                ((MainActivity) context).cambiarFragmento(R.id.DetallePedidosFragment, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayPedidos.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setArrayPedidos(List<Servicio> arrayPedidos) {
        this.arrayPedidos = arrayPedidos;
        notifyDataSetChanged();
    }
}
