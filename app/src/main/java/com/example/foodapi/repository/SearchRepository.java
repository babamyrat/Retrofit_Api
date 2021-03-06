package com.example.foodapi.repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.foodapi.data.api.ApiClient;

import com.example.foodapi.data.local.LocalClient;
import com.example.foodapi.model.SearchModel;
import com.example.foodapi.utils.NetworkUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class SearchRepository {

    private Context context;
    private static SearchRepository instance;
    private ApiClient apiClient;
    private LocalClient localClientSearch;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private SearchRepository(Context context) {
        this.context = context;
        apiClient = ApiClient.newInstance();
        localClientSearch = LocalClient.newInstance(context);
    }

    public static SearchRepository newInstanceSearch(Context context) {
        if (instance == null)
            instance = new SearchRepository(context);
        return instance;
    }

    @SuppressLint("CheckResult")
    public void loadCategorySearch(MutableLiveData<List<SearchModel>> liveData, String query) {
        if (NetworkUtils.isNetworkConnected(context)) {
            apiClient.getCategoriesSearch(query)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(categoryResponse -> {
                        liveData.postValue(categoryResponse.getResultsSearch());
                        insertCategories(categoryResponse.getResultsSearch());
                    }, error -> Log.d("ERROR", error.getMessage()));
        } else {
            localClientSearch.getAllCategories( query)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(list -> {
                        Log.d("size", String.valueOf(list.size()));
                        liveData.postValue(list);
                    }, throwable -> {
                    });
        }
    }

    public void insertCategories(List<SearchModel> categories) {
        compositeDisposable.add(localClientSearch.insertAll1(categories)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    Log.d("SUCCESS", categories.size() + "categories inserted in db");
                }, throwable -> {
                    Log.d("ERROR", "error inserting movies : " + throwable.getMessage());
                }));
    }



}