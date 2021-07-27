package com.example.retrofitapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
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
import com.example.retrofitapi.fragment.StepOneFragment;
import com.example.retrofitapi.model.ExampleModel;
import com.example.retrofitapi.model.ServerResponse;
import com.example.retrofitapi.retrofit.ApiClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



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

//        // Setup dot's indicator
//        TabLayout tabLayout = findViewById(R.id.tabLayoutIndicator);
//        tabLayout.setupWithViewPager(viewPager);
    }

    // ViewPager Adapter class
    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }
        @Override
        public Fragment getItem(int i) {
            return mList.get(i);
        }
        @Override
        public int getCount() {
            return mList.size();
        }
        public void addFragment(Fragment fragment) {
            mList.add(fragment);
        }
    }

}