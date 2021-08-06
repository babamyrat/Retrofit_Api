package com.example.foodapi.fragmentActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodapi.R;
import com.example.foodapi.adapter.ExampleAdapter;
import com.example.foodapi.model.ExampleModel;
import com.example.foodapi.viewModel.ExampleViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

public class HomeFragment extends Fragment {
    private View view;
    private ExampleViewModel viewModel;
    private ExampleAdapter adapter;
    private ViewPager2 pager;
    private TabLayout tabLayout;
    private List<ExampleModel> exampleModels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
    return view;
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ExampleViewModel.class);

        bindingViews();
        initAdapter();
        initObserve();
    }

    private void initObserve() {
        viewModel.loadCategory();
        viewModel.getLiveData().observe(getViewLifecycleOwner(), categories -> {
            if (categories != null){
                adapter.addItems(categories);
            }
        });
    }

    private void bindingViews() {
        pager=view.findViewById(R.id.pager);
        tabLayout = view.findViewById(R.id.tapLayout);
    }

    private void initTabLayout(List<ExampleModel> models) {
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, pager, (tab, position) ->
                tab.setText(models.get(position).getStrCategory()));
        tabLayoutMediator.attach();
    }

    private void initAdapter() {
        adapter = new ExampleAdapter(getContext(), exampleModels);
        pager.setAdapter(adapter);
    }


}