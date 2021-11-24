package com.example.galming_android.ui.home.productos.adaptador;

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

import java.util.ArrayList;
import java.util.List;

public class AdaptadorCompra extends RecyclerView.Adapter<AdaptadorCompra.ViewHolder> {
    Context context;
    private List<OperacionProducto> productoList;
    private Bundle bundle;


    public AdaptadorCompra(Context context) {
        productoList = new ArrayList<>();
        this.context = context;
        bundle = new Bundle();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCompra;
        TextView tvCompra;
        TextView tvPrecio;
        LinearLayout LL_item_compra;

        public ViewHolder(View v) {
            super(v);

            ivCompra = v.findViewById(R.id.ivItemCompra);
            tvCompra = v.findViewById(R.id.tvItemCompraNombre);
            tvPrecio = v.findViewById(R.id.tvItemCompraPrecio);
            LL_item_compra = v.findViewById(R.id.LL_item_compra);
        }
    }

    @NonNull
    @Override
    public AdaptadorCompra.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_compra, parent, false);
        return new ViewHolder(v);
    }

    /*Por carta*/
    @Override
    public void onBindViewHolder(@NonNull AdaptadorCompra.ViewHolder holder, int position) {
        if(productoList.size()!=0){
            OperacionProducto producto = productoList.get(position);
            holder.tvCompra.setText(producto.getOpProdProductos().getProdNombre());
            holder.tvCompra.setTag(producto);
            float precioFinal = producto.getOpProdPrecio() - ((producto.getOpProdPrecio()*producto.getOpProdDescuento())/100);

            holder.tvPrecio.setText(precioFinal+"€");
            Glide
                    .with(context)
                    .load(producto.getOpProdProductos().getProdFoto())
                    .into(holder.ivCompra);

            holder.LL_item_compra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    OperacionProducto tag = (OperacionProducto) holder.tvCompra.getTag();

                    bundle.putInt("layout", R.layout.fragment_detalle_producto);
                    bundle.putSerializable("producto", tag);
                    ((MainActivity) context).cambiarFragmento(R.id.detalle_producto, bundle);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }


    @SuppressLint("NotifyDataSetChanged")
    public void setProductoList(List<OperacionProducto> productoList) {
        this.productoList = productoList;
        notifyDataSetChanged();
    }
}
