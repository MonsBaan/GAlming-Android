package com.example.galming_android.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.galming_android.R;

public class AdaptadorMainHorizontal extends RecyclerView.Adapter<AdaptadorMainHorizontal.ViewHolder> {

private Context context;

    public AdaptadorMainHorizontal(Context context) {
        this.context=context;
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
        Glide.with(context).load("https://assets.mmsrg.com/isr/166325/c1/-/ms-cms-mmes-l16256581/feecms_x_x_x").into(holder.ivProducto);
    }

    @Override
    public int getItemCount() {
        return 10;
    }



}
