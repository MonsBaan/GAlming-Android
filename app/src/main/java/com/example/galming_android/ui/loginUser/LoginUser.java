package com.example.galming_android.ui.loginUser;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.galming_android.MainActivity;
import com.example.galming_android.R;
import com.example.galming_android.ui.retro.clases.Login;
import com.example.galming_android.ui.retro.clases.Usuario;

import java.io.IOException;

public class LoginUser extends Fragment
{
    private MainActivity main;
    private LoginUserViewModel vmLogin;
    private Button btnLogin = null;
    private EditText etxDNI;
    private EditText etxContraseña;
    private Context context;
    private Login login;

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        this.context = context;
        vmLogin = new LoginUserViewModel();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        login = ((MainActivity) context).getLogin();
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));

        vmLogin.getmText().observe(this, new Observer<Usuario>()
        {
            @Override
            public void onChanged(Usuario usuario)
            {
                login.setUsuId(usuario.getUsuId());
                Bundle bundle = new Bundle();
                bundle.putInt("layout", R.layout.fragment_home);
                ((MainActivity) context).cambiarFragmento(R.id.nav_home, bundle);
                ((MainActivity) context).estadoLogin(true);
                Toast.makeText(context, "Sesion Iniciada", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        etxDNI = view.findViewById(R.id.etLoginDNI);
        etxContraseña = view.findViewById(R.id.etLoginContraseña);
        btnLogin = view.findViewById(R.id.btnLogin);

        requireActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        requireActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requireActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);


        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                vmLogin.loginUsuario(String.valueOf(etxDNI.getText()), String.valueOf(etxContraseña.getText()));

            }
        });


    }

    /*Descomentar si quieres full screen*/

  /* @Override
    public void onResume() {
        super.onResume();
        ActionBar supportActionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ActionBar supportActionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.show();
    }*/


}