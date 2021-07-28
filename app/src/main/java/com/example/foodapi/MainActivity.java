package com.example.foodapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.foodapi.fragment.StepOneFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // top nav bar delete
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
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

    // ViewPager Adapter class
    static class ViewPagerAdapter extends FragmentPagerAdapter {

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