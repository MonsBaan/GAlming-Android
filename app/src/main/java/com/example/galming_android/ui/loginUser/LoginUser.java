package com.example.galming_android.ui.loginUser;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
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
import com.example.galming_android.ui.retro.clases.Geolocalizacion;
import com.example.galming_android.ui.retro.clases.Login;
import com.example.galming_android.ui.retro.clases.Usuario;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LoginUser extends Fragment {
    private MainActivity main;
    private LoginUserViewModel vmLogin;
    private Button btnLogin = null;
    private EditText etxDNI;
    private EditText etxContraseña;
    private Context context;
    private Login login;
    private Geolocalizacion geolocalizacion;
    private double longitud, latitud;
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        vmLogin = new LoginUserViewModel();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        login = ((MainActivity) context).getLogin();
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());

        vmLogin.getmText().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                login.setUsuId(usuario.getUsuId());
                Bundle bundle = new Bundle();
                bundle.putInt("layout", R.layout.fragment_home);
                ((MainActivity) context).cambiarFragmento(R.id.nav_home, bundle);
                ((MainActivity) context).estadoLogin(true);
                ((MainActivity)context).loginMenu(usuario.getUsuNombre(), usuario.getUsuFoto());
                Toast.makeText(context, "Sesion Iniciada", Toast.LENGTH_SHORT).show();

            }
        });
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

        etxDNI = view.findViewById(R.id.etLoginDNI);
        etxContraseña = view.findViewById(R.id.etLoginContraseña);
        btnLogin = view.findViewById(R.id.btnLogin);

        requireActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        requireActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requireActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vmLogin.loginUsuario(String.valueOf(etxDNI.getText()), String.valueOf(etxContraseña.getText()));

                vmLogin.getmText().observe(getViewLifecycleOwner(), new Observer<Usuario>() {
                    @Override
                    public void onChanged(Usuario usuario) {
                        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                            getLocation(usuario.getUsuId());
                        } else {
                            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                        }
                    }
                });


            }
        });
    }

    private void getLocation(int idUser) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mFusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {

            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();

                if (location != null) {
                    Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());

                    try {
                        List<Address> addresses = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1);
                        latitud = (addresses.get(0).getLatitude());
                        longitud = (addresses.get(0).getLongitude());
                        geolocalizacion = new Geolocalizacion(idUser, (float)latitud, (float)longitud);

                        vmLogin.insertarGeolocalizacion(geolocalizacion);


                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }

            }
        });
    }
}