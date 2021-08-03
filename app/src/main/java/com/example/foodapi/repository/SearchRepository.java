package com.example.foodapi.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.foodapi.ApiInterface;
import com.example.foodapi.response.SearchResponse;
import com.example.foodapi.retrofit.ApiRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
        Retrofit retrofit = ApiRetrofit.getRetrofitInstance();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    // search
    public Call<SearchResponse> search(String query) {
        return apiInterface.getAllInfo(query);
    }
}
