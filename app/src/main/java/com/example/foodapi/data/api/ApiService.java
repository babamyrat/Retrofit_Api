package com.example.foodapi.data.api;



import static com.example.foodapi.utils.Constant.EXAMPLE_API_KEY;
import static com.example.foodapi.utils.Constant.SEARCH_API_KEY;

import com.example.foodapi.model.response.ExampleResponse;
import com.example.foodapi.model.response.SearchResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET(EXAMPLE_API_KEY)
    Observable<ExampleResponse> getCategory();

    @GET(SEARCH_API_KEY)
    Observable<SearchResponse> getSearch(@Query("s") String query);

}
