package com.example.foodapi.repository;

import com.example.foodapi.data.api.ApiInterface;
import com.example.foodapi.response.SearchResponse;
import com.example.foodapi.data.api.ApiClient;

import retrofit2.Call;
import retrofit2.Retrofit;

public class SearchRepository {


        private static SearchRepository searchRepository;

        public static SearchRepository getInstance(){
        if (searchRepository == null){
            searchRepository = new SearchRepository();
        }
           return searchRepository;
        }

   ApiInterface apiInterface;

    public SearchRepository(){
        Retrofit retrofit = ApiClient.getRetrofitInstance();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    // search
    public Call<SearchResponse> search(String query) {
        return apiInterface.getAllInfo(query);
    }
}
