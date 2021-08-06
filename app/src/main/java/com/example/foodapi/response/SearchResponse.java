package com.example.foodapi.response;

import com.example.foodapi.model.SearchModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {

    @SerializedName("meals")
    @Expose
    private List<SearchModel> results = null;

    public List<SearchModel> getResultsSearch() {
        return results;
    }

    public void setResults(List<SearchModel> results) {
        this.results = results;
    }

}

