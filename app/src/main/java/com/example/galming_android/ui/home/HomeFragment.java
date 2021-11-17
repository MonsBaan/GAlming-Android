package com.example.galming_android.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galming_android.MainActivity;
import com.example.galming_android.R;
import com.example.galming_android.ui.home.productos.adaptador.MainAdaptador;
import com.example.galming_android.ui.retro.APIRetroFit;
import com.example.galming_android.ui.retro.RetrofitUtils;
import com.example.galming_android.ui.retro.clases.OperacionProducto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private Context context;
    private RecyclerView listaTipoProductos;
    private ArrayList<String> arrayString;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(getContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slidedam));
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity main = (MainActivity) getActivity();
        main.removeBar(View.VISIBLE);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

        arrayString = new ArrayList<>();

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rellenarDatos();
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
                for (OperacionProducto producto : productos) {
                    Log.d("Ibai", producto.getOpProdStock() + "");

                }


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

    private void rellenarDatos() {
        arrayString.add("PSP");
        arrayString.add("PC");
        arrayString.add("PS1");
        arrayString.add("PS2");
        arrayString.add("XBOX");
        arrayString.add("NontengoSwitch");
    }
}