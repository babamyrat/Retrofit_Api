package com.example.foodapi;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.foodapi.Base.BaseActivity;
import com.example.foodapi.adapter.ViewPagerAdapter;
import com.example.foodapi.fragment.StepOneFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Initialize ViewPager view
        ViewPager viewPager = findViewById(R.id.viewPagerOnBoarding);
        // create ViewPager adapter
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        // Add All Fragments to ViewPager
        viewPagerAdapter.addFragment(new StepOneFragment());
        // Set Adapter for ViewPager
        viewPager.setAdapter(viewPagerAdapter);
    }


}