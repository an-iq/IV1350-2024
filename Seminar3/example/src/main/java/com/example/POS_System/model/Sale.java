package com.example.POS_System.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<Item> items;
    private double totalPrice;
    private double totalVAT;
    private LocalDateTime dateTime;

    public Sale() {
        this.items = new ArrayList<>();
        this.totalPrice = 0;
        this.totalVAT = 0;
        this.dateTime = LocalDateTime.now();
    }

    public void addItem(Item item) {
        for (Item existingItem : items) {
            if (existingItem.getIdentifier().equals(item.getIdentifier())) {
                existingItem.increaseQuantity(item.getQuantity());
                updateTotals();
                return;
            }
        }
        items.add(item);
        updateTotals();
    }

    private void updateTotals() {
        totalPrice = 0;
        totalVAT = 0;
        for (Item item : items) {
            totalPrice += item.getPrice() * item.getQuantity();
            totalVAT += item.getPrice() * item.getQuantity() * item.getVATRate();
        }
    }

    public double getTotalPrice() {
        return totalPrice + totalVAT;
    }

    public Item[] getItems() {
        return items.toArray(new Item[0]);
    }

    public String getDateTime() {
        return dateTime.toString();
    }

    public void removeItem(String identifier) {
        items.removeIf(item -> item.getIdentifier().equals(identifier));
        updateTotals();
    }

    public String pay(double amountPaid) {
        this.paidAmount = amountPaid;
        if (paidAmount >= getTotalPrice()) {
            double change = paidAmount - getTotalPrice();
            return "Payment successful! Change: " + change;
        }
        return "Insufficient payment!";
    }
    
}
