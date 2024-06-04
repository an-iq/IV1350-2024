/* package com.example.POS_System.model;

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
    
} */

  
package com.example.POS_System.model;

import com.example.POS_System.observer.SaleObserver;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


public class Sale {
    private List<Item> items;
    private double totalPrice;
    private double totalVAT;
    private List<SaleObserver> observers;
    private LocalDateTime dateTime;


    public Sale() {
        this.items = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.totalPrice = 0;
        this.totalVAT = 0;
        this.dateTime = LocalDateTime.now();

    }

    public void addObserver(SaleObserver observer) {
        observers.add(observer);
        System.out.println("Debug: Observer added: " + observer.getClass().getSimpleName()); // Debug message
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
        notifyObservers();
    }

    private void notifyObservers() {
        System.out.println("Debug: Notifying observers with total price: " + getTotalPrice()); // Debug message
        for (SaleObserver observer : observers) {
            System.out.println("Debug: Notifying " + observer.getClass().getSimpleName()); // Additional debug message
            observer.update(getTotalPrice());
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
    
}
