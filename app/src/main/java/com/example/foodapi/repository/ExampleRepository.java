package com.example.foodapi.repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.example.foodapi.data.api.ApiClient;
import com.example.foodapi.data.local.LocalClient;
import com.example.foodapi.model.ExampleModel;
import com.example.foodapi.utils.NetworkUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ExampleRepository {

    private Context context;
    private static ExampleRepository instance;
    private ApiClient apiClient;
    private LocalClient localClient;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private ExampleRepository(Context context) {
        this.context = context;
        apiClient = ApiClient.newInstance();
        localClient = LocalClient.newInstance(context);
    }

    public static ExampleRepository newInstance(Context context) {
        if (instance == null)
            instance = new ExampleRepository(context);
        return instance;
    }

    @SuppressLint("CheckResult")
    public void loadCategory(MutableLiveData<List<ExampleModel>> liveData) {
        if (NetworkUtils.isNetworkConnected(context)) {
            apiClient.getCategories()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(categoryResponse -> {
                        liveData.postValue(categoryResponse.getResults());
                        insertCategories(categoryResponse.getResults());
                    }, error -> Log.d("ERROR", error.getMessage()));
        } else {
            localClient.getAllCategories()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(liveData::postValue, throwable -> {
                    });
        }
    }

    public void insertCategories(List<ExampleModel> categories) {
        compositeDisposable.add(localClient.insertAll(categories)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    Log.d("SUCCESS", categories.size() + "categories inserted in db");
                }, throwable -> {
                    Log.d("ERROR", "error inserting movies : " + throwable.getMessage());
                }));
    }


}
