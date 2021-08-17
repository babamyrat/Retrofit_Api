package com.example.foodapi.data.local;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;


import com.example.foodapi.model.ExampleModel;
import com.example.foodapi.model.SearchModel;

import java.util.List;

import io.reactivex.Observable;

public class LocalClient {

    private static LocalClient instance;
    private final AppDataBase appDataBase;


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

    public Observable<List<SearchModel>> getAllCategories(String query){
        return Observable.fromCallable(() -> appDataBase.SearchDao().loadAllSearch(query));
    }


    //______________________________________________________________________________//

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

    public Observable<Boolean> insertAll1(List<SearchModel> categories1){
        return Observable.fromCallable(() -> {
            try{
                appDataBase.SearchDao().insertAllS(categories1);
                return true;
            }catch (Exception e){
                Log.d("ERROR" , e.getMessage());
            }

            return false;
        });
    }


    //--------------------------------------------------------------------------------//

}
