package com.example.galming_android.ui.perfil;

import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.galming_android.PerfilEliminarDialog;
import com.example.galming_android.R;
import com.example.galming_android.ui.retro.APIRetroFit;
import com.example.galming_android.ui.retro.RetrofitUtils;
import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilFragment extends Fragment
{

    private PerfilViewModel mViewModel;
    private Button btnEliminar, btnEditar, btnGuardar;
    private PerfilEliminarDialog dialog;
    private Context context;
    private int usuId = 3;

    public static PerfilFragment newInstance()
    {
        return new PerfilFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));
    }

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.perfil_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        btnEliminar = view.findViewById(R.id.btnEliminar);
        btnEditar = view.findViewById(R.id.btnEditar);
        btnGuardar = view.findViewById(R.id.btnGuardar);
        //mViewModel = new ViewModelProvider(this).get(PerfilViewModel.class);
        mViewModel = new PerfilViewModel();
        final EditText etDni = view.findViewById(R.id.etPerfilDNI);
        final EditText etNombre = view.findViewById(R.id.etPerfilNombre);
        final EditText etApellido1 = view.findViewById(R.id.etPerfilApellido1);
        final EditText etApellido2 = view.findViewById(R.id.etPerfilApellido2);
        final EditText etDireccion = view.findViewById(R.id.etPerfilDireccion);
        final EditText etPass = view.findViewById(R.id.etPerfilContraseña);
        final EditText etEmail = view.findViewById(R.id.etPerfilEmail);
        final ImageView etFoto = view.findViewById(R.id.ivFotoPerfil);
        final EditText etCiudad = view.findViewById(R.id.etPerfilCiudad);

        //Lanzamos la funcion de la cual queremos recoger datos
        mViewModel.getUsuario(usuId);
        //Observamos el Array de los tipos de producto, para que cuando haya un cambio, refrescar la pantalla usando el onViewCreated
        mViewModel.getUsuarioMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Usuario>>()
        {
            @Override
            public void onChanged(List<Usuario> usuarios)
            {
                if (usuarios != null)
                {
                    for (Usuario dato : usuarios)
                    {
                        etDni.setText(dato.getUsuDni());
                        etNombre.setText(dato.getUsuNombre());
                        etApellido1.setText(dato.getUsuApellido1());
                        etApellido2.setText(dato.getUsuApellido2());
                        etDireccion.setText(dato.getUsuDireccion());
                        etPass.setText(dato.getUsuPass());
                        etEmail.setText(dato.getUsuEmail());
                        Glide.with(context).load(dato.getUsuFoto()).into(etFoto);
                        etCiudad.setText(dato.getUsuCiudad());
                    }
                    //onViewCreated(getView(), savedInstanceState);
                }
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {


                etDni.setInputType(1);
                etNombre.setInputType(1);
                etApellido1.setInputType(1);
                etApellido2.setInputType(1);
                etDireccion.setInputType(1);
                etPass.setInputType(1);
                etEmail.setInputType(1);
                etCiudad.setInputType(1);


            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mViewModel.getUsuarioMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Usuario>>()
                {
                    @Override
                    public void onChanged(List<Usuario> usuarios)
                    {
                        if (usuarios != null)
                        {
                            etDni.getText();
                            etNombre.getText();
                            etApellido1.getText();
                            etApellido2.getText();
                            etDireccion.getText();
                            etPass.getText();
                            etEmail.getText();
                            etCiudad.getText();
                            mViewModel.actualizarUsuario(usuId);
                        }
                    }
                });
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialog = new PerfilEliminarDialog();
                dialog.show(((FragmentActivity) context).getSupportFragmentManager(), "Eliminar Usuario");
            }
        });
    }


}
