package com.example.foodapi.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.foodapi.model.ExampleModel;
import com.example.foodapi.model.SearchModel;
import com.example.foodapi.repository.DataManager;
import com.example.foodapi.repository.SearchRepository;
import com.example.foodapi.response.SearchResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchViewModel extends AndroidViewModel {

    private SearchRepository searchRepository = SearchRepository.newInstanceSearch(getApplication());

    MutableLiveData<List<SearchModel>> liveData = new MutableLiveData<>();

    public MutableLiveData<List<SearchModel>> getLiveDataSearch() {
        return liveData;
    }

    public SearchViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadCategorySearch(String query){
        searchRepository.loadCategorySearch(liveData, query);
    }


//    public void search(String query) {
//        movieDetailRepository.search(query).enqueue(new Callback<SearchResponse>() {
//            @Override
//            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
//                searchResponseMutableLiveData.postValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<SearchResponse> call, Throwable t) {
//                Log.d("error", t.getLocalizedMessage());
//            }
//        });
//    }

}



/*
    private final MutableLiveData<SearchResponse> searchResponseMutableLiveData = new MutableLiveData<>();
    private  SearchRepository movieDetailRepository = SearchRepository.getInstance();;

    public MutableLiveData<SearchResponse> getSearchLiveData() {
        return searchResponseMutableLiveData;
    }

    public void search(String query) {
        movieDetailRepository.search(query).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                searchResponseMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.d("error", t.getLocalizedMessage());
            }
        });
    }*/

