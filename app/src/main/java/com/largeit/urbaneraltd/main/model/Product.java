package com.largeit.urbaneraltd.main.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {


        @SerializedName("ProductID")
        @Expose
        private Integer productID;
        @SerializedName("ProductName")
        @Expose
        private String productName;
        @SerializedName("CategoryID")
        @Expose
        private Integer categoryID;
        @SerializedName("SalePrice")
        @Expose
        private String salePrice;
        @SerializedName("Image")
        @Expose
        private String image;

        public Integer getProductID() {
            return productID;
        }

        public void setProductID(Integer productID) {
            this.productID = productID;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Integer getCategoryID() {
            return categoryID;
        }

        public void setCategoryID(Integer categoryID) {
            this.categoryID = categoryID;
        }

        public String getSalePrice() {
            return salePrice;
        }

        public void setSalePrice(String salePrice) {
            this.salePrice = salePrice;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }


        @Override
        public String toString() {
            return "Product{" +
                    "productID=" + productID +
                    ", productName='" + productName + '\'' +
                    ", categoryID=" + categoryID +
                    ", salePrice='" + salePrice + '\'' +
                    ", image='" + image + '\'' +
                    '}';
        }
}
