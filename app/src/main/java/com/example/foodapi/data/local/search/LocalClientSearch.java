package com.example.foodapi.data.local.search;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.example.foodapi.model.SearchModel;

import java.util.List;

import io.reactivex.Observable;

public class LocalClientSearch {

    private static LocalClientSearch instance;
    private AppDataBaseSearch appDataBaseSearch;

    private LocalClientSearch(Context context){
        appDataBaseSearch =  Room.databaseBuilder(context,
                AppDataBaseSearch.class, "dbase").build();
    }

    public static LocalClientSearch newInstance(Context context){
        if (instance == null)
            instance = new LocalClientSearch(context);
        return instance;
    }

    public Observable<List<SearchModel>> getAllCategories(String query){
        return Observable.fromCallable(() -> appDataBaseSearch.SearchDao().loadAllSearch(query));
    }


    public Observable<Boolean> insertAll(List<SearchModel> categories){
        return Observable.fromCallable(() -> {
            try{
                appDataBaseSearch.SearchDao().insertAll(categories);
                return true;
            }catch (Exception e){
                Log.d("ERROR" , e.getMessage());
            }

            return false;
        });
    }




}