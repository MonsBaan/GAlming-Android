package com.example.galming_android.ui.pedidos.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galming_android.R;


public class AdaptadorAsistencia extends RecyclerView.Adapter<AdaptadorAsistencia.ViewHolder> {
    private Context context;
    private String[] data;

    public AdaptadorAsistencia(Context context, String[] data) {
        this.context = context;
        this.data = data;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMensaje;
        public ViewHolder(View v) {
            super(v);
            tvMensaje = v.findViewById(R.id.tvMensaje);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.asistencia_mensaje_cliente, parent, false);
        return new AdaptadorAsistencia.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvMensaje.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

}
