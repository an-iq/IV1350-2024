package com.example.POS_System.integration;

import com.example.POS_System.model.Item;
import com.example.POS_System.model.Sale;

public class AccountingSystem {

    /* public void logSale(Sale sale) {
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
    } */

        public String getSaleLog(Sale sale){
            StringBuilder log = new StringBuilder();
            log.append("Date: ").append(sale.getDateTime()).append("\\n");

            for(Item item : sale.getItems()) {
                log.append(item.getDescription()).append(" x").append(item.getQuantity()).append("\n");
            }

            log.append("Total: ").append(sale.getTotalPrice());
            return log.toString();
        }


}
