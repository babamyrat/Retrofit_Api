package com.example.retrofitapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.retrofitapi.activity.HistoryActivity;
import com.example.retrofitapi.activity.LikeActivity;
import com.example.retrofitapi.activity.UsersActivity;
import com.example.retrofitapi.adapter.CustomAdapter;
import com.example.retrofitapi.model.PhotoModel;

import java.util.List;

import retrofit2.Call;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        //Create handle for the RetrofitInstance interface
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<PhotoModel>> call = service.getAllPhotos();
        call.enqueue(new retrofit2.Callback<List<PhotoModel>>() {
            @Override
            public void onResponse(retrofit2.Call<List<PhotoModel>> call, Response<List<PhotoModel>> response) {     // Response
                progressDialog.dismiss();   // progress

                if (response.isSuccessful()){
                    generateDataList(response.body());
                }

            }


            @Override
            public void onFailure(retrofit2.Call<List<PhotoModel>> call, Throwable t) {       // in not on uri

                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }

        });

    }


    //Method to generate List of data using RecyclerView with custom adapter
    private void generateDataList(List<PhotoModel> photoList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    // Working menu Bottom
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_menu, menu);
        return true;

    }
    // Handle item.getItemId
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.page_1:
                OneActivity();
                return true;
            case R.id.page_2:
                TwoActivity();
                return true;
            case R.id.page_3:
                TreeActivity();
                return true;
            case R.id.page_4:
                FourActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void FourActivity(){
        Intent intent = new Intent(MainActivity.this, LikeActivity.class);
        startActivity(intent);

    }

    private void TreeActivity(){
       Intent intent = new Intent(MainActivity.this, UsersActivity.class);
       startActivity(intent);
    }

    private void TwoActivity() {
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(intent);
    }

    private void OneActivity() {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }


}