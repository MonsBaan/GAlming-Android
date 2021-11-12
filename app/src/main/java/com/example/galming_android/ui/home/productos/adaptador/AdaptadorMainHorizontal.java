package com.example.galming_android.ui.home.productos.adaptador;

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

public class AdaptadorMainHorizontal extends RecyclerView.Adapter<AdaptadorMainHorizontal.ViewHolder>
{
private Context context;
private Bundle bundle;

    public AdaptadorMainHorizontal(Context context) {
        this.context=context;

        bundle = new Bundle();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombreProducto,tvPrecioProducto;
        ImageView ivProducto;

        public ViewHolder(View v) {
            super(v);
            tvNombreProducto = v.findViewById(R.id.tvNombreProducto);
            tvPrecioProducto = v.findViewById(R.id.tvPrecioProducto);
            ivProducto=v.findViewById(R.id.ivProducto);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*Inflar layout que queremos para cada item */
        View v = LayoutInflater.from(context).inflate(R.layout.item_horizontal_recycler_main, parent, false);
        return new ViewHolder(v);
    }
/*El objeto en el que estamos haciendo cosas*/
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvNombreProducto.setText("NombreProducto");
        holder.tvPrecioProducto.setText("500€");
        Glide
                .with(context)
                .load("https://assets.mmsrg.com/isr/166325/c1/-/ms-cms-mmes-l16256581/feecms_x_x_x")
                .into(holder.ivProducto);

        holder.ivProducto.setOnClickListener(new View.OnClickListener() {
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
            public int getItemCount()
            {
                return 5;
            }
}