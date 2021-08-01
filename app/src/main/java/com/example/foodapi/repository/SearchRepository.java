package com.example.foodapi.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.foodapi.ApiInterface;
import com.example.foodapi.model.SearchModel;
import com.example.foodapi.response.SearchResponse;
import com.example.foodapi.retrofit.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchRepository {
//    private ApiInterface apiInterface;
//
//    public SearchRepository () {
//    }
//
//    public MutableLiveData<SearchResponse> getMovies() {
//        final MutableLiveData<SearchResponse> refferAndInvitePojoMutableLiveData = new MutableLiveData<>();
//        apiInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);
//        Call<SearchResponse> call = apiInterface.getAllInfo();
//        call.enqueue(new Callback<SearchResponse>() {
//            @Override
//            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
//                if(response.body()!=null)
//                {
//                    refferAndInvitePojoMutableLiveData.setValue(response.body());
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<SearchResponse> call, Throwable t) {
//
//            }
//        });
//
//        return refferAndInvitePojoMutableLiveData;
//    }

}
