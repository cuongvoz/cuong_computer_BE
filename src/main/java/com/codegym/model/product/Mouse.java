package com.codegym.model.product;


import com.codegym.model.category.Brand;
import com.codegym.model.category.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Mouse {
    private Integer id;
    @NotBlank(message = "Vui lòng nhập tên chuột")
    private String name;
    @NotNull(message = "Vui lòng nhập giá")
    @Min(value = 10000, message = "Giá phải lớn hơn 10000đ")

    private Double price;
    @NotNull(message = "Vui lòng nhập giá cũ ")
    @Min(value = 10000, message = "Giá cũ phải lớn hơn 10000đ")

    private Double oldPrice;
    @NotBlank(message = "Hãy nhập link ảnh ")
    private String image;
    @NotBlank(message = "Vui lòng nhập cảm biến")
    private String sensor;
    @NotBlank(message = "Vui lòng nhập DPI")
    private String dpi;
    @NotBlank(message = "Vui lòng nhập trọng lượng")
    private String weight;
    @NotBlank(message = "Vui lòng nhập tính năng")
    private String compatible;
    @NotBlank(message = "Vui lòng nhập cổng kết nối")
   private String connect;
    @NotBlank(message = "Vui lòng nhập hệ điều hành")
    private String os;
    private Brand localBrand;
    @NotBlank(message = "Vui lòng nhập điểm nổi bật")
    private String reliability;
    private Category category;
    public Mouse() {
    }

    public String getSensor() {
        return sensor;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getImage() {
        return image;
    }
    public Brand getLocalBrand() {
        return localBrand;
    }

    public void setLocalBrand(Brand localBrand) {
        this.localBrand = localBrand;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCompatible() {
        return compatible;
    }

    public void setCompatible(String compatible) {
        this.compatible = compatible;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getReliability() {
        return reliability;
    }

    public void setReliability(String reliability) {
        this.reliability = reliability;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", oldPrice=" + oldPrice +
                ", image='" + image + '\'' +
                ", sensor='" + sensor + '\'' +
                ", dpi='" + dpi + '\'' +
                ", weight='" + weight + '\'' +
                ", compatible='" + compatible + '\'' +
                ", connect='" + connect + '\'' +
                ", os='" + os + '\'' +
                ", reliability='" + reliability + '\'' +
                ", category=" + category +
                '}';
    }
}
