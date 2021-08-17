package com.example.foodapi.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.foodapi.model.ExampleModel;
import com.example.foodapi.model.SearchModel;


@Database(entities = {ExampleModel.class, SearchModel.class}, version = 1, exportSchema = false)
public abstract class AppDataBase  extends RoomDatabase {

    public abstract UserDao categoryDao();

    public abstract SearchDao SearchDao();
}

