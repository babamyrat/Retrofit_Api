package com.example.foodapi.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.foodapi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class UsersActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // top menu bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_users);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.page_3);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.page_1:
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    overridePendingTransition(0,0);
                    return true;

                case R.id.page_2:
                    startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                    overridePendingTransition(0,0);
                    return true;

                case R.id.page_3:
                    return true;

                case R.id.page_4:
                    startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
                    overridePendingTransition(0,0);
                    return true;
            }

            return false;
        });

    }
}