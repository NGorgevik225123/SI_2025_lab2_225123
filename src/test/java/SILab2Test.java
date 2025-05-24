import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    private Item createItem(String name, int quantity, int price, double discount) {
        return new Item(name, quantity, price, discount);
    }

    @Test
    public void testEveryStatement() {
        Exception ex1 = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(null, "1234567890123456");
        });
        assertEquals("allItems list can't be null!", ex1.getMessage());

        List<Item> list2 = new ArrayList<>();
        list2.add(createItem(null, 1, 100, 0));
        Exception ex2 = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(list2, "1234567890123456");
        });
        assertEquals("Invalid item!", ex2.getMessage());

        List<Item> list3 = new ArrayList<>();
        list3.add(createItem("", 1, 100, 0));
        Exception ex3 = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(list3, "1234567890123456");
        });
        assertEquals("Invalid item!", ex3.getMessage());

        List<Item> list4 = new ArrayList<>();
        list4.add(createItem("Item1", 5, 350, 0));
        double result4 = SILab2.checkCart(list4, "1234567890123456");
        assertTrue(result4 < 0);

        List<Item> list5 = new ArrayList<>();
        list5.add(createItem("Item2", 5, 200, 0.1));
        double result5 = SILab2.checkCart(list5, "1234567890123456");
        assertTrue(result5 > 0);

        List<Item> list6 = new ArrayList<>();
        list6.add(createItem("Item3", 15, 200, 0));
        double result6 = SILab2.checkCart(list6, "1234567890123456");
        assertTrue(result6 < 0);

        List<Item> list7 = new ArrayList<>();
        list7.add(createItem("Item4", 1, 100, 0));
        Exception ex4 = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(list7, null);
        });
        assertEquals("Invalid card number!", ex4.getMessage());

        Exception ex5 = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(list7, "123");
        });
        assertEquals("Invalid card number!", ex5.getMessage());

        Exception ex6 = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(list7, "12345678901234AB");
        });
        assertEquals("Invalid character in card number!", ex6.getMessage());

        List<Item> list8 = new ArrayList<>();
        list8.add(createItem("Item5", 2, 100, 0));
        double result8 = SILab2.checkCart(list8, "1234567890123456");
        assertEquals(200, result8);

        List<Item> list9 = new ArrayList<>();
        list9.add(createItem("Item6", 2, 100, 0.2));
        double result9 = SILab2.checkCart(list9, "1234567890123456");
        assertEquals(160, result9, 0.01);
    }

    @Test
    public void testMultipleCondition() {
        List<Item> list1 = new ArrayList<>();
        list1.add(createItem("A", 5, 100, 0));
        double res1 = SILab2.checkCart(list1, "1234567890123456");
        assertEquals(500, res1);

        List<Item> list2 = new ArrayList<>();
        list2.add(createItem("B", 5, 350, 0));
        double res2 = SILab2.checkCart(list2, "1234567890123456");
        assertTrue(res2 < 0);

        List<Item> list3 = new ArrayList<>();
        list3.add(createItem("C", 5, 100, 0.1));
        double res3 = SILab2.checkCart(list3, "1234567890123456");
        assertTrue(res3 > 0);

        List<Item> list4 = new ArrayList<>();
        list4.add(createItem("D", 15, 100, 0));
        double res4 = SILab2.checkCart(list4, "1234567890123456");
        assertTrue(res4 < 0);

        List<Item> list5 = new ArrayList<>();
        list5.add(createItem("E", 5, 350, 0.1));
        double res5 = SILab2.checkCart(list5, "1234567890123456");
        assertTrue(res5 < 0);

        List<Item> list6 = new ArrayList<>();
        list6.add(createItem("F", 15, 350, 0));
        double res6 = SILab2.checkCart(list6, "1234567890123456");
        assertTrue(res6 < 0);

        List<Item> list7 = new ArrayList<>();
        list7.add(createItem("G", 15, 100, 0.1));
        double res7 = SILab2.checkCart(list7, "1234567890123456");
        assertTrue(res7 < 0);

        List<Item> list8 = new ArrayList<>();
        list8.add(createItem("H", 15, 350, 0.1));
        double res8 = SILab2.checkCart(list8, "1234567890123456");
        assertTrue(res8 < 0);
    }
}