package com.example.retrofitapi;

import com.example.retrofitapi.model.PhotoModel;
import com.example.retrofitapi.model.ServerResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
   // @GET("/3e82888d8942db36d58b")
    @GET("/495f889a44cadfe1b17b")
    Call<ServerResponse> getAllPhotos();
}
