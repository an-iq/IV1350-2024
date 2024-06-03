package POS_System.src.integration;
import POS_System.src.model.Item;
import POS_System.src.model.Sale;
import java.util.HashMap;
import java.util.Map;

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
    public void updateInventory(Sale sale) {
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
    }
}


