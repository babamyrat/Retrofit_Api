package com.example.foodapi.data.local.example;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;


import com.example.foodapi.model.ExampleModel;

import java.util.List;

import io.reactivex.Observable;

public class LocalClient {

    private static LocalClient instance;
    private AppDataBase appDataBase;

    private LocalClient(Context context){
        appDataBase =  Room.databaseBuilder(context,
                AppDataBase.class, "database").build();
    }

    public static LocalClient newInstance(Context context){
        if (instance == null)
            instance = new LocalClient(context);
        return instance;
    }

    public Observable<List<ExampleModel>> getAllCategories(){
        return Observable.fromCallable(() -> appDataBase.categoryDao().loadAll());
    }

    public Observable<Boolean> insertAll(List<ExampleModel> categories){
        return Observable.fromCallable(() -> {
            try{
                appDataBase.categoryDao().insertAll(categories);
                return true;
            }catch (Exception e){
                Log.d("ERROR" , e.getMessage());
            }

            return false;
        });
    }




}
