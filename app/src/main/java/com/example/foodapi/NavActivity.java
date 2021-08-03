package com.example.foodapi;

import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.foodapi.base.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavActivity extends BaseActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        setUpNavigation();
    }
    public void setUpNavigation(){
        bottomNavigationView =findViewById(R.id.bttm_nav);
        NavHostFragment navHostFragment = (NavHostFragment)getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        NavigationUI.setupWithNavController(bottomNavigationView,
                navHostFragment.getNavController());
    }
}