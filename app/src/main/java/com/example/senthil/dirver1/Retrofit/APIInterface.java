package com.example.senthil.dirver1.Retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("register")
    Call<Object> RegisterPost(@Body String s);

}
