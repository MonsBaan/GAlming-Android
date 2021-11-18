package com.example.galming_android.ui.home.productos.adaptador;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.galming_android.MainActivity;
import com.example.galming_android.R;
import com.example.galming_android.ui.home.HomeViewModel;
import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.TipoProducto;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorHomeHorizontalScroll extends RecyclerView.Adapter<AdaptadorHomeHorizontalScroll.ViewHolder> {
    private Context context;
    private Bundle bundle;
    private List<OperacionProducto> arrayProductos;
    private HomeViewModel vmHome;
    private int posicion;

    public AdaptadorHomeHorizontalScroll(Context context,HomeViewModel vmHome) {
        this.context = context;
        this.arrayProductos = new ArrayList<>();
        bundle = new Bundle();
        this.vmHome=vmHome;

    }




    public void setArrayProductos(List<OperacionProducto> arrayProductos) {
        this.arrayProductos = arrayProductos;
        notifyDataSetChanged();
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
        holder.tvPrecioProducto.setText("500€");
        Glide
                .with(context)
                .load(arrayProductos.get(position).getOpProdProductos().getProdFoto())
                .into(holder.ivProducto);

        holder.ivProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle.putInt("layout", R.layout.fragment_detalle_producto);
                ((MainActivity) context).cambiarFragmento(R.id.detalle_producto, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
       /* if (arrayProductos != null) {
            return arrayProductos.size();
        } else {
            return 0;
        }*/
        return arrayProductos.size();
    }


}