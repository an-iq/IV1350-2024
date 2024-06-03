package POS_System;
import POS_System.src.controller.Controller;
import POS_System.src.integration.AccountingSystem;
import POS_System.src.integration.InventorySystem;
import POS_System.src.view.View;

public class Main {
    public static void main(String[] args) {
        InventorySystem inventorySystem = new InventorySystem();
        AccountingSystem accountingSystem = new AccountingSystem();
        Controller controller = new Controller(inventorySystem, accountingSystem);
        View view = new View(controller);

        view.executeSale();
    }
}
