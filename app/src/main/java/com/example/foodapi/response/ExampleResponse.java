package com.example.foodapi.response;

import com.example.foodapi.model.ExampleModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExampleResponse {

    @SerializedName("categories")
    @Expose
    private List<ExampleModel> results = null;

    public List<ExampleModel> getResults() {
        return results;
    }

    public void setResults(List<ExampleModel> results) {
        this.results = results;
    }

}

