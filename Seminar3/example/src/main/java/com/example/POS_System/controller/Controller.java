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

    public void enterItem(String identifier) {
        Item item = inventorySystem.getItem(identifier);
        if (item != null) {
            sale.addItem(item);
            System.out.println("Item added: " + item.getDescription() + " - Running total: " + sale.getTotalPrice());
        } else {
            System.out.println("Invalid item identifier.");
        }
    }

    public void endSale() {
        double totalPrice = sale.getTotalPrice();
        System.out.println("Total price: " + totalPrice);
    }

    public void logSale() {
        accountingSystem.logSale(sale);
        inventorySystem.updateInventory(sale);
    }

   /*  public void printReceipt() {
        Receipt receipt = new Receipt(sale);
        receipt.printReceipt();
    } */

    public void printReceipt() {
        System.out.println("Printing receipt...");
        System.out.println("Receipt:");
        System.out.println("Date: " + sale.getDateTime());
        for (Item item : sale.getItems()) {
            System.out.println(item.getDescription() + " x" + item.getQuantity() + ": " + (item.getPrice() * item.getQuantity() * (1 + item.getVATRate())));
        }
        System.out.println("Total: " + sale.getTotalPrice());
    }
    
}
