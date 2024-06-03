import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import POS_System.src.model.Item;
import POS_System.src.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(item1.getIdentifier(), sale.getItems()[0].getIdentifier());
    }

    @Test
    public void testAddExistingItem() {
        sale.addItem(item1);
        sale.addItem(item1);
        assertEquals(1, sale.getItems().length);
        assertEquals(2, sale.getItems()[0].getQuantity());
    }
}