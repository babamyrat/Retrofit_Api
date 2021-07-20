package com.example.retrofitapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/6f14c7d943df635eb3dd")
    Call<List<PhotoModel>> getAllPhotos();
}
