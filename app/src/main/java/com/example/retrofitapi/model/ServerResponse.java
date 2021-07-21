package com.example.retrofitapi.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class ServerResponse {

    @SerializedName("categories")
    @Expose
    private List<PhotoModel> categories = new ArrayList<>();

    public List<PhotoModel> getCategories() {
        return categories;
    }

    public void setCategories(List<PhotoModel> categories) {
        this.categories = categories;
    }

}
