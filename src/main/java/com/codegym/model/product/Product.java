package com.codegym.model.product;

import com.codegym.model.category.Brand;
import com.codegym.model.category.Category;
import com.codegym.model.warehouse.WareHouse;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Double oldPrice;
    private String image = "https://channel.mediacdn.vn/428462621602512896/2022/6/18/photo-1-16555357195231361491727.jpg";
    private String keyboard;
    private String connect;
    private String keycap;
    private String switchKey;
    private String reliability;
    private String compatible;
    private String cpu;
    private String mainboard;
    private String ram;
    private String ssd;
    private String vga;
    private String psu;
    private String cases;
    private String sensor;
    private String DPI;
    private String material;
    private String kneelings;
    private String brand;
    @ManyToOne
    private Brand localBrand;
    private String model;
    private String backrest;
    private String hardDrive;
    private String monitor;
    private String pin;
    private String color;
    private String weight;
    private Integer quantity = 0;
    private String os;
    private String screenSize;
    private String resolution;
    private String Switch;
    private String scanFrequency;
    private String aspectRatio;
    private String connector;
    private String panels;
    private Boolean isDelete = false;

    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(Integer id, String name, Double price, Double oldPrice, String image, String connect, String reliability, String compatible, String sensor, String DPI, String weight, String os, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.oldPrice = oldPrice;
        this.image = image;
        this.connect = connect;
        this.reliability = reliability;
        this.compatible = compatible;
        this.sensor = sensor;
        this.DPI = DPI;
        this.weight = weight;
        this.os = os;
        this.category = category;
    }

    public Product(Integer id, String name, Double price, Double oldPrice, String image, String screenSize, String resolution, String scanFrequency, String aspectRatio, String connector, String panels, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.oldPrice = oldPrice;
        this.image = image;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.scanFrequency = scanFrequency;
        this.aspectRatio = aspectRatio;
        this.connector = connector;
        this.panels = panels;
        this.category = category;
    }

    public Product(String name, Double price, Double oldPrice, String image, String cpu, String ram, String vga, String hardDrive, String monitor, String pin, String color, String weight, String os, Category category) {
        this.name = name;
        this.price = price;
        this.oldPrice = oldPrice;
        this.image = image;
        this.cpu = cpu;
        this.ram = ram;
        this.vga = vga;
        this.hardDrive = hardDrive;
        this.monitor = monitor;
        this.pin = pin;
        this.color = color;
        this.weight = weight;
        this.os = os;
        this.category = category;
    }

    public Product(String name, Double price, Double oldPrice, String image, String keyboard, String connect, String keycap, String aswitchKey, String reliability, String compatible, Category category) {
        this.name = name;
        this.price = price;
        this.oldPrice = oldPrice;
        this.image = image;
        this.keyboard = keyboard;
        this.connect = connect;
        this.keycap = keycap;
        this.switchKey = aswitchKey;
        this.reliability = reliability;
        this.compatible = compatible;
        this.category = category;
    }

    public Product(String name, Double price, Double oldPrice, String image, String material, String kneelings, String model, String brand, String backrest, Category category) {
        this.name = name;
        this.price = price;
        this.oldPrice = oldPrice;
        this.image = image;
        this.material = material;
        this.kneelings = kneelings;
        this.brand = brand;
        this.model = model;
        this.backrest = backrest;
        this.category = category;
    }
    public Product( String name, Double price, Double oldPrice, String image, String cpu, String mainboard, String ram, String ssd, String vga, String psu, String cases,Category category) {

        this.name = name;
        this.price = price;
        this.oldPrice = oldPrice;
        this.image = image;
        this.cpu = cpu;
        this.mainboard = mainboard;
        this.ram = ram;
        this.ssd = ssd;
        this.vga = vga;
        this.psu = psu;
        this.cases = cases;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public String getSwitch() {
        return Switch;
    }

    public void setSwitch(String aSwitch) {
        Switch = aSwitch;
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

    public void setKeycap(String keycap) {
        this.keycap = keycap;
    }



    public String getReliability() {
        return reliability;
    }

    public void setReliability(String reliability) {
        this.reliability = reliability;
    }

    public String getCompatible() {
        return compatible;
    }

    public void setCompatible(String compatible) {
        this.compatible = compatible;
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

    public String getSwitchKey() {
        return switchKey;
    }

    public void setSwitchKey(String switchKey) {
        this.switchKey = switchKey;
    }

    public Brand getLocalBrand() {
        return localBrand;
    }

    public void setLocalBrand(Brand localBrand) {
        this.localBrand = localBrand;
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

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
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

    public String getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
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

    public String getPanels() {
        return panels;
    }

    public void setPanels(String panels) {
        this.panels = panels;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
