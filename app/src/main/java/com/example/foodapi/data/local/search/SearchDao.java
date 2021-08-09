package com.example.foodapi.data.local.search;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodapi.model.SearchModel;

import java.util.List;

@Dao
public interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<SearchModel> searchModelList);

   // @Query("SELECT * FROM SearchAll")
  //  List<SearchModel> loadAllSearch();

    @Query("SELECT * FROM SearchAll WHERE strMeal LIKE '%' || :query || '%'")
    List<SearchModel> loadAllSearch(String query);


}
