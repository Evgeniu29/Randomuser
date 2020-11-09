package com.paad.randomuser.Retrofit;

import com.paad.randomuser.API.User;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {


    @GET("/api/?results=20")
    Call<User> getResult();
    }

