package com.example.foodapi.data.local.example;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.foodapi.model.ExampleModel;


@Database(entities = {ExampleModel.class}, version = 1, exportSchema = false)
public abstract class AppDataBase  extends RoomDatabase {

    public abstract UserDao categoryDao();
}

