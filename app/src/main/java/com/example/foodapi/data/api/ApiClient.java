package com.example.foodapi.data.api;

import static com.example.foodapi.utils.Constant.BASE_URL;

import android.annotation.SuppressLint;
import android.content.Context;


import com.example.foodapi.response.ExampleResponse;
import com.example.foodapi.response.SearchResponse;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private ApiService apiService;
    @SuppressLint("StaticFieldLeak")
    private static ApiClient instance;
    private Context context;

    private ApiClient(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(BASE_URL)
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static ApiClient newInstance(){
        if (instance == null)
            instance = new ApiClient();
        return instance;
    }

    public Observable<ExampleResponse> getCategories(){
        return apiService.getCategory();
    }


    public Observable<SearchResponse> getCategoriesSearch(){
        return apiService.getSearch();
    }
}
