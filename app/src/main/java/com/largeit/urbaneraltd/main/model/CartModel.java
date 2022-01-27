package com.largeit.urbaneraltd.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartModel {


    Integer ProductID;
    String ProductuName;
    Integer SalePricce;
    Integer Quantity;

    public CartModel(Integer productID, String productuName, Integer salePricce, Integer quantity) {
        ProductID = productID;
        ProductuName = productuName;
        SalePricce = salePricce;
        Quantity = quantity;
    }

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public String getProductuName() {
        return ProductuName;
    }

    public void setProductuName(String productuName) {
        ProductuName = productuName;
    }

    public Integer getSalePricce() {
        return SalePricce;
    }

    public void setSalePricce(Integer salePricce) {
        SalePricce = salePricce;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    //    @SerializedName("cart_count")
//    @Expose
//    private Integer cartCount;
//
//    public CartModel(Integer cartCount) {
//        this.cartCount = cartCount;
//    }
//
//    public Integer getCartCount() {
//        return cartCount;
//    }
//
//
//    public void setCartCount(Integer cartCount) {
//        this.cartCount = cartCount;
//    }


}
