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

    private ApiInterface apiInterface;

    public SearchRepository(){
        Retrofit retrofit = ApiRetrofit.getRetrofitInstance();
        apiInterface = retrofit.create(ApiInterface.class);
    }


    public MutableLiveData<SearchResponse> getAllInfo(String key){

        MutableLiveData<SearchResponse> newsData = new MutableLiveData<>();
        apiInterface.getAllInfo(key).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                newsData.setValue(null);
            }
        });
        return newsData;
    }

    public Call<SearchResponse> search(String query) {
        return apiInterface.getAllInfo(query);
    }
}
