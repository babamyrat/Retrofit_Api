package com.example.retrofitapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import com.example.retrofitapi.activity.HistoryActivity;
import com.example.retrofitapi.activity.SearchActivity;
import com.example.retrofitapi.activity.UsersActivity;
import com.example.retrofitapi.adapter.ExampleAdapter;
import com.example.retrofitapi.model.ExampleModel;
import com.example.retrofitapi.model.ServerResponse;
import com.example.retrofitapi.retrofit.ApiClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }







}