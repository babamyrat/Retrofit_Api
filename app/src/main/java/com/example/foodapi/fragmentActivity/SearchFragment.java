package com.example.foodapi.fragmentActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.foodapi.R;
import com.example.foodapi.adapter.SearchAdapter;
import com.example.foodapi.model.SearchModel;

import com.example.foodapi.viewModel.SearchViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private List<SearchModel> searchModelList = new ArrayList<>();
    private SearchAdapter adapter;
    private SearchViewModel searchViewModel;
    private SearchView simpleSearchView;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        settingViewModel("");
        search();
    }

    private void initView() {
        simpleSearchView = view.findViewById(R.id.searchView);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new SearchAdapter(searchModelList, getContext());
        recyclerView.setAdapter(adapter);
    }

    private void settingViewModel(String key) {
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        searchViewModel.search(key);
        searchViewModel.getSearchLiveData().observe(getViewLifecycleOwner(), searchResponse -> {
            List<SearchModel> models = searchResponse.getMeals();
            adapter.addData(models);
        });
    }


    private void search() {
        simpleSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchViewModel.search(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchViewModel.search(s);
                return false;
            }
        });
    }


}