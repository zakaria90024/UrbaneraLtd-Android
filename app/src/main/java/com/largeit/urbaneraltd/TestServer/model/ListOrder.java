package com.largeit.urbaneraltd.TestServer.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListOrder {

        @SerializedName("pID")
        @Expose
        private Integer pID;
        @SerializedName("pName")
        @Expose
        private String pName;
        @SerializedName("pPrice")
        @Expose
        private Integer pPrice;
        @SerializedName("pQty")
        @Expose
        private Integer pQty;
        @SerializedName("pImage")
        @Expose
        private String pImage;

    public ListOrder(Integer pID, String pName, Integer pPrice, Integer pQty, String pImage) {
        this.pID = pID;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pQty = pQty;
        this.pImage = pImage;
    }

    public Integer getPID() {
            return pID;
        }

        public void setPID(Integer pID) {
            this.pID = pID;
        }

        public String getPName() {
            return pName;
        }

        public void setPName(String pName) {
            this.pName = pName;
        }

        public Integer getPPrice() {
            return pPrice;
        }

        public void setPPrice(Integer pPrice) {
            this.pPrice = pPrice;
        }

        public Integer getPQty() {
            return pQty;
        }

        public void setPQty(Integer pQty) {
            this.pQty = pQty;
        }

        public String getPImage() {
            return pImage;
        }

        public void setPImage(String pImage) {
            this.pImage = pImage;
        }


}
