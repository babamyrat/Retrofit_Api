package com.example.foodapi.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "categories")
public class ExampleModel {
    @PrimaryKey
    @SerializedName("idCategory")
    @Expose
    private Integer idCategory;
    @SerializedName("strCategory")
    @Expose
    private String strCategory;
    @SerializedName("strCategoryThumb")
    @Expose
    private String strCategoryThumb;
//    @SerializedName("strCategoryDescription")
//    @Expose
//    private String strCategoryDescription;


    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    public void setStrCategoryThumb(String strCategoryThumb) {
        this.strCategoryThumb = strCategoryThumb;
    }
//
//    public String getStrCategoryDescription() {
//        return strCategoryDescription;
//    }
//
//    public void setStrCategoryDescription(String strCategoryDescription) {
//        this.strCategoryDescription = strCategoryDescription;
//    }

}
