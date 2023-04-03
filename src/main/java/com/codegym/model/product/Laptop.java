package com.codegym.model.product;


import com.codegym.model.category.Brand;
import com.codegym.model.category.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Laptop {
    private Integer id;
    @NotBlank(message = "Vui lòng nhập tên Laptop")
    private String name;
    @NotNull(message = "Vui lòng nhập giá")
    @Min(value = 100000, message = "Giá phải lớn hơn 100000đ")

    private Double price;
    @NotNull(message = "Vui lòng nhập giá cũ")
    @Min(value = 100000, message = "Giá cũ phải lớn hơn 100000đ")

    private Double oldPrice;
    @NotBlank(message = "Hãy nhập link ảnh để mô tả cho Laptop")
    private String image;
    @NotBlank(message = "Vui lòng nhập CPU")
    private String cpu;
    @NotBlank(message = "Vui lòng nhập RAM")
    private String ram;
    @NotBlank(message = "Vui lòng nhập ổ cứng")
    private String hardDrive;
    @NotBlank(message = "Vui lòng nhập VGA")
    private String vga;
    @NotBlank(message = "Vui lòng nhập màn hình")
    private String monitor;
    @NotBlank(message = "Hãy nhập thông số PIN")
    private String pin;
    @NotBlank(message = "Hãy nhập màu sắc")
    private String color;
    @NotBlank(message = "Hãy nhập trọng lượng")
    private String weight;
    @NotBlank(message = "Hãy nhập các hệ điều hành")
    private String os;
    private Brand localBrand;

    public Category category;
    public Laptop() {
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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public String getVga() {
        return vga;
    }

    public void setVga(String vga) {
        this.vga = vga;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
