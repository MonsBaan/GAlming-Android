package com.example.galming_android.ui.perfil;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.ConditionVariable;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.galming_android.PerfilEliminarDialog;
import com.example.galming_android.R;
import com.example.galming_android.ui.retro.JsonPlaceHolderApi;
import com.example.galming_android.ui.retro.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new PerfilEliminarDialog();
                dialog.show(((FragmentActivity) context).getSupportFragmentManager(), "Eliminar Usuario");
            }
        });
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PerfilViewModel.class);
        // TODO: Use the ViewModel
        TextView tvRetro = requireView().findViewById(R.id.textView4);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://galming.duckdns.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        Log.d("aitor", "fuera");
        call.enqueue(new Callback<List<Post>>()
        {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response)
            {
                Log.d("aitor", "dentro");
                if (!response.isSuccessful())
                {

                    tvRetro.setText("Code: " + response.code());
                    return;

                }
                List<Post> posts = response.body();

                for (Post post : posts)
                {
                    String content = "";
                    content += "DNI: " + post.getUsuDni() +"\n";
                    content += "Nombre: " + post.getUsuNombre() + "\n\n";

                    tvRetro.append(content);

                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t)
            {
                tvRetro.setText(t.getMessage());
            }
        });
    }

}
