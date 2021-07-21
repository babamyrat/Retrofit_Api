package com.example.retrofitapi.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PhotoModel {

    @SerializedName("idCategory")
    @Expose
    private String idCategory;
    @SerializedName("strCategory")
    @Expose
    private String strCategory;
    @SerializedName("strCategoryThumb")
    @Expose
    private String strCategoryThumb;
    @SerializedName("strCategoryDescription")
    @Expose
    private String strCategoryDescription;

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
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

    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }

    public void setStrCategoryDescription(String strCategoryDescription) {
        this.strCategoryDescription = strCategoryDescription;
    }

}

//public class PhotoModel {
//    private Integer idCategory;
//    private String strCategory;
//    private String strCategoryThumb;
//    private String strCategoryDescription;
//
//    public PhotoModel(Integer idCategory, String strCategory, String strCategoryThumb, String strCategoryDescription) {
//        this.idCategory = idCategory;
//        this.strCategory = strCategory;
//        this.strCategoryThumb = strCategoryThumb;
//        this.strCategoryDescription = strCategoryDescription;
//    }
//
//    public Integer getIdCategory() {
//        return idCategory;
//    }
//
//    public String getStrCategory() {
//        return strCategory;
//    }
//
//    public String getStrCategoryThumb() {
//        return strCategoryThumb;
//    }
//
//    public String getStrCategoryDescription() {
//        return strCategoryDescription;
//    }
//
//    public void setIdCategory(Integer idCategory) {
//        this.idCategory = idCategory;
//    }
//
//    public void setStrCategory(String strCategory) {
//        this.strCategory = strCategory;
//    }
//
//    public void setStrCategoryThumb(String strCategoryThumb) {
//        this.strCategoryThumb = strCategoryThumb;
//    }
//
//    public void setStrCategoryDescription(String strCategoryDescription) {
//        this.strCategoryDescription = strCategoryDescription;
//    }
//}
