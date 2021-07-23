package com.example.retrofitapi.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.retrofitapi.GetInterface;
import com.example.retrofitapi.MainActivity;
import com.example.retrofitapi.R;
import com.example.retrofitapi.adapter.ExampleAdapter;
import com.example.retrofitapi.adapter.SearchAdapter;
import com.example.retrofitapi.model.ExampleModel;
import com.example.retrofitapi.model.SearchModel;
import com.example.retrofitapi.model.SearchResponse;
import com.example.retrofitapi.model.ServerResponse;
import com.example.retrofitapi.retrofit.RetrofitClientInstance;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private SearchAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        searchView = findViewById(R.id.)

        progressDialog = new ProgressDialog(SearchActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();


        //Create handle for the RetrofitInstance interface
        GetInterface service = RetrofitClientInstance.getRetrofitInstance().create(GetInterface.class);
        Call<SearchResponse> call = service.getAllInfo("spic");
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
                Toast.makeText(SearchActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }

        });

    }


    //Method to generate List of data using RecyclerView with custom adapter
    private void generateDataList(List<SearchModel> photoList) {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new SearchAdapter(photoList, this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;

            }
        });
        return true;
    }



}