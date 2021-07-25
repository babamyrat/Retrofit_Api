package com.example.retrofitapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.retrofitapi.activity.SearchActivity;
import com.example.retrofitapi.adapter.ExampleAdapter;
import com.example.retrofitapi.model.ExampleModel;
import com.example.retrofitapi.model.ServerResponse;
import com.example.retrofitapi.retrofit.ApiClient;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ExampleAdapter adapter;
    ProgressDialog progressDialog;
    Button btnClickNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialogs();

        ServiceClient();

        // searchView = findViewById(R.id.searchView);
        btnClickNext = findViewById(R.id.btnClickNext);

        btnClickNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });







    }


    private void progressDialogs() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();
    }


    private void ServiceClient() {
        //Create handle for the RetrofitInstance interface
        GetInterface service = ApiClient.getRetrofitInstance().create(GetInterface.class);
        Call<ServerResponse> call = service.getAllPhotos();
        call.enqueue(new retrofit2.Callback<ServerResponse>() {
            @Override
            public void onResponse(@NotNull Call<ServerResponse> call, @NotNull Response<ServerResponse> response) {     // Response
                progressDialog.dismiss();   // progress

                if (response.isSuccessful()){
                    assert response.body() != null;
                    generateDataList(response.body().getCategories());
                }
            }


            @Override
            public void onFailure(@NotNull Call<ServerResponse> call, @NotNull Throwable t) {       // in not on uri

                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }

        });
    }


    //Method to generate List of data using RecyclerView with custom adapter
    private void generateDataList(List<ExampleModel> photoList) {
        adapter = new ExampleAdapter(this,photoList);
        ViewPager2 pager=findViewById(R.id.pager);
        pager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tapLayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, pager, (tab, position) ->
                tab.setText(photoList.get(position).getStrCategory()));
        tabLayoutMediator.attach();

    }







}