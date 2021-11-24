package com.example.galming_android;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.galming_android.databinding.ActivityMainLoginBinding;
import com.example.galming_android.ui.retro.clases.Login;
import com.example.galming_android.ui.retro.clases.Usuario;
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
    private Usuario usuario;
    private Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        login = new Login(getApplicationContext());
        login.setUsuId(-1);
        super.onCreate(savedInstanceState);

        bindingLogin = ActivityMainLoginBinding.inflate(getLayoutInflater());
        setContentView(bindingLogin.getRoot());

        setSupportActionBar(bindingLogin.appBarMain.toolbar);

        DrawerLayout drawerLogin = bindingLogin.drawerLayout;
        NavigationView navigationViewLogin = bindingLogin.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.perfil, R.id.pedidos, R.id.cerrarSesion, R.id.login, R.id.registrarse, R.id.galeriaFragment, R.id.dondeEstamosFragment, R.id.sobreNosotrosFragment)
                .setOpenableLayout(drawerLogin)
                .build();

        NavController navControllerLogin = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navControllerLogin, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationViewLogin, navControllerLogin);

        estadoLogin(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        bindingLogin.appBarMain.svMain.setQueryHint("Busqueda");
        bindingLogin.appBarMain.svMain.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Bundle bundle = new Bundle();
                bundle.putInt("layout", R.layout.busqueda_fragment);
                bundle.putString("busqueda", s);
                cambiarFragmento(R.id.busquedaFragment, bundle);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

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

    public void removeBar(int v) {
        if (binding == null) {
            bindingLogin.appBarMain.svMain.setVisibility(v);

        } else if (bindingLogin == null) {
            binding.appBarMain.svMain.setVisibility(v);

        }

    }

    public void estadoLogin(Boolean estado) {
        bindingLogin.navView.getMenu().findItem(R.id.login).setVisible(!estado);
        bindingLogin.navView.getMenu().findItem(R.id.registrarse).setVisible(!estado);
        bindingLogin.navView.getMenu().findItem(R.id.galeriaFragment).setVisible(true);
        bindingLogin.navView.getMenu().findItem(R.id.dondeEstamosFragment).setVisible(true);
        bindingLogin.navView.getMenu().findItem(R.id.sobreNosotrosFragment).setVisible(true);

        bindingLogin.navView.getMenu().findItem(R.id.perfil).setVisible(estado);
        bindingLogin.navView.getMenu().findItem(R.id.pedidos).setVisible(estado);
        bindingLogin.navView.getMenu().findItem(R.id.cerrarSesion).setVisible(estado);
        bindingLogin.navView.getMenu().findItem(R.id.galeriaFragment).setVisible(true);
        bindingLogin.navView.getMenu().findItem(R.id.dondeEstamosFragment).setVisible(true);
        bindingLogin.navView.getMenu().findItem(R.id.sobreNosotrosFragment).setVisible(true);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;



    }
    public void loginMenu(String nombre, String foto){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        TextView tvMenu = (TextView) headerView.findViewById(R.id.tvMenu);
        ImageView ivMenu = (ImageView) headerView.findViewById(R.id.ivMenu);

        tvMenu.setText(nombre);

        Glide.with(getApplicationContext())
                .load(foto)
                .into(ivMenu);


    }
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }


}
