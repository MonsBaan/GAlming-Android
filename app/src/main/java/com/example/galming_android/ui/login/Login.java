package com.example.galming_android.ui.login;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.galming_android.MainActivity;
import com.example.galming_android.R;

public class Login extends Fragment
{
    String dni = "123";
    String contraseña = "a";
    Button btnLogin = null;
    EditText etxDNI;
    EditText etxContraseña;
    Context context;

    /*Coge el contexto*/
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etxDNI=view.findViewById(R.id.etxDNI);
        etxContraseña=view.findViewById(R.id.etxContraseña);
        btnLogin = view.findViewById(R.id.btnLogearse);

        requireActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        requireActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requireActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etxDNI.getText().toString().trim().equals(dni) && etxContraseña.getText().toString().trim().equals(contraseña))
                {
                    Toast.makeText(context, "LOGIN", Toast.LENGTH_SHORT).show();

                    ((MainActivity)context).cambiarFragmento();

                }
                else
                {
                    Toast.makeText(context, "NOLOGIN", Toast.LENGTH_SHORT).show();
                }
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