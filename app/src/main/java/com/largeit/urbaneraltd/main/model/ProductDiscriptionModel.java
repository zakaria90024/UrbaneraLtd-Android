package com.largeit.urbaneraltd.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProductDiscriptionModel {




        @SerializedName("ProductID")
        @Expose
        private Integer productID;
        @SerializedName("ProductName")
        @Expose
        private String productName;
        @SerializedName("CategoryID")
        @Expose
        private Integer categoryID;
        @SerializedName("product_subcategory_id")
        @Expose
        private Object productSubcategoryId;
        @SerializedName("VendorID")
        @Expose
        private Integer vendorID;
        @SerializedName("Qty")
        @Expose
        private Integer qty;
        @SerializedName("ShortDescription")
        @Expose
        private String shortDescription;
        @SerializedName("LongDescription")
        @Expose
        private String longDescription;
        @SerializedName("SalePrice")
        @Expose
        private String salePrice;
        @SerializedName("Image")
        @Expose
        private String image;
        @SerializedName("ShopName")
        @Expose
        private String shopName;
        @SerializedName("VendorName")
        @Expose
        private String vendorName;

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

        public Object getProductSubcategoryId() {
            return productSubcategoryId;
        }

        public void setProductSubcategoryId(Object productSubcategoryId) {
            this.productSubcategoryId = productSubcategoryId;
        }

        public Integer getVendorID() {
            return vendorID;
        }

        public void setVendorID(Integer vendorID) {
            this.vendorID = vendorID;
        }

        public Integer getQty() {
            return qty;
        }

        public void setQty(Integer qty) {
            this.qty = qty;
        }

        public String getShortDescription() {
            return shortDescription;
        }

        public void setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
        }

        public String getLongDescription() {
            return longDescription;
        }

        public void setLongDescription(String longDescription) {
            this.longDescription = longDescription;
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

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getVendorName() {
            return vendorName;
        }

        public void setVendorName(String vendorName) {
            this.vendorName = vendorName;
        }



}
