package com;

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
    public void testInitialInventoryState() {
        assertEquals(2, inventorySystem.getItemCount());
        assertNotNull(inventorySystem.getItem("001"));
        assertNotNull(inventorySystem.getItem("002"));
    }

    @Test
    public void testAddItem() {
        inventorySystem.addItem(item1);
        assertEquals(3, inventorySystem.getItemCount());
        assertNotNull(inventorySystem.getItem(item1.getIdentifier()));
    }

    @Test
    public void testRemoveItem() {
        inventorySystem.addItem(item1);
        inventorySystem.removeItem(item1.getIdentifier());
        assertEquals(2, inventorySystem.getItemCount());
        assertNull(inventorySystem.getItem(item1.getIdentifier()));
    }

    @Test
    public void testGetItem() {
        Item fetchedItem = inventorySystem.getItem("001");
        assertNotNull(fetchedItem);
        assertEquals("Milk", fetchedItem.getDescription());
    }

    @Test
    public void testGetNonExistentItem() {
        Item fetchedItem = inventorySystem.getItem("999");
        assertNull(fetchedItem);
    }

    @Test
    public void testUpdateItem() {
        Item updatedItem = new Item("001", "Milk", 12, 0.12);
        inventorySystem.updateItem(updatedItem);
        Item fetchedItem = inventorySystem.getItem("001");
        assertEquals(12, fetchedItem.getPrice());
    }
}
