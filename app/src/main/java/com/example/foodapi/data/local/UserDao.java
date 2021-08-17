package com.example.foodapi.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.foodapi.model.ExampleModel;
import com.example.foodapi.model.SearchModel;

import java.util.List;


@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ExampleModel> exampleModelList);

    @Query("SELECT * FROM categories")
    List<ExampleModel> loadAll();

}
