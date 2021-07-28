package com.example.foodapi.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.foodapi.MainActivity;
import com.example.foodapi.R;

import java.util.Objects;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // top menu bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_splash);

        // This is the time
        int SPLASH_TIME_OUT = 3000;
        new Handler().postDelayed(() -> {
            // Start your app main activity
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, SPLASH_TIME_OUT);
    }
}