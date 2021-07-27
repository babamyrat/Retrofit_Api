package com.example.retrofitapi.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitapi.GetInterface;
import com.example.retrofitapi.MainActivity;
import com.example.retrofitapi.R;
import com.example.retrofitapi.adapter.ExampleAdapter;
import com.example.retrofitapi.model.ExampleModel;
import com.example.retrofitapi.model.ServerResponse;
import com.example.retrofitapi.retrofit.ApiClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private ExampleAdapter adapter;
    ProgressDialog progressDialog;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        progressDialogs();

        ServiceClient();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.page_1);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.page_1:
                    return true;

                case R.id.page_2:
                    startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                    overridePendingTransition(0,0);
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


    private void progressDialogs() {
        progressDialog = new ProgressDialog(HomeActivity.this);
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
                Toast.makeText(HomeActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
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