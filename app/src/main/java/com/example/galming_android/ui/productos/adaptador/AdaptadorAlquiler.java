package com.example.galming_android.ui.productos.adaptador;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
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

public class AdaptadorAlquiler extends RecyclerView.Adapter<AdaptadorAlquiler.ViewHolder>
{
    private Context context;
    private Bundle bundle;

    public AdaptadorAlquiler(Context context)
    {
        this.context=context;

        bundle = new Bundle();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivCompra;
        TextView tvCompra;
        TextView tvPrecio;
        LinearLayout LL_item_compra;

        public ViewHolder(View v)
        {
            super(v);

            ivCompra = v.findViewById(R.id.ivCompra);
            tvCompra = v.findViewById(R.id.tvCompra);
            tvPrecio = v.findViewById(R.id.tvPrecio);
            LL_item_compra = v.findViewById(R.id.LL_item_compra);
        }
    }

    @NonNull
    @Override
    public AdaptadorAlquiler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_compra, parent, false);
        return new AdaptadorAlquiler.ViewHolder(v);
    }

    /*Por carta*/
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.tvCompra.setText("Assassins creed Sindycate");
        holder.tvPrecio.setText("20€");
        Glide
                .with(context)
                .load("https://images-na.ssl-images-amazon.com/images/I/71FmZGgGRhL.jpg")
                .into(holder.ivCompra);

        holder.LL_item_compra.setOnClickListener(new View.OnClickListener() {
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
        return 10;
    }
}
