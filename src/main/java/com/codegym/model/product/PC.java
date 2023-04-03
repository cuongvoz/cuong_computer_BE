package com.codegym.model.product;


import com.codegym.model.category.Brand;
import com.codegym.model.category.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PC {
    private Integer id;
    @NotBlank(message = "Vui lòng nhập tên ")
    private String name;
    @NotNull(message = "Vui lòng nhập giá")
    @Min(value = 10000, message = "Giá của PC phải lớn hơn 10000đ")
    private Double price;
    @NotNull(message = "Vui lòng nhập giá cũ PC")
    @Min(value = 10000, message = "Giá cũ của Chuột phải lớn hơn 10000đ")
    private Double oldPrice;
    @NotBlank(message = "Hãy nhập link ảnh để mô tả ")
    private String image;
    @NotBlank(message = "Vui lòng nhập CPU")
    private String cpu;
    @NotBlank(message = "Vui lòng nhập Mainboard")
    private String mainboard;
    @NotBlank(message = "Vui lòng nhập RAM ")
    private String ram;
    @NotBlank(message = "Vui lòng nhập SSD ")
    private String ssd;
    @NotBlank(message = "Vui lòng nhập VGA ")
    private String vga;
    @NotBlank(message = "Vui lòng nhập PSU ")
    private String psu;
    @NotBlank(message = "Vui lòng nhập CASE ")
    private String cases;
    private Category category;
    public PC() {
    }

    public Category getCategory() {
        return category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMainboard() {
        return mainboard;
    }

    public void setMainboard(String mainboard) {
        this.mainboard = mainboard;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getVga() {
        return vga;
    }

    public void setVga(String vga) {
        this.vga = vga;
    }

    public String getPsu() {
        return psu;
    }

    public void setPsu(String psu) {
        this.psu = psu;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    @Override
    public String toString() {
        return "PC{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", oldPrice=" + oldPrice +
                ", image='" + image + '\'' +
                ", cpu='" + cpu + '\'' +
                ", mainboard='" + mainboard + '\'' +
                ", ram='" + ram + '\'' +
                ", ssd='" + ssd + '\'' +
                ", vga='" + vga + '\'' +
                ", psu='" + psu + '\'' +
                ", cases='" + cases + '\'' +
                '}';
    }
}
