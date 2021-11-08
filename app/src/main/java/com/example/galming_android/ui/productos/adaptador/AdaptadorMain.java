package com.example.galming_android.ui.productos.adaptador;

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
import com.example.galming_android.adaptador.AdaptadorMainHorizontal;

public class AdaptadorMain extends RecyclerView.Adapter<AdaptadorMain.ViewHolder>
{
    Context context;

    public AdaptadorMain(Context context)
    {
        this.context=context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivCompra;
        TextView tvCompra;

        public ViewHolder(View v) {
            super(v);

            ivCompra = v.findViewById(R.id.ivCompra);
            tvCompra = v.findViewById(R.id.tvCompra);


        }
    }

    @NonNull
    @Override
    public AdaptadorMain.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_compra, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorMain.ViewHolder holder, int position) {
        holder.tvCompra.setText("Assassins creed Unity");
        Glide.with(context).load("https://as01.epimg.net/meristation/imagenes/2017/12/26/game_cover/1514294485.jpg").into(holder.ivCompra);
    }


    @Override
    public int getItemCount() {
        return 30;
    }
}
