package com.largeit.urbaneraltd.TestServer.model;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.largeit.urbaneraltd.TestServer.model.ListOrder;

public class CartList {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("grandtotal")
    @Expose
    private Integer grandtotal;
    @SerializedName("deliverycost")
    @Expose
    private Integer deliverycost;
    @SerializedName("total_quantity")
    @Expose
    private Integer totalQuantity;

    @SerializedName("cartlist")
    @Expose
    private List<ListOrder> cartlist;


    public CartList(String name, String number, String email, String address, Integer grandtotal, Integer deliverycost, Integer totalQuantity, List<ListOrder> cartlist) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.address = address;
        this.grandtotal = grandtotal;
        this.deliverycost = deliverycost;
        this.totalQuantity = totalQuantity;
        this.cartlist = cartlist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(Integer grandtotal) {
        this.grandtotal = grandtotal;
    }

    public Integer getDeliverycost() {
        return deliverycost;
    }

    public void setDeliverycost(Integer deliverycost) {
        this.deliverycost = deliverycost;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public List<ListOrder> getCartlist() {
        return cartlist;
    }

    public void setCartlist(List<ListOrder> cartlist) {
        this.cartlist = cartlist;
    }
}
