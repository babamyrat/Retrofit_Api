package com.example.foodapi.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.foodapi.GetInterface;
import com.example.foodapi.model.SearchResponse;
import com.example.foodapi.retrofit.ApiClient;
import com.example.foodapi.R;
import com.example.foodapi.adapter.SearchAdapter;
import com.example.foodapi.model.SearchModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;

import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private SearchAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         // connect xml
        recyclerView = findViewById(R.id.recyclerView);

        //Progress
        progressDialog = new ProgressDialog(SearchActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        //without keyword
        fetchService("");


        //bottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.page_2);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.page_1:
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    overridePendingTransition(0,0);
                    return true;

                case R.id.page_2:
                    return true;

                case R.id.page_3:
                    startActivity(new Intent(getApplicationContext(), UsersActivity.class));
                    overridePendingTransition(0,0);
                    return true;

                case R.id.page_4:
                    startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
                    overridePendingTransition(0,0);
                    return true;
            }

            return false;
        });



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
                Toast.makeText(SearchActivity.this, "Error on:" + t.toString(), Toast.LENGTH_SHORT).show();
            }

        });

        Search();

    }


    private void Search() {
        SearchView simpleSearchView = (SearchView) findViewById(R.id.searchView); // inititate a search view

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

        adapter = new SearchAdapter(photoList, this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }





}