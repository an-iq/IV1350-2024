/* package com.example.POS_System.view;

import com.example.POS_System.controller.Controller;

public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void executeSale() {
        controller.startNewSale();
        controller.enterItem("001");
        controller.enterItem("002");
        controller.enterItem("002");  // Alternative flow 3-4b
        controller.endSale();
        controller.logSale();
        controller.printReceipt();
    }
}
 */

package com.example.POS_System.view;

import com.example.POS_System.controller.Controller;
import com.example.POS_System.integration.AccountingSystem;
import com.example.POS_System.integration.InventorySystem;
import com.example.POS_System.model.Item;
import com.example.POS_System.model.Receipt;
import com.example.POS_System.model.Sale;

public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void sampleRun() {
        // Starting a new sale
        System.out.println("Starting a new sale...");
        controller.startNewSale();

        // Adding items to the sale
        addItemToSale("001");
        addItemToSale("002");
        addItemToSale("002");  // Simulate alternative flow 3-4b

        // Ending the sale
        //controller.endSale();
        double totalPrice = controller.endSale();
        System.out.println("Total price: " + totalPrice);

        
        // Amount paid 
        String change = controller.pay(100.0);
        System.out.println("Payment registered");
        System.out.println("Change: " + change);

        //update inventory here.
        controller.updateInventory();
        //Log sale After inventory update.
        System.out.println("Logging sale...");
        controller.logSale();
        System.out.println("Sale logged successfully.");
        // Printing the receipt
        //controller.printReceipt();
        Receipt receipt = controller.getReceipt();
        receipt.printReceipt();

    }

    private void addItemToSale(String itemId) {
        //controller.enterItem(itemId);
        Item item = controller.enterItem(itemId);
        if(item != null ){
            System.out.println("Item added: " + item.getDescription());
        }else {
            System.out.println("Invalid item identifier.");
        }

    }

    public static void main(String[] args) {
        InventorySystem inventorySystem = new InventorySystem();
        AccountingSystem accountingSystem = new AccountingSystem();
        Controller controller = new Controller(inventorySystem, accountingSystem);
        View view = new View(controller);

        view.sampleRun();
    }

    public void executeSale() {
        controller.startNewSale();
        controller.enterItem("001");
        controller.enterItem("002");
        controller.enterItem("002");  // Alternative flow 3-4b
        controller.endSale();
        controller.logSale();
        controller.getReceipt();
    } 
    
}
