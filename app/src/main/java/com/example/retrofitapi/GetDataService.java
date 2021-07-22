package com.example.retrofitapi;

import com.example.retrofitapi.model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {


   @GET("/api/json/v1/1/categories.php")
    Call<ServerResponse> getAllPhotos();
}
