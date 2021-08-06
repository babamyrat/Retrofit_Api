package com.example.foodapi.data.api;



import static com.example.foodapi.utils.Constant.EXAMPLE_API_KEY;
import static com.example.foodapi.utils.Constant.SEARCH_API_KEY;

import com.example.foodapi.response.ExampleResponse;
import com.example.foodapi.response.SearchResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET(EXAMPLE_API_KEY)
    Observable<ExampleResponse> getCategory();

    @GET(SEARCH_API_KEY)
    Observable<SearchResponse> getSearch();


//    @Headers("Content-Type: application/json")
//    @GET("catalog/category")
//    Observable<CategoryResponse> getCategory();

    //https://api.npoint.io/0647b08d610d10edf331
}
