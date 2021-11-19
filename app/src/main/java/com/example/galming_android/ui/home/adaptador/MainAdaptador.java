package com.example.galming_android.ui.home.adaptador;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galming_android.MainActivity;
import com.example.galming_android.R;
import com.example.galming_android.ui.home.HomeFragment;
import com.example.galming_android.ui.home.HomeViewModel;
import com.example.galming_android.ui.home.productos.adaptador.AdaptadorHomeHorizontalScroll;
import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.TipoProducto;

import java.util.ArrayList;
import java.util.List;

public class MainAdaptador extends RecyclerView.Adapter<MainAdaptador.ViewHolder> {
    private Context context;
    private Bundle bundle;
    private List<TipoProducto> arrayTipoProducto;
    private List<OperacionProducto> arrayProductos;
    private HomeViewModel vmHome;
    private HomeFragment home;
    private List<AdaptadorHomeHorizontalScroll> adapters =new ArrayList<>();
    private List<List<OperacionProducto>> lists =new ArrayList<>();


    public MainAdaptador(Context context,HomeFragment home, List<TipoProducto> arrayTipoProducto,HomeViewModel vm) {
        this.context = context;
        this.home=home;
        this.arrayTipoProducto = arrayTipoProducto;
        this.arrayProductos = new ArrayList<>();
        this.vmHome=vm;


        vmHome.getmProductos().observe(home, new Observer<List<List<OperacionProducto>>>() {
            @Override
            public void onChanged(List<List<OperacionProducto>> lists) {
                Log.d("aaaaa",lists.toString());
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

        holder.tvTipo.setText(arrayTipoProducto.get(position).getTipoProdNombre());

        //Este setTag lo uso para pasarle el objeto completo al TextView (Asi lo puedo usar en el listener de debajo)
        holder.tvTipo.setTag(arrayTipoProducto.get(position));

        holder.tvTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ese numero 2 es el id de "Videojuegos"
                if (((TipoProducto) holder.tvTipo.getTag()).getTipoProdId() == 2) {
                    bundle.putInt("layout", R.layout.fragment_productos_con_tabs);
                    ((MainActivity) context).cambiarFragmento(R.id.productos, bundle);
                } else {
                    bundle.putInt("layout", R.layout.fragment_productos_sin_tabs);
                    ((MainActivity) context).cambiarFragmento(R.id.productos, bundle);
                }
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        adapters.add(new AdaptadorHomeHorizontalScroll(context,vmHome,position));
        holder.rvProductos.setAdapter(adapters.get(position));
        holder.rvProductos.setLayoutManager(layoutManager);
    }

    @Override
    public int getItemCount() {
        return arrayTipoProducto.size();
    }

    public List<OperacionProducto> getArrayProductos() {
        return arrayProductos;
    }

    public void setArrayProductos(List<OperacionProducto> arrayProductos) {
        this.arrayProductos = arrayProductos;
    }

    public List<TipoProducto> getArrayTipoProducto() {
        return arrayTipoProducto;
    }


    @SuppressLint("NotifyDataSetChanged")
    public void setArrayTipoProducto(List<TipoProducto> arrayTipoProducto) {
        this.arrayTipoProducto = arrayTipoProducto;
        vmHome.getProductosByTipo(arrayTipoProducto);
        notifyDataSetChanged();

    }
}
