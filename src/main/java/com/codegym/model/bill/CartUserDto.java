package com.codegym.model.bill;

import java.util.Arrays;

public class CartUserDto {
    private int id;
    private Cart[] carts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cart[] getCarts() {
        return carts;
    }

    public void setCarts(Cart[] carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "CartUserDto{" +
                "id=" + id +
                ", carts=" + Arrays.toString(carts) +
                '}';
    }
}
