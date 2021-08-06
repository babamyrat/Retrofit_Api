package com.example.foodapi.data.api;

import static com.example.foodapi.Utils.Constant.EXAMPLE_API_KEY;
import static com.example.foodapi.Utils.Constant.SEARCH_API_KEY;

import com.example.foodapi.response.SearchResponse;
import com.example.foodapi.response.ExampleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    // home GET
   @GET(EXAMPLE_API_KEY)
    Call<ExampleResponse> getAllPhotos();
   // search GET and Search query
   @GET(SEARCH_API_KEY)
   Call<SearchResponse> getAllInfo(@Query("s") String query);
}

