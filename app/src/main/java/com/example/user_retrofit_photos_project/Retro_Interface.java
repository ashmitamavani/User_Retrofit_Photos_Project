package com.example.user_retrofit_photos_project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Retro_Interface {
    @GET("posts")
    Call<List<PostsModelClas>>showProduct();
}
