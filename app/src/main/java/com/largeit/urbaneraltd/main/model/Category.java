package com.largeit.urbaneraltd.main.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

        @SerializedName("CategoryID")
        @Expose
        private Integer categoryID;
        @SerializedName("CategoryName")
        @Expose
        private String categoryName;
        @SerializedName("ProductQty")
        @Expose
        private String productQty;
        @SerializedName("ProductNumbers")
        @Expose
        private Integer productNumbers;
        @SerializedName("Image")
        @Expose
        private String image;
        @SerializedName("thumbnail")
        @Expose
        private String thumbnail;
        @SerializedName("IsShown")
        @Expose
        private Integer isShown;
        @SerializedName("IsDisabled")
        @Expose
        private Integer isDisabled;
        @SerializedName("is_menu")
        @Expose
        private Integer isMenu;
        @SerializedName("sort_id")
        @Expose
        private Integer sortId;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("has_product_count")
        @Expose
        private Integer hasProductCount;

        public Integer getCategoryID() {
            return categoryID;
        }

        public void setCategoryID(Integer categoryID) {
            this.categoryID = categoryID;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getProductQty() {
            return productQty;
        }

        public void setProductQty(String productQty) {
            this.productQty = productQty;
        }

        public Integer getProductNumbers() {
            return productNumbers;
        }

        public void setProductNumbers(Integer productNumbers) {
            this.productNumbers = productNumbers;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public Integer getIsShown() {
            return isShown;
        }

        public void setIsShown(Integer isShown) {
            this.isShown = isShown;
        }

        public Integer getIsDisabled() {
            return isDisabled;
        }

        public void setIsDisabled(Integer isDisabled) {
            this.isDisabled = isDisabled;
        }

        public Integer getIsMenu() {
            return isMenu;
        }

        public void setIsMenu(Integer isMenu) {
            this.isMenu = isMenu;
        }

        public Integer getSortId() {
            return sortId;
        }

        public void setSortId(Integer sortId) {
            this.sortId = sortId;
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

        public Integer getHasProductCount() {
            return hasProductCount;
        }

        public void setHasProductCount(Integer hasProductCount) {
            this.hasProductCount = hasProductCount;
        }

    @Override
    public String toString() {
        return "Category{" +
                "categoryID=" + categoryID +
                ", categoryName='" + categoryName + '\'' +
                ", productQty='" + productQty + '\'' +
                ", productNumbers=" + productNumbers +
                ", image='" + image + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", isShown=" + isShown +
                ", isDisabled=" + isDisabled +
                ", isMenu=" + isMenu +
                ", sortId=" + sortId +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", hasProductCount=" + hasProductCount +
                '}';
    }
}
