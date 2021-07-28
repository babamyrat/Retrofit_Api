package com.example.foodapi;

import com.example.foodapi.model.SearchResponse;
import com.example.foodapi.model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetInterface {
    // home GET
   @GET("/api/json/v1/1/categories.php")
    Call<ServerResponse> getAllPhotos();
   // search GET and Search query
   @GET("/api/json/v1/1/search.php?")
   Call<SearchResponse> getAllInfo(@Query("s") String query);
}

