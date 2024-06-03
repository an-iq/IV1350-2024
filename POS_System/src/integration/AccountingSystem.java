package POS_System.src.integration;

import POS_System.src.model.Item;
import POS_System.src.model.Sale;

public class AccountingSystem {
    public void logSale(Sale sale) {
        System.out.println("Logging sale...");
        System.out.println("Date: " + sale.getDateTime());
        for (Item item : sale.getItems()) {
            System.out.println("Item: " + item.getDescription() +
                               ", Quantity: " + item.getQuantity() +
                               ", Price: " + item.getPrice() +
                               ", VAT: " + item.getVATRate());
        }
        System.out.println("Total Price: " + sale.getTotalPrice());
        System.out.println("Sale logged successfully.");
    }
}


