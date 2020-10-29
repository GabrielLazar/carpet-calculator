package com.gabriellazar.models;

public class Calculator {

    private String city;
    private String state;
    private String shape;
    private double area;
    private double priceBeforeTaxes;
    private double stateTax;
    private double finalPrice;


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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPriceBeforeTaxes() {
        return priceBeforeTaxes;
    }

    public void setPriceBeforeTaxes(double priceBeforeTaxes) {
        this.priceBeforeTaxes = priceBeforeTaxes;
    }

    public double getStateTax() {
        return stateTax;
    }

    public void setStateTax(double stateTax) {
        this.stateTax = stateTax;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
}
