package com.example.POS_System.controller;

import com.example.POS_System.integration.AccountingSystem;
import com.example.POS_System.integration.InventorySystem;
import com.example.POS_System.model.Item;
import com.example.POS_System.model.Receipt;
import com.example.POS_System.model.Sale;

public class Controller {
    private Sale sale;
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;

    public Controller(InventorySystem inventorySystem, AccountingSystem accountingSystem) {
        this.inventorySystem = inventorySystem;
        this.accountingSystem = accountingSystem;
        this.sale = new Sale();
    }

    public void startNewSale() {
        this.sale = new Sale();
    }

    /* public void enterItem(String identifier) {
        Item item = inventorySystem.getItem(identifier);
        if (item != null) {
            sale.addItem(item);
            System.out.println("Item added: " + item.getDescription() + " - Running total: " + sale.getTotalPrice());
        } else {
            System.out.println("Invalid item identifier.");
        }
    } */

        // Fix enter item to match new logic from Sale.
        public Item enterItem(String identifier) {
            Item item = inventorySystem.getItem(identifier);
            if (item != null){
                sale.addItem(item);
            }
            return item;
        }

   /*  public void endSale() {
        double totalPrice = sale.getTotalPrice();
        System.out.println("Total price: " + totalPrice);
    } */

        // change endSale to follow MVC
        public double endSale(){
            return sale.getTotalPrice();
        } 

    public String pay(double amountPaid) {
        return sale.pay(amountPaid);
    }

    public String logSale() {
        return accountingSystem.getSaleLog(sale);
       // inventorySystem.updateInventory(sale);
    }

    public void updateInventory(){
        inventorySystem.updateInventory(sale);
    }

   /*  public void printReceipt() {
        Receipt receipt = new Receipt(sale);
        receipt.printReceipt();
    } */

     /*    public boolean updateInventory() {
            return inventorySystem.updateInventory(sale);
        } */

    /* public void printReceipt() {
        System.out.println("Printing receipt...");
        System.out.println("Receipt:");
        System.out.println("Date: " + sale.getDateTime());
        for (Item item : sale.getItems()) {
            System.out.println(item.getDescription() + " x" + item.getQuantity() + ": " + (item.getPrice() * item.getQuantity() * (1 + item.getVATRate())));
        }
        System.out.println("Total: " + sale.getTotalPrice());
    } */

   // Change printReceipt because it breaks the MVC
   public Receipt getReceipt() {
    return new Receipt(sale);
   }
    
}
