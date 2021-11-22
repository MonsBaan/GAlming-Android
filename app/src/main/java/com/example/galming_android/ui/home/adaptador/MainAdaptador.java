package com.example.galming_android.ui.home.adaptador;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galming_android.MainActivity;
import com.example.galming_android.R;
import com.example.galming_android.ui.home.HomeFragment;
import com.example.galming_android.ui.home.HomeViewModel;
import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.TipoProducto;

import java.util.ArrayList;
import java.util.List;

public class MainAdaptador extends RecyclerView.Adapter<MainAdaptador.ViewHolder> {
    private Context context;
    private Bundle bundle;
    private List<TipoProducto> arrayTipoProducto;
    private List<OperacionProducto> arrayProductos;
    private List<OperacionProducto> arrayProductosFinal;
    private HomeViewModel vmHome;
    private AdaptadorHomeHorizontalScroll adapter;


    public MainAdaptador(Context context, List<TipoProducto> arrayTipoProducto, HomeViewModel vmHome, HomeFragment home) {
        this.context = context;
        this.arrayTipoProducto = arrayTipoProducto;
        this.vmHome = vmHome;

        arrayProductos = new ArrayList<>();
        bundle = new Bundle();

        vmHome.getProductos();
        vmHome.getmAllProductos().observe(home, new Observer<List<OperacionProducto>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChanged(List<OperacionProducto> operacionProductos) {
                arrayProductos.addAll(operacionProductos);
                notifyDataSetChanged();
            }
        });


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
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler_main, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        arrayProductosFinal = new ArrayList<>();

        holder.tvTipo.setText(arrayTipoProducto.get(position).getTipoProdNombre());

        //Este setTag lo uso para pasarle el objeto completo al TextView (Asi lo puedo usar en el listener de debajo)
        holder.tvTipo.setTag(arrayTipoProducto.get(position));

        holder.tvTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ese numero 2 es el id de "Videojuegos"
                if (((TipoProducto) holder.tvTipo.getTag()).getTipoProdId() == 2) {
                    bundle.putInt("layout", R.layout.fragment_productos_con_tabs);
                } else {
                    bundle.putInt("layout", R.layout.fragment_productos_sin_tabs);
                }
                    bundle.putInt("id", ((TipoProducto) holder.tvTipo.getTag()).getTipoProdId());
                ((MainActivity) context).cambiarFragmento(R.id.productos, bundle);

            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);



        if (!arrayProductos.isEmpty()){
            for (OperacionProducto dato : arrayProductos) {
                if (dato.getOpProdProductos().getProdTipo().getTipoProdId() == arrayTipoProducto.get(position).getTipoProdId()){
                    arrayProductosFinal.add(dato);
                }
            }
            adapter = new AdaptadorHomeHorizontalScroll(context, arrayProductosFinal);
            holder.rvProductos.setAdapter(adapter);
            holder.rvProductos.setLayoutManager(layoutManager);
        }
    }

    @Override
    public int getItemCount() {
        return arrayTipoProducto.size();
    }


    @SuppressLint("NotifyDataSetChanged")
    public void setArrayTipoProducto(List<TipoProducto> arrayTipoProducto) {
        this.arrayTipoProducto = arrayTipoProducto;
        notifyDataSetChanged();
    }
}
