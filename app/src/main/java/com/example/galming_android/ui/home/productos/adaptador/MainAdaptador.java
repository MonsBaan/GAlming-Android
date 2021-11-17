package com.example.galming_android.ui.home.productos.adaptador;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galming_android.MainActivity;
import com.example.galming_android.R;
import com.example.galming_android.ui.home.HomeViewModel;
import com.example.galming_android.ui.retro.clases.TipoProducto;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Timer;

public class MainAdaptador extends RecyclerView.Adapter<MainAdaptador.ViewHolder> {
    private Context context;
    private Bundle bundle;
    private HomeViewModel vmHome;


    public MainAdaptador(Context context) {
        this.context = context;
        vmHome = new HomeViewModel();
        bundle = new Bundle();

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTipo;
        RecyclerView rvProductos;

        public ViewHolder(View v) {
            super(v);
            tvTipo = v.findViewById(R.id.tvTipoProducto);
            rvProductos = v.findViewById(R.id.rvProductos);
        }
    }

    @NonNull
    @Override
    public MainAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*Inflar layout que queremos para cada item */
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler_main, parent, false);
        return new ViewHolder(v);
    }

    /*El objeto en el que estamos haciendo cosas*/
    @Override
    public void onBindViewHolder(@NonNull MainAdaptador.ViewHolder holder, int position) {

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        AdaptadorHomeHorizontalScroll adapter = new AdaptadorHomeHorizontalScroll(context);


        /*
                holder.tvTipo.setText("asdasd");

        holder.rvProductos.setAdapter(adapter);
        holder.rvProductos.setLayoutManager(layoutManager);

        holder.tvTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (holder.tvTipo.getText().equals("PSP")) {
                    bundle.putInt("layout", R.layout.fragment_productos_con_tabs);
                    ((MainActivity) context).cambiarFragmento(R.id.productos, bundle);
                } else {
                    bundle.putInt("layout", R.layout.fragment_productos_sin_tabs);
                    ((MainActivity) context).cambiarFragmento(R.id.productos, bundle);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
