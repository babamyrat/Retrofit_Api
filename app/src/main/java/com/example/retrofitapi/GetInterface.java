package com.example.retrofitapi;

import com.example.retrofitapi.model.SearchResponse;
import com.example.retrofitapi.model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetInterface {

   @GET("/api/json/v1/1/categories.php")
    Call<ServerResponse> getAllPhotos();

   @GET("/api/json/v1/1/search.php?s=")
   Call<SearchResponse> getAllInfo();
}

