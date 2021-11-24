package com.example.galming_android.ui.registroUser;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.galming_android.MainActivity;
import com.example.galming_android.R;
import com.example.galming_android.ui.perfil.PerfilViewModel;
import com.example.galming_android.ui.retro.clases.Usuario;

import java.util.List;

public class RegistroUser extends Fragment {
    public PerfilViewModel mViewModel;
    private String dni;
    private String contraseña;
    private Button btnRegistrarse = null;
    private Context context;
    private String usuFoto = "";


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mViewModel = new PerfilViewModel();

        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));

        mViewModel.getmUsuarioR().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                //AQUI LE REDIRIGIMOS A DONDE QUERAMOS
                Bundle bundle = new Bundle();
                bundle.putInt("layout", R.layout.fragment_home);
                ((MainActivity) context).cambiarFragmento(R.id.nav_home, bundle);

                Toast.makeText(context, "Usuario Creado", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registrarse, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnRegistrarse = view.findViewById(R.id.btnRegistro);

        final EditText etDni = view.findViewById(R.id.etRegistroDNI);
        final EditText etNombre = view.findViewById(R.id.etRegistroNombre);
        final EditText etApellido1 = view.findViewById(R.id.etRegistroApellido1);
        final EditText etApellido2 = view.findViewById(R.id.etRegistroApellido2);
        final EditText etDireccion = view.findViewById(R.id.etRegistroDireccion);
        final EditText etPass = view.findViewById(R.id.etRegistroContraseña);
        final EditText etEmail = view.findViewById(R.id.etRegistroEmail);
        final ImageView ivFoto = view.findViewById(R.id.ivFotoPerfil);
        final EditText etCiudad = view.findViewById(R.id.etRegistroCiudad);
        final TextView tvError = view.findViewById(R.id.tvError);


        requireActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        requireActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requireActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);


        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etEmail.getText().toString().trim().equals("") || etDni.getText().toString().trim().equals("") || etNombre.getText().toString().trim().equals("")
                        || etApellido1.getText().toString().trim().equals("") || etApellido2.getText().toString().trim().equals("")
                        || etCiudad.getText().toString().trim().equals("") || etPass.getText().toString().trim().equals("")
                        || etDireccion.getText().toString().trim().equals("")) {
                    tvError.setVisibility(View.VISIBLE);
                } else {
                    tvError.setVisibility(View.GONE);

                    Usuario usuarionuevo = new Usuario();

                    usuarionuevo.setUsuDni(etDni.getText().toString());
                    usuarionuevo.setUsuNombre(etNombre.getText().toString());
                    usuarionuevo.setUsuApellido1(etApellido1.getText().toString());
                    usuarionuevo.setUsuApellido2(etApellido2.getText().toString());
                    usuarionuevo.setUsuCiudad(etCiudad.getText().toString());
                    usuarionuevo.setUsuEmail(etEmail.getText().toString());
                    usuarionuevo.setUsuPass(etPass.getText().toString());
                    usuarionuevo.setUsuFoto("https://static.vecteezy.com/system/resources/thumbnails/000/550/731/small/user_icon_004.jpg");
                    usuarionuevo.setUsuDireccion(etDireccion.getText().toString());

                    mViewModel.insertarUsuario(usuarionuevo);

                }


            }
        });
    }

}
