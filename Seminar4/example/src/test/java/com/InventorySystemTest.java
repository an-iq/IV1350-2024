package com;

import com.example.POS_System.exceptions.DatabaseFailureException;
import com.example.POS_System.exceptions.ItemNotFoundException;
import com.example.POS_System.integration.InventorySystem;
import com.example.POS_System.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventorySystemTest {
    private InventorySystem inventorySystem;
    private Item item1;
    private Item item2;

    @BeforeEach
    public void setUp() {
        inventorySystem = new InventorySystem();
        item1 = new Item("003", "Butter", 30, 0.12);
        item2 = new Item("004", "Cheese", 50, 0.12);
    }

    @Test
    public void testInitialInventoryState() throws ItemNotFoundException {
        assertEquals(2, inventorySystem.getItemCount());
        assertNotNull(inventorySystem.getItem("001"));
        assertNotNull(inventorySystem.getItem("002"));
    }

    @Test
    public void testAddItem() throws ItemNotFoundException {
        inventorySystem.addItem(item1);
        assertEquals(3, inventorySystem.getItemCount());
        assertNotNull(inventorySystem.getItem(item1.getIdentifier()));
    }

    @Test
    public void testRemoveItem() throws ItemNotFoundException {
        inventorySystem.addItem(item1);
        inventorySystem.removeItem(item1.getIdentifier());
        assertEquals(2, inventorySystem.getItemCount());
        assertNull(inventorySystem.getItem(item1.getIdentifier()));
    }

    @Test
    public void testGetItem() throws ItemNotFoundException {
        Item fetchedItem = inventorySystem.getItem("001");
        assertNotNull(fetchedItem);
        assertEquals("Milk", fetchedItem.getDescription());
    }

    @Test
    public void testGetNonExistentItem() throws ItemNotFoundException {
        Item fetchedItem = inventorySystem.getItem("999");
        assertNull(fetchedItem);
    }

    @Test
    public void testUpdateItem() throws ItemNotFoundException {
        Item updatedItem = new Item("001", "Milk", 12, 0.12);
        inventorySystem.updateItem(updatedItem);
        Item fetchedItem = inventorySystem.getItem("001");
        assertEquals(12, fetchedItem.getPrice());
    }

    @Test
    public void testGetItem_ItemNotFound() {
        Exception exception = assertThrows(ItemNotFoundException.class, () -> {
            inventorySystem.getItem("003");
        });

        assertEquals("Item with identifier 003 not found.", exception.getMessage());
    }

    @Test
    public void testGetItem_DatabaseFailure() {
        Exception exception = assertThrows(DatabaseFailureException.class, () -> {
            inventorySystem.getItem("999");
        });

        assertEquals("Database connection failure for item identifier: 999", exception.getMessage());
    }
    
}
