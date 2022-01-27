package com.largeit.urbaneraltd.TestServer.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Order {

        @SerializedName("OrderID")
        @Expose
        private Integer orderID;
        @SerializedName("UserID")
        @Expose
        private Integer userID;
        @SerializedName("CustomerID")
        @Expose
        private Integer customerID;
        @SerializedName("VendorID")
        @Expose
        private Integer vendorID;
        @SerializedName("RiderID")
        @Expose
        private Integer riderID;
        @SerializedName("TotalPrice")
        @Expose
        private String totalPrice;
        @SerializedName("TotalQty")
        @Expose
        private String totalQty;
        @SerializedName("admin_commission_amount")
        @Expose
        private Object adminCommissionAmount;
        @SerializedName("vendor_received_amount")
        @Expose
        private Object vendorReceivedAmount;
        @SerializedName("Percentage")
        @Expose
        private String percentage;
        @SerializedName("Discount")
        @Expose
        private String discount;
        @SerializedName("Phone")
        @Expose
        private String phone;
        @SerializedName("CustomerName")
        @Expose
        private String customerName;
        @SerializedName("ShippingAddress")
        @Expose
        private String shippingAddress;
        @SerializedName("BillingAddress")
        @Expose
        private Object billingAddress;
        @SerializedName("VendorReceived")
        @Expose
        private Integer vendorReceived;
        @SerializedName("RiderReceived")
        @Expose
        private Integer riderReceived;
        @SerializedName("CustomerReceived")
        @Expose
        private Integer customerReceived;
        @SerializedName("InvoiceID")
        @Expose
        private Integer invoiceID;
        @SerializedName("delivery_charge")
        @Expose
        private Integer deliveryCharge;
        @SerializedName("Comments")
        @Expose
        private String comments;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public Integer getOrderID() {
            return orderID;
        }

        public void setOrderID(Integer orderID) {
            this.orderID = orderID;
        }

        public Integer getUserID() {
            return userID;
        }

        public void setUserID(Integer userID) {
            this.userID = userID;
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

        public Integer getRiderID() {
            return riderID;
        }

        public void setRiderID(Integer riderID) {
            this.riderID = riderID;
        }

        public String getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(String totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getTotalQty() {
            return totalQty;
        }

        public void setTotalQty(String totalQty) {
            this.totalQty = totalQty;
        }

        public Object getAdminCommissionAmount() {
            return adminCommissionAmount;
        }

        public void setAdminCommissionAmount(Object adminCommissionAmount) {
            this.adminCommissionAmount = adminCommissionAmount;
        }

        public Object getVendorReceivedAmount() {
            return vendorReceivedAmount;
        }

        public void setVendorReceivedAmount(Object vendorReceivedAmount) {
            this.vendorReceivedAmount = vendorReceivedAmount;
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getShippingAddress() {
            return shippingAddress;
        }

        public void setShippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
        }

        public Object getBillingAddress() {
            return billingAddress;
        }

        public void setBillingAddress(Object billingAddress) {
            this.billingAddress = billingAddress;
        }

        public Integer getVendorReceived() {
            return vendorReceived;
        }

        public void setVendorReceived(Integer vendorReceived) {
            this.vendorReceived = vendorReceived;
        }

        public Integer getRiderReceived() {
            return riderReceived;
        }

        public void setRiderReceived(Integer riderReceived) {
            this.riderReceived = riderReceived;
        }

        public Integer getCustomerReceived() {
            return customerReceived;
        }

        public void setCustomerReceived(Integer customerReceived) {
            this.customerReceived = customerReceived;
        }

        public Integer getInvoiceID() {
            return invoiceID;
        }

        public void setInvoiceID(Integer invoiceID) {
            this.invoiceID = invoiceID;
        }

        public Integer getDeliveryCharge() {
            return deliveryCharge;
        }

        public void setDeliveryCharge(Integer deliveryCharge) {
            this.deliveryCharge = deliveryCharge;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
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
