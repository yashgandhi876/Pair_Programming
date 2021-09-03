import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShoppingCartTest {

    @Test
    public void testAddItemToList() {
        ShoppingCart shoppingCart = new ShoppingCart();
        String barcode = "01001";
        shoppingCart.addItemToList(barcode);
        int expectedOutput = 1;

        assertEquals(expectedOutput, shoppingCart.getItemCount(barcode));

        shoppingCart.addItemToList(barcode);
        expectedOutput = 2;

        assertEquals(expectedOutput, shoppingCart.getItemCount(barcode));
    }

    @Test
    public void testRemoveItemFromList(){
        ShoppingCart shoppingCart = new ShoppingCart();
        String barcode = "01001";
        shoppingCart.addItemToList(barcode);
        shoppingCart.addItemToList(barcode);
        shoppingCart.addItemToList(barcode);
        shoppingCart.removeItemFromList(barcode);
        int expectedOutput = 2;
        assertEquals(expectedOutput, shoppingCart.getItemCount(barcode));
    }


    @Test
    public void testDeleteItemFromList() {
        ShoppingCart shoppingCart = new ShoppingCart();
        String barcode = "01001";
        shoppingCart.addItemToList(barcode);
        shoppingCart.addItemToList(barcode);
        shoppingCart.addItemToList(barcode);
        shoppingCart.deleteItemFromList(barcode);
        int expectedOutput = 0;
        assertEquals(expectedOutput, shoppingCart.getItemCount(barcode));
    }

    @Test
    public void testTotalBill() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItemToList("01001");
        shoppingCart.addItemToList("01001");
        shoppingCart.addItemToList("01002");
        shoppingCart.addItemToList("01003");
        shoppingCart.addItemToList("01003");
        shoppingCart.addItemToList("01003");

        double expectedOutput = 8.26;
        assertEquals(expectedOutput, shoppingCart.getTotalBill(), 0.0);
    }

}
