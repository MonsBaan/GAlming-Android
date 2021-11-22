package com.example.galming_android.ui.home.adaptador;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.galming_android.MainActivity;
import com.example.galming_android.R;
import com.example.galming_android.ui.home.HomeViewModel;
import com.example.galming_android.ui.retro.clases.OperacionProducto;

import java.util.List;

public class AdaptadorHomeHorizontalScroll extends RecyclerView.Adapter<AdaptadorHomeHorizontalScroll.ViewHolder> {
    private Context context;
    private HomeViewModel vmHome;
    private Bundle bundle;
    private int posicion;
    private List<OperacionProducto> arrayProductos;

    public AdaptadorHomeHorizontalScroll(Context context, List<OperacionProducto> arrayProductos) {
        this.arrayProductos = arrayProductos;
        this.context = context;

        bundle = new Bundle();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombreProducto, tvPrecioProducto;
        ImageView ivProducto;

        public ViewHolder(View v) {
            super(v);
            tvNombreProducto = v.findViewById(R.id.tvHomeItemNombre);
            tvPrecioProducto = v.findViewById(R.id.tvHomeItemProducto);
            ivProducto = v.findViewById(R.id.ivHomeItem);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*Inflar layout que queremos para cada item */
        View v = LayoutInflater.from(context).inflate(R.layout.item_horizontal_scroll_home, parent, false);
        return new ViewHolder(v);
    }

    /*El objeto en el que estamos haciendo cosas*/
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNombreProducto.setText(arrayProductos.get(position).getOpProdProductos().getProdNombre());
        float precioFinal = arrayProductos.get(position).getOpProdPrecio()-((arrayProductos.get(position).getOpProdPrecio()*arrayProductos.get(position).getOpProdDescuento())/100);
        holder.tvPrecioProducto.setText(precioFinal + "€");

        holder.ivProducto.setTag(arrayProductos.get(position));

        Glide.with(context)
                .load(arrayProductos.get(position).getOpProdProductos().getProdFoto())
                .into(holder.ivProducto);


        holder.ivProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperacionProducto tag = (OperacionProducto) holder.ivProducto.getTag();

                bundle.putInt("layout", R.layout.fragment_detalle_producto);
                bundle.putSerializable("producto", tag);

                ((MainActivity) context).cambiarFragmento(R.id.detalle_producto, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayProductos.size();
    }


}