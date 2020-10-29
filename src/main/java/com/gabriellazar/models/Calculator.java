package com.gabriellazar.models;

public class Calculator {

    private String city;
    private String state;
    private String shape;
    private String area;
    private String priceBeforeTaxes;
    private String stateTax;
    private String finalPrice;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPriceBeforeTaxes() {
        return priceBeforeTaxes;
    }

    public void setPriceBeforeTaxes(String priceBeforeTaxes) {
        this.priceBeforeTaxes = priceBeforeTaxes;
    }

    public String getStateTax() {
        return stateTax;
    }

    public void setStateTax(String stateTax) {
        this.stateTax = stateTax;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }
}
