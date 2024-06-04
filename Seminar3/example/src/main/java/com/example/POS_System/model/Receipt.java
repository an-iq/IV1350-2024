package com.example.POS_System.model;

import java.time.LocalDateTime;

public class Receipt {
    private Sale sale;
    private LocalDateTime dateTime;

    public Receipt(Sale sale) {
        this.sale = sale;
        this.dateTime = LocalDateTime.now();
    }

    public void printReceipt() {
        System.out.println("Receipt:");
        System.out.println("Date: " + dateTime);
        for (Item item : sale.getItems()) {
            System.out.println(item.getDescription() + " x" + item.getQuantity() + ": " + item.getPrice() * item.getQuantity());
        }
        System.out.println("Total: " + sale.getTotalPrice());
    }
}
