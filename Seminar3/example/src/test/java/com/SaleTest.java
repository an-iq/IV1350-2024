/* package com;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.example.POS_System.model.Item;
import com.example.POS_System.model.Sale;


public class SaleTest {
    private Sale sale;
    private Item item1;
    private Item item2;

    @Before
    public void setUp() {
        sale = new Sale();
        item1 = new Item("001", "Milk", 10, 0.12);
        item2 = new Item("002", "Bread", 20, 0.12);
    }

    @Test
    public void testAddNewItem() {
        sale.addItem(item1);
        assertEquals(1, sale.getItems().length);
        assertEquals(item1.getIdentifier(), sale.getItems()[0].getIdentifier());
    }

    @Test
    public void testAddExistingItem() {
        sale.addItem(item1);
       sale.addItem(item2);
        assertEquals(1, sale.getItems().length);
        assertEquals(2, sale.getItems()[0].getQuantity());
    }
} */

package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.POS_System.model.Item;
import com.example.POS_System.model.Sale;

public class SaleTest {
    private Sale sale;
    private Item item1;
    private Item item2;

    @BeforeEach
    public void setUp() {
        sale = new Sale();
        item1 = new Item("001", "Milk", 10, 0.12);
        item2 = new Item("002", "Bread", 20, 0.12);
    }

    @Test
    public void testAddNewItem() {
        sale.addItem(item1);
        assertEquals(1, sale.getItems().length);
        assertEquals("001", sale.getItems()[0].getIdentifier());
        assertEquals(1, sale.getItems()[0].getQuantity());
    }

    @Test
    public void testAddExistingItem() {
        sale.addItem(item1);
        sale.addItem(item1);  // Adding the same item again
        assertEquals(1, sale.getItems().length);  // Should still have only one item in the list
        assertEquals(2, sale.getItems()[0].getQuantity());  // The quantity of the existing item should be increased to 2
    }

    @Test
    public void testRemoveItem() {
    sale.addItem(item1);
    sale.addItem(item2);
    sale.removeItem(item1.getIdentifier());
    assertEquals(1, sale.getItems().length);
    assertEquals("002", sale.getItems()[0].getIdentifier());
    }

    public void testTotalPriceIncludesVAT(){
        sale.addItem(item1);
        sale.addItem(item2);

        double expectedTotal= 11.2 + 22.4;
        assertEquals(expectedTotal, sale.getTotalPrice(), 0.001);
    }

}
