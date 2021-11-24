package com.example.galming_android.ui.pedidos.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.galming_android.R;
import com.example.galming_android.ui.pedidos.PedidosViewModel;
import com.example.galming_android.ui.retro.clases.TipoProducto;
import com.example.galming_android.ui.retro.clases.TipoServicio;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends ArrayAdapter
{
    private Context context = null;
    private List<TipoServicio> arrayTipos;


    public SpinnerAdapter(@NonNull Context context, int resource ) {
        super(context, resource);
        this.context = context;
        arrayTipos = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return arrayTipos.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View fila = inflater.inflate(R.layout.spinner_per, parent, false);
        TextView textoFila = fila.findViewById(R.id.tvSpinner);

        textoFila.setText(arrayTipos.get(position).getTipoServNombre());

        return fila;
    }

    public void setArrayTipos(List<TipoServicio> arrayTipos) {
        this.arrayTipos = arrayTipos;
        notifyDataSetChanged();
    }
}
