package com.codegym.model.bill;

import java.util.Arrays;

public class BillDTO {
    private String userID;
    private String buyDay;
    private String total;
    private Cart[] cart;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBuyDay() {
        return buyDay;
    }

    public void setBuyDay(String buyDay) {
        this.buyDay = buyDay;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Cart[] getCart() {
        return cart;
    }

    public void setCart(Cart[] cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "BillDTO{" +
                "userID=" + userID +
                ", buyDay='" + buyDay + '\'' +
                ", total=" + total +
                ", cart=" + Arrays.toString(cart) +
                '}';
    }
}
