package com.example.foodapi.viewModel;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodapi.repository.SearchRepository;
import com.example.foodapi.response.SearchResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchViewModel extends ViewModel {

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
    }
}
