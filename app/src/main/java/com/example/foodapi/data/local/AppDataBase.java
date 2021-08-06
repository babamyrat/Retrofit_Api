package com.example.foodapi.data.local;

import androidx.room.RoomDatabase;

public abstract class AppDataBase extends RoomDatabase {
    public abstract ExampleDao categoryDao();
}
