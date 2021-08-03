package com.example.foodapi.DB.DAO

import androidx.lifecycle.LiveData

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodapi.DB.table.UpExampleModelDB

@Dao
interface UpExampleDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertUpComingMovie(history: UpExampleModelDB?)
//
//    @Query("SELECT * from UpExampleModelDB ORDER BY id ASC")
//    fun getAllUpComingMovie(): LiveData<List<UpExampleModelDB>>?
//
//    @Query("DELETE FROM UpExampleModelDB")
//    fun deleteAllUpComingMovie()
}