package com.example.foodapi.data.local.search;

import androidx.room.Database;
import androidx.room.RoomDatabase;



import com.example.foodapi.model.SearchModel;

@Database(entities = {SearchModel.class}, version = 1)
public abstract class AppDataBaseSearch extends RoomDatabase {

        public abstract SearchDao SearchDao();



}
