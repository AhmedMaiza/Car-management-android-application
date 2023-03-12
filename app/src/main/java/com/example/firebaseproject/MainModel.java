package com.example.firebaseproject;

public class MainModel {
    String name,manufacturer,origin,price,turl;
    MainModel()
    {

    }
    public MainModel(String name, String manufacturer, String origin, String price, String turl) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.origin = origin;
        this.price = price;
        this.turl = turl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTurl() {
        return turl;
    }

    public void setTurl(String turl) {
        this.turl = turl;
    }
}
