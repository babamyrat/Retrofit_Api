package com.example.foodapi.UI.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.foodapi.model.SearchModel;
import com.example.foodapi.repository.SearchRepository;


import java.util.List;


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

}


