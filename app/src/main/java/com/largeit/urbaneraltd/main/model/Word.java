package com.largeit.urbaneraltd.main.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Word {


    @SerializedName("pID")
    @Expose
    private Integer pID;

    @SerializedName("pPrice")
    @Expose
    private Integer pPrice;

    @SerializedName("pQty")
    @Expose
    private Integer pQty;

    @SerializedName("pName")
    @Expose
    private String pName;

    @SerializedName("pImage")
    @Expose
    private String pImage;

    @SerializedName("totalCash")
    @Expose
    int totalCash;

    //static ArrayList<Word> wishlist = new ArrayList<>();

    static ArrayList<Word> MyCard = new ArrayList<>();

//    public Word(String productID, String name, String quantity, String price, String image ) {
//        this.name = name;
//        this.quantity = quantity;
//        this.price = price;
//        this.image = image;
//        this.productID = productID;
//    }


    public Word(Integer pID,String pName,  Integer pPrice, Integer pQty,String pImage) {
        this.pID = pID;
        this.pPrice = pPrice;
        this.pQty = pQty;
        this.pName = pName;
        this.pImage = pImage;
    }

    public Word()
    {
        pID = null;
        pPrice = null;
        pQty = null;
        pName = null;
        pImage = null;

    }

//    public void SetWishList(com. word)
//    {
//        this.wishlist.add(0, word);
//    }
//
//    public ArrayList<Word> getWishlist(){return wishlist;}
//
//    public void removeWishList(int position)
//    {
//        wishlist.remove(position);
//    }


    public ArrayList<Word> getMyCard() {
        return MyCard;
    }


    public void removeMyCard(int position)
    {
        MyCard.remove(position);
    }
    public void SetMyCard(Word word)
    {
        MyCard.add(0, word);
    }


//    public String getImage(){
//        return image;
//    }
//
//    public String getWordName() {
//        return name;
//    }
//
//    public String getWordDesc() {
//        return quantity;
//    }
//    public String setWordDesc() {
//        return quantity;
//    }
//
//    public String getWordPrice() {
//        return price;
//    }


    public Integer getProductID() {
        return pID;
    }

    public void setProductID(Integer productID) {
        this.pID = productID;
    }



    public Integer getProductPrice() {
        return pPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.pPrice = productPrice;
    }



    public Integer getProductQty() {
        return pQty;
    }

    public void setProductQty(Integer productQty) {
        this.pQty = productQty;
    }



    public String getProductName() {
        return pName;
    }

    public void setProductName(String productName) {
        this.pName = productName;
    }



    public String getProductImage() {
        return pImage;
    }

    public void setProductImage(String productImage) {
        this.pImage = productImage;
    }


    public int getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(int totalCash) {
        this.totalCash = totalCash;
    }

}
