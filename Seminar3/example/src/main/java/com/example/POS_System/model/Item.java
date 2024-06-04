package com.example.POS_System.model;

public class Item {
    private String identifier;
    private String description;
    private double price;
    private double VATRate;
    private int quantity;

    public Item(String identifier, String description, double price, double VATRate) {
        this.identifier = identifier;
        this.description = description;
        this.price = price;
        this.VATRate = VATRate;
        this.quantity = 1;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getVATRate() {
        return VATRate;
    }

    public String getDescription() {
        return description;
    }

    // Setters if needed
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVATRate(double VATRate) {
        this.VATRate = VATRate;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}