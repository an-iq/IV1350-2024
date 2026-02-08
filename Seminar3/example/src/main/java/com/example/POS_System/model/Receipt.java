package com.example.POS_System.model;

import java.time.LocalDateTime;

public class Receipt {
    private Sale sale;
   // private LocalDateTime dateTime;

    public Receipt(Sale sale) {
        this.sale = sale;
        //this.dateTime = LocalDateTime.now();
    }

    /* public void printReceipt() {
        System.out.println("Receipt:");
        System.out.println("Date: " + " " + sale.getDateTime());
        for (Item item : sale.getItems()) {
            System.out.println(item.getDescription() + " x" + item.getQuantity() + ": " + item.getPrice() * item.getQuantity());
        }
        System.out.println("Total: " + sale.getTotalPrice());
    } */
   public void printReceipt(){
    System.out.println("---------------------");
    System.out.println("Receipt: ");
    System.out.println("Date: " + sale.getDateTime());

    for(Item item : sale.getItems()) {
        double priceWithVAT = item.getPrice() * item.getQuantity() * (1 + item.getVATRate());

       /*  System.out.println(
            item.getDescription() + " x" + item.getQuantity() + ": " + priceWithVAT
        ); */
        System.out.printf(
    "%s x%d: %.2f%n",
    item.getDescription(),
    item.getQuantity(),
    priceWithVAT
    );

    }
    //System.out.println("Total: " + sale.getTotalPrice());
    System.out.printf("Total: %.2f%n", sale.getTotalPrice());
    System.out.printf("Paid: %.2f%n", sale.getAmountPaid());
    System.out.printf("Change: %.2f%n", sale.getAmountPaid()- sale.getTotalPrice());


    System.out.println("---------------------");

   }
}
