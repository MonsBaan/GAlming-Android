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

public class PerfilFragment extends Fragment {

    private PerfilViewModel mViewModel;
    private Button btnEliminar;
    private PerfilEliminarDialog dialog;
    private Context context;

    public static PerfilFragment newInstance() {
        return new PerfilFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.perfil_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnEliminar = view.findViewById(R.id.btnEliminar);
        mViewModel = new ViewModelProvider(this).get(PerfilViewModel.class);

        final EditText etDni = getView().findViewById(R.id.etPerfilDNI);
        final EditText etNombre = getView().findViewById(R.id.etPerfilNombre);
        final EditText etApellido1 = getView().findViewById(R.id.etPerfilApellido1);
        final EditText etApellido2 = getView().findViewById(R.id.etPerfilApellido2);
        final EditText etDireccion = getView().findViewById(R.id.etPerfilDireccion);
        final EditText etPass = getView().findViewById(R.id.etPerfilContraseña);
        final EditText etEmail = getView().findViewById(R.id.etPerfilEmail);
        final ImageView etFoto = getView().findViewById(R.id.ivFotoPerfil);
        final EditText etCiudad = getView().findViewById(R.id.etPerfilCiudad);

        if (getArguments() != null)
        {
            Usuario usuarioRecibido = (Usuario) getArguments().getSerializable("usuario");
            mViewModel.setUsuarioMutableLiveData(usuarioRecibido);
        }



        Call<List<Usuario>> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).getUsuario(5);

        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response)
            {
                List<Usuario> usuario = response.body();

                mViewModel.getUsuarioMutableLiveData().observe(getViewLifecycleOwner(), new Observer<Usuario>()
                {
                    @Override
                    public void onChanged(Usuario usuario)
                    {
                        if (usuario != null)
                        {
                           etDni.setText(usuario.getUsuDni());
                            Log.d("aitor", usuario+"");
                        }
                    }
                });

            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t)
            {

            }

        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new PerfilEliminarDialog();
                dialog.show(((FragmentActivity) context).getSupportFragmentManager(), "Eliminar Usuario");
            }
        });
    }


}
