package com.example.foodapi.data.local;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodapi.model.ExampleModel;

import java.util.List;

public interface ExampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ExampleModel> categoryList);

    @Query("SELECT * FROM examples")
    List<ExampleModel> loadAll();
}
