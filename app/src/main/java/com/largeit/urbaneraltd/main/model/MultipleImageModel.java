package com.largeit.urbaneraltd.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MultipleImageModel {

        @SerializedName("Image")
        @Expose
        private String image;
        @SerializedName("ProductID")
        @Expose
        private Integer productID;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Integer getProductID() {
            return productID;
        }

        public void setProductID(Integer productID) {
            this.productID = productID;
        }


    @Override
    public String toString() {
        return "MultipleImageModel{" +
                "image='" + image + '\'' +
                ", productID=" + productID +
                '}';
    }
}


