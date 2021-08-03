package com.example.foodapi.DB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.foodapi.DB.DAO.UpExampleDao;
import com.example.foodapi.DB.table.UpExampleModelDB;

@Database(entities = UpExampleModelDB.class, version = 1, exportSchema = false)
public abstract class ExampleAppDB extends RoomDatabase {
    private static ExampleAppDB instance; //only one interface

    public abstract UpExampleDao movieDao();

    public static synchronized ExampleAppDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), ExampleAppDB.class , "my-database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    } //synchronized : only one thread can access this method
    //fallbacktodestructivemigration : to handle versions

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // new PopulateDb(instance).execute();
        }
    };

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
