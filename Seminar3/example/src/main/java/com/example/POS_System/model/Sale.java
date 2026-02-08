package com.example.POS_System.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<Item> items;
    private double totalPrice;
    private double totalVAT;
    private LocalDateTime dateTime;
    public double amountPaid;

    public Sale() {
        this.items = new ArrayList<>();
        this.totalPrice = 0;
        this.totalVAT = 0;
        this.dateTime = LocalDateTime.now();
    }

   /*  public void addItem(Item item) {
        for (Item existingItem : items) {
            if (existingItem.getIdentifier().equals(item.getIdentifier())) {
                existingItem.increaseQuantity(item.getQuantity());
                updateTotals();
                return;
            }
        }
        items.add(item);
        updateTotals();
    } */

        // Change the addItem function to store inventory items directly.
        public void addItem(Item inventoryItem){
            for(Item existingItem : items){
                if(existingItem.getIdentifier().equals(inventoryItem.getIdentifier())){
                    existingItem.increaseQuantity(1);
                    updateTotals();
                    return;
                }
            }

            Item soldItem = new Item(inventoryItem.getIdentifier(), 
            inventoryItem.getDescription(),inventoryItem.getPrice(), inventoryItem.getVATRate());
            
            soldItem.increaseQuantity(0);
            items.add(soldItem);
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
        this.amountPaid = amountPaid;
        if (amountPaid >= getTotalPrice()) {
            double change = amountPaid - getTotalPrice();
            return "" + change;
        }
        return "Insufficient payment!";
    }

    // getter to display amount paid on receipt.
    public double getAmountPaid(){
        return amountPaid;
    }
    
}
