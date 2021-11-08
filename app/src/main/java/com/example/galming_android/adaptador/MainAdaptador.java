package com.example.galming_android.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galming_android.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainAdaptador extends RecyclerView.Adapter<MainAdaptador.ViewHolder> {
    private Context context;
    private ArrayList<String> array;

    public MainAdaptador(Context context, ArrayList<String> array)
        {
            this.context = context;
            this.array = array;
        }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTipo;
        RecyclerView rvProductos;

        public ViewHolder(View v) {
            super(v);
            tvTipo = v.findViewById(R.id.tvTipo);
            rvProductos= v.findViewById(R.id.rvProductos);

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
        AdaptadorMainHorizontal adapter = new AdaptadorMainHorizontal(context);

        holder.tvTipo.setText(array.get(position));
        holder.rvProductos.setAdapter(adapter);
        holder.rvProductos.setLayoutManager(layoutManager);

    }

    @Override
    public int getItemCount() {
        return array.size();
    }
}
