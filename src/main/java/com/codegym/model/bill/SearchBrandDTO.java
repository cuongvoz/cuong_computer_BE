package com.codegym.model.bill;

import java.util.List;

public class SearchBrandDTO {
    private int id;
    private List<Integer> brand;

    public SearchBrandDTO(int id, List<Integer> brand) {
        this.id = id;
        this.brand = brand;
    }

    public SearchBrandDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getBrand() {
        return brand;
    }

    public void setBrand(List<Integer> brand) {
        this.brand = brand;
    }
}
