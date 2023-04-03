package com.codegym.model.product;


import com.codegym.model.category.Brand;
import com.codegym.model.category.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Keyboard {
   private Integer id;
    @NotBlank(message = "Hãy nhập tên bàn phím")
    private String name;
    @NotNull(message = "Vui lòng nhập giá")
    @Min(value = 100000, message = "Giá phải lớn hơn 100000đ")

    private Double price;
    @NotNull(message = "Vui lòng nhập giá cũ")
    @Min(value = 100000, message = "Giá cũ phải lớn hơn 100000đ")

    private Double oldPrice;
    @NotBlank(message = "Hãy nhập link ảnh để mô tả cho Bàn Phím")
    private String image;
    @NotBlank(message = "Vui lòng nhập tính năng")
    private String keyboard;
    @NotBlank(message = "Vui lòng nhập các loại cổng ")
    private String connect;
    @NotBlank(message = "Vui lòng nhập chất liệu keycap ")
    private String keycap;
    @NotBlank(message = "Vui lòng nhập loại switch ")
    private String switchKey;
    @NotBlank(message = "Vui lòng nhập độ chính xác ")
    private String reliability;
    @NotBlank(message = "Vui lòng nhập hộ trợ tương thích ")
    private String compatible;
    private Brand localBrand;
    private Category category;

    public Keyboard() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public String getKeycap() {
        return keycap;
    }
    public Brand getLocalBrand() {
        return localBrand;
    }

    public void setLocalBrand(Brand localBrand) {
        this.localBrand = localBrand;
    }
    public void setKeycap(String keycap) {
        this.keycap = keycap;
    }

    public String getswitchKey() {
        return switchKey;
    }

    public void setswitchKey(String switchKey) {
        this.switchKey = switchKey;
    }

    public String getReliability() {
        return reliability;
    }

    public void setReliability(String reliability) {
        this.reliability = reliability;
    }

    public String getCompatible() {
        return this.compatible;
    }

    public void setCompatible(String compatible) {
        this.compatible = compatible;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", oldPrice=" + oldPrice +
                ", image='" + image + '\'' +
                ", keyboard='" + keyboard + '\'' +
                ", connect='" + connect + '\'' +
                ", keycap='" + keycap + '\'' +
                ", Switch='" + switchKey + '\'' +
                ", reliability='" + reliability + '\'' +
                ", compatible='" + compatible + '\'' +
                ", category=" + category +
                '}';
    }
}
