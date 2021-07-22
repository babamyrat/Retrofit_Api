package com.example.retrofitapi.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.retrofitapi.fragment.PageFragment;


//--------------------------------------------------------------------------------------//
public class MyAdapter extends FragmentStateAdapter {


    public MyAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return(PageFragment.newInstance(position));
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}

//_______________________________________________________________________________________//
