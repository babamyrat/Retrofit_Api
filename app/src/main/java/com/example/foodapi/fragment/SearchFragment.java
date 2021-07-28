package com.example.foodapi.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.foodapi.GetInterface;
import com.example.foodapi.R;
import com.example.foodapi.adapter.SearchAdapter;
import com.example.foodapi.model.SearchModel;
import com.example.foodapi.model.SearchResponse;
import com.example.foodapi.retrofit.ApiClient;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search, container, false);
        // connect xml
        recyclerView = view.findViewById(R.id.recyclerView);

        //Progress
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        //without keyword
        fetchService("");
        return view;
    }
    public void fetchService(String key){
        //Create handle for the RetrofitInstance interface
        GetInterface service = ApiClient.getRetrofitInstance().create(GetInterface.class);
        Call<SearchResponse> call = service.getAllInfo(key);

        call.enqueue(new retrofit2.Callback<SearchResponse>() {
            @Override
            public void onResponse(retrofit2.@NotNull Call<SearchResponse> call, @NotNull Response<SearchResponse> response) {     // Response
                progressDialog.dismiss();   // progress

                if (response.isSuccessful()) {
                    assert response.body() != null;
                    generateDataList(response.body().getMeals());
                }
            }

            @Override
            public void onFailure(retrofit2.@NotNull Call<SearchResponse> call, @NotNull Throwable t) {       // in not on uri
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Error on:" + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });



        search();
    }

    private void search() {
        SearchView simpleSearchView = view.findViewById(R.id.searchView); // inititate a search view

// perform set on query text listener event
        simpleSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                fetchService(s);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                fetchService(s);
                return false;
            }
        });
    }

    //Method to generate List of data using RecyclerView with custom adapter
    private void generateDataList(List<SearchModel> photoList) {

        SearchAdapter adapter = new SearchAdapter(photoList, getContext());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}