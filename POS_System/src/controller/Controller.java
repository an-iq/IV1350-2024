package POS_System.src.controller;

import POS_System.src.integration.AccountingSystem;
import POS_System.src.integration.InventorySystem;
import POS_System.src.model.Item;
import POS_System.src.model.Receipt;
import POS_System.src.model.Sale;

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

    public void printReceipt() {
        Receipt receipt = new Receipt(sale);
        receipt.printReceipt();
    }
}
