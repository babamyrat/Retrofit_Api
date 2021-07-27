package com.example.retrofitapi.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.retrofitapi.MainActivity;
import com.example.retrofitapi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class HistoryActivity extends AppCompatActivity {
     BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.page_4);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.page_1:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.page_2:
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.page_3:
                        startActivity(new Intent(getApplicationContext(), UsersActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.page_4:
//                        startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
//                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });


    }

}