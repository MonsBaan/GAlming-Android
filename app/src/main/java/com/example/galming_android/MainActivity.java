package com.example.galming_android;

import android.os.Bundle;
import android.view.Menu;

import com.example.galming_android.databinding.ActivityMainLoginBinding;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.galming_android.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private ActivityMainLoginBinding bindingLogin;
    private Sesion sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sesion = new Sesion(getApplicationContext());
        if ("123".equals("123")) {
            bindingLogin = ActivityMainLoginBinding.inflate(getLayoutInflater());
            setContentView(bindingLogin.getRoot());

            setSupportActionBar(bindingLogin.appBarMain.toolbar);

            DrawerLayout drawerLogin = bindingLogin.drawerLayout;
            NavigationView navigationViewLogin = bindingLogin.navView;
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            mAppBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_home, R.id.perfil, R.id.pedidos, R.id.cerrarSesion)
                    .setOpenableLayout(drawerLogin)
                    .build();

            NavController navControllerLogin = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            NavigationUI.setupActionBarWithNavController(this, navControllerLogin, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationViewLogin, navControllerLogin);

        } else {
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            setSupportActionBar(binding.appBarMain.toolbar);

            DrawerLayout drawer = binding.drawerLayout;
            NavigationView navigationView = binding.navView;
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            mAppBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_home, R.id.login, R.id.registrarse)
                    .setOpenableLayout(drawer)
                    .build();
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void cambiarFragmento(int destino, Bundle datos) {
        Navigation.findNavController(this, R.id.nav_host_fragment_content_main).navigate(destino, datos);
    }
}