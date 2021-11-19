package com.example.galming_android.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galming_android.MainActivity;
import com.example.galming_android.R;
import com.example.galming_android.ui.home.adaptador.MainAdaptador;
import com.example.galming_android.ui.retro.clases.OperacionProducto;
import com.example.galming_android.ui.retro.clases.TipoProducto;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private Context context;
    private RecyclerView listaTipoProductos;
    private HomeViewModel vmHome;
    private MainAdaptador adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));


        vmHome = new HomeViewModel();
        adapter = new MainAdaptador(context, new ArrayList<>(), vmHome, this);

        vmHome.getTiposProducto();
        vmHome.getmTipoProducto().observe(this, new Observer<List<TipoProducto>>() {
            @Override
            public void onChanged(List<TipoProducto> tipoProductos) {
                adapter.setArrayTipoProducto(tipoProductos);
            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listaTipoProductos = view.findViewById(R.id.rvProducto);
        listaTipoProductos.setLayoutManager(new LinearLayoutManager(context));

        Call<List<OperacionProducto>> call = RetrofitUtils.getInstance().doGet(APIRetroFit.class).getProductos();
        call.enqueue(new Callback<List<OperacionProducto>>() {
            @Override
            public void onResponse(Call<List<OperacionProducto>> call, Response<List<OperacionProducto>> response) {
                List<OperacionProducto> productos = response.body();
               /* for (OperacionProducto producto : productos) {
                    Log.d("Ibai", producto.getOpProdStock() + "");

                }
*/

            }

            @Override
            public void onFailure(Call<List<OperacionProducto>> call, Throwable t) {

            }
        });


        MainAdaptador adapter = new MainAdaptador(context, arrayString);
        listaTipoProductos.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MainActivity main = (MainActivity) getActivity();
        main.removeBar(View.GONE);
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity main = (MainActivity) getActivity();
        main.removeBar(View.VISIBLE);
    }

}