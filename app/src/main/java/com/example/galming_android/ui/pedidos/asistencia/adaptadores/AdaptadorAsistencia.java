package com.example.galming_android.ui.pedidos.asistencia.adaptadores;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galming_android.R;
import com.example.galming_android.ui.retro.clases.Mensajes;

import java.util.ArrayList;
import java.util.List;


public class AdaptadorAsistencia extends RecyclerView.Adapter<AdaptadorAsistencia.ViewHolder> {
    private Context context;
    private List<Mensajes> mensajesList;

    public AdaptadorAsistencia(Context context) {
        this.context = context;
        mensajesList = new ArrayList<>();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMensaje;
        private LinearLayout LLMensaje;
        public ViewHolder(View v) {
            super(v);
            tvMensaje = v.findViewById(R.id.tvMensaje);
            LLMensaje = v.findViewById(R.id.LLMensaje);
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
        Mensajes mensaje = mensajesList.get(position);
        if (mensaje.getEsTrabajador()){
            holder.tvMensaje.setBackgroundResource(R.drawable.border_mensaje_trabajador);
            holder.LLMensaje.setGravity(Gravity.LEFT);
        }
        holder.tvMensaje.setText(mensaje.getMensaje());
    }

    @Override
    public int getItemCount() {
        return mensajesList.size();
    }


    public void setMensajesList(List<Mensajes> mensajesList) {
        this.mensajesList = mensajesList;
        notifyDataSetChanged();
    }
}
