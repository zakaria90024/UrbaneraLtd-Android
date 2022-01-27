package com.largeit.urbaneraltd.main.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class TopOneNameModel {



    @SerializedName("category_managment_id")
    @Expose
    private Integer categoryManagmentId;
    @SerializedName("CategoryName")
    @Expose
    private String categoryName;
    @SerializedName("CategoryID")
    @Expose
    private Integer categoryID;

    public Integer getCategoryManagmentId() {
        return categoryManagmentId;
    }

    public void setCategoryManagmentId(Integer categoryManagmentId) {
        this.categoryManagmentId = categoryManagmentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }



}
