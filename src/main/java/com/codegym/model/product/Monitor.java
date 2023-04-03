package com.codegym.model.product;


import com.codegym.model.category.Brand;
import com.codegym.model.category.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Monitor {
    private Integer id;
    @NotBlank(message = "Vui lòng nhập tên màn hình")
    private String name;
    @NotNull(message = "Vui lòng nhập giá ")
    @Min(value = 100000, message = "Giá không hợp lệ")
    private Double price;
    @NotNull(message = "Vui lòng nhập giá cũ ")
    @Min(value = 100000, message = "Giá cũ không hợp lệ")
    private Double oldPrice;
    @NotBlank(message = "Hãy nhập link ảnh cho màn hình")
    private String image;
    @NotBlank(message = "Vui lòng nhập kích thước ")

    private String screenSize;
    @NotBlank(message = "Vui lòng nhập độ phân giải")

    private String resolution;
    @NotBlank(message = "Vui lòng nhập tần số quyét")

    private String scanFrequency;
    @NotBlank(message = "Vui lòng nhập tỉ lệ khung hình")

    private String aspectRatio;
    @NotBlank(message = "Vui lòng nhập các cổng kết nối")

    private String connector;
    @NotBlank(message = "Vui lòng nhập tấm nền ")
    private String panels;
  private Category category;
    private Brand localBrand;

    public Monitor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Brand getLocalBrand() {
        return localBrand;
    }

    public void setLocalBrand(Brand localBrand) {
        this.localBrand = localBrand;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPanels() {
        return panels;
    }

    public void setPanels(String panels) {
        this.panels = panels;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getScanFrequency() {
        return scanFrequency;
    }

    public void setScanFrequency(String scanFrequency) {
        this.scanFrequency = scanFrequency;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }
}
