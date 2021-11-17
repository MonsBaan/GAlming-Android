package com.example.galming_android.ui.retro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi
{
    @GET("usuario/5")
    Call<List<Post>> getPosts();


}
