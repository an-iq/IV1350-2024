package com.example.POS_System.integration;
import java.util.HashMap;
import java.util.Map;

import com.example.POS_System.model.Item;
import com.example.POS_System.model.Sale;

public class InventorySystem {
    private Map<String, Item> items;

    public InventorySystem() {
        items = new HashMap<>();
        items.put("001", new Item("001", "Milk", 10, 0.12));
        items.put("002", new Item("002", "Bread", 20, 0.12));
    }

    public Item getItem(String identifier) {
        return items.get(identifier);
    }

    // Simulate updating inventory
    /* public void updateInventory(Sale sale) {
        for (Item soldItem : sale.getItems()) {
            Item inventoryItem = items.get(soldItem.getIdentifier());
            if (inventoryItem != null) {
                int newQuantity = inventoryItem.getQuantity() - soldItem.getQuantity();
                if (newQuantity >= 0) {
                    inventoryItem.setQuantity(newQuantity);
                } else {
                    System.out.println("Warning: Inventory for item " + soldItem.getDescription() + " is less than sold quantity.");
                    inventoryItem.setQuantity(0);
                }
            } else {
                System.out.println("Warning: Sold item " + soldItem.getDescription() + " not found in inventory.");
            }
        }
    } */

// New function for simulating updating inventory after removing system.out.println. Instead of printing warning, the function returns information.
        public boolean updateInventory(Sale sale){
            boolean allItemsFound = true;
            for (Item soldItem : sale.getItems()){
                Item inventoryItem = items.get(soldItem.getIdentifier());

                if(inventoryItem == null){
                    allItemsFound = false;
                    continue;
                }
                int newQuantity = inventoryItem.getQuantity() - soldItem.getQuantity();
                inventoryItem.setQuantity(Math.max(newQuantity, 0));
            }
            return allItemsFound;
        }
    

    public void addItem(Item item) {
        items.put(item.getIdentifier(), item);
    }

    public void removeItem(String identifier) {
        items.remove(identifier);
    }

    public int getItemCount() {
        return items.size();
    }

    public void updateItem(Item item) {
        items.put(item.getIdentifier(), item);
    }
}

