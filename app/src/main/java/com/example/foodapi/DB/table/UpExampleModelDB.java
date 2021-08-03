package com.example.foodapi.DB.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "ExampleModelDB")
public class UpExampleModelDB {

        @PrimaryKey(autoGenerate = true)
        private int id;

        @ColumnInfo(name = "idCategory")
        String idCategory;

        @ColumnInfo(name = "strCategory")
        String strCategory;

        @ColumnInfo(name = "strCategoryThumb")
        String strCategoryThumb;

        @ColumnInfo(name = "strCategoryDescription")
        String strCategoryDescription;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
