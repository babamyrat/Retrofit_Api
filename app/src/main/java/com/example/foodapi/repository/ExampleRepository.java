package com.example.foodapi.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.foodapi.data.api.ApiInterface;
import com.example.foodapi.Utils.NetworkManager;
import com.example.foodapi.response.ExampleResponse;
import com.example.foodapi.data.api.ApiClient;

import retrofit2.Call;
import retrofit2.Retrofit;

public class ExampleRepository {
    private static ExampleRepository exampleRepository;
    private static ApiInterface apiInterface;

    //

  /*  private MutableLiveData<ExampleResponse> liveData = new MutableLiveData<>();*/

    //

    public static ExampleRepository getInstanceExample(){
        if (exampleRepository == null){
            exampleRepository = new ExampleRepository();
        }
        return exampleRepository;
    }

    public ExampleRepository(){
        Retrofit retrofit = ApiClient.getRetrofitInstance();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public Call<ExampleResponse> example() {
        return apiInterface.getAllPhotos();
    }

//    public LiveData<ExampleResponse> fetchData() {
//        if (NetworkManager.isNetworkConnected()) {
//            //
//        }
//        else {
//            //return live data from db
//        }
//    }

}
