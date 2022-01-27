package com.largeit.urbaneraltd.TestServer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {



        @SerializedName("OrderProductID")
        @Expose
        private Integer orderProductID;
        @SerializedName("OrderID")
        @Expose
        private Integer orderID;
        @SerializedName("ProductID")
        @Expose
        private Integer productID;
        @SerializedName("CustomerID")
        @Expose
        private Integer customerID;
        @SerializedName("VendorID")
        @Expose
        private Integer vendorID;
        @SerializedName("UserID")
        @Expose
        private Integer userID;
        @SerializedName("Qty")
        @Expose
        private String qty;
        @SerializedName("Price")
        @Expose
        private String price;
        @SerializedName("TotalPrice")
        @Expose
        private String totalPrice;
        @SerializedName("Percentage")
        @Expose
        private String percentage;
        @SerializedName("Discount")
        @Expose
        private String discount;
        @SerializedName("Notes")
        @Expose
        private String notes;
        @SerializedName("IsConfirmed")
        @Expose
        private Integer isConfirmed;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public Integer getOrderProductID() {
            return orderProductID;
        }

        public void setOrderProductID(Integer orderProductID) {
            this.orderProductID = orderProductID;
        }

        public Integer getOrderID() {
            return orderID;
        }

        public void setOrderID(Integer orderID) {
            this.orderID = orderID;
        }

        public Integer getProductID() {
            return productID;
        }

        public void setProductID(Integer productID) {
            this.productID = productID;
        }

        public Integer getCustomerID() {
            return customerID;
        }

        public void setCustomerID(Integer customerID) {
            this.customerID = customerID;
        }

        public Integer getVendorID() {
            return vendorID;
        }

        public void setVendorID(Integer vendorID) {
            this.vendorID = vendorID;
        }

        public Integer getUserID() {
            return userID;
        }

        public void setUserID(Integer userID) {
            this.userID = userID;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(String totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getPercentage() {
            return percentage;
        }

        public void setPercentage(String percentage) {
            this.percentage = percentage;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public Integer getIsConfirmed() {
            return isConfirmed;
        }

        public void setIsConfirmed(Integer isConfirmed) {
            this.isConfirmed = isConfirmed;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }



}
