package com.example.galming_android.ui.home.productos.adaptador;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.util.Log;
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
import com.example.galming_android.ui.home.adaptador.MainAdaptador;
import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.TipoProducto;

import java.util.ArrayList;
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
        Log.d("ibai", arrayProductos.get(position).getOpProdProductos().getProdNombre());

        holder.tvNombreProducto.setText(arrayProductos.get(position).getOpProdProductos().getProdNombre());
        holder.tvPrecioProducto.setText(arrayProductos.get(position).getOpProdPrecio() + "€");


        Glide.with(context)
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
        return arrayProductos.size();
    }


}