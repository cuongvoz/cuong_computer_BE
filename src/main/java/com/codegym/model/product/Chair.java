package com.codegym.model.product;


import com.codegym.model.category.Brand;
import com.codegym.model.category.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Chair {
    private Integer id;
    @NotBlank(message = "Vui lòng nhập tên Ghế")
    private String name;
    @NotNull(message = "Vui lòng nhập giá")
    @Min(value = 100000, message = "Giá phải lớn hơn 100000đ")
    private Double price;
    @NotNull(message = "Vui lòng nhập giá cũ")
    @Min(value = 100000, message = "Giá cũ phải lớn hơn 100000đ")
    private Double oldPrice;
    @NotBlank(message = "Vui lòng chọn hình ảnh")
    private String image;
    @NotBlank(message = "Vui lòng nhập chất liệu")
    private String material;
    @NotBlank(message = "Vui lòng nhập loại kê tay")
    private String kneelings;
    @NotBlank(message = "Vui lòng nhập hãng")
    private String brand;
    @NotBlank(message = "Vui lòng nhập Model")
    private String model;
    @NotBlank(message = "Vui lòng nhập kiểu ngả lưng")
    private String backrest;
    private Brand localBrand;
    private Category category;

    public Chair() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Brand getLocalBrand() {
        return localBrand;
    }

    public void setLocalBrand(Brand localBrand) {
        this.localBrand = localBrand;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getKneelings() {
        return kneelings;
    }

    public void setKneelings(String kneelings) {
        this.kneelings = kneelings;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBackrest() {
        return backrest;
    }

    public void setBackrest(String backrest) {
        this.backrest = backrest;
    }
}
