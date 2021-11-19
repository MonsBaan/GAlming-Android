package com.example.galming_android;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.galming_android.ui.home.HomeFragment;
import com.example.galming_android.ui.perfil.PerfilFragment;
import com.example.galming_android.ui.perfil.PerfilViewModel;
import com.example.galming_android.ui.retro.clases.Usuario;

import java.util.List;

public class PerfilEliminarDialog extends DialogFragment {
    private Context context;
    private PerfilViewModel mViewModel;
    private int usuId;

    public PerfilEliminarDialog(PerfilViewModel mViewModel, int usuId) {
        this.mViewModel = mViewModel;
        this.usuId=usuId;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Eliminar");
        builder.setMessage("¿Está seguro que quiere eliminar este usuario?")
                .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Toast.makeText(context, "Usuario Eliminado", Toast.LENGTH_SHORT).show();
                        mViewModel.borrarUsuario(usuId);
                        Bundle bundle = new Bundle();
                        bundle.putInt("layout", R.layout.fragment_home);
                        ((MainActivity) context).cambiarFragmento(R.id.nav_home, bundle);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
