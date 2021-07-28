package com.example.foodapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {

        @SerializedName("meals")
        @Expose
        private List<SearchModel> meals = null;

        public List<SearchModel> getMeals() {
            return meals;
        }

        public void setMeals(List<SearchModel> meals) {
            this.meals = meals;
        }
}
