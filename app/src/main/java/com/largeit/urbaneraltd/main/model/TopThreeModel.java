package com.largeit.urbaneraltd.main.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopThreeModel {


        @SerializedName("ProductID")
        @Expose
        private Integer productID;
        @SerializedName("ProductName")
        @Expose
        private String productName;
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



}
