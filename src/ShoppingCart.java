import java.util.*;

class ShoppingCart {

    private HashMap<String, Item> productMap = new HashMap<>();
    private HashMap<String, Integer> itemsInCart = new HashMap<>();

    ShoppingCart() {
        productMap.put("01001", new Item("01001", "Banana", 0.99));
        productMap.put("01002", new Item("01002", "Apple", 1.30));
        productMap.put("01003", new Item("01003", "Carrot", 1.66));
    }

    void addItemToList(String barcode) {

        if (itemsInCart.containsKey(barcode)) {
            itemsInCart.replace(barcode, itemsInCart.get(barcode) + 1);
        } else {
            itemsInCart.put(barcode, 1);
        }
    }

    int getItemCount(String barcode){
        if(itemsInCart.containsKey(barcode)){
            return itemsInCart.get(barcode);
        }
        return 0;
    }

    // it will remove only one item, example if there are 3 banana then it will
    // remove 1 and now there are only 2 banana now.
    void removeItemFromList(String barcode) {
        if (itemsInCart.get(barcode) > 1) {
            itemsInCart.replace(barcode, itemsInCart.get(barcode) - 1);
        } else {
            if (itemsInCart.get(barcode) == 1) {
                itemsInCart.remove(barcode);
            }
        }
    }

    // it will delete item from list like if there are 2 banana then it will delete
    // all 3 banana from it.
    void deleteItemFromList(String barcode) {
        if (itemsInCart.containsKey(barcode)) {
            itemsInCart.remove(barcode);
        }
    }

    double getTotalBill() {
        double totalBill = 0;
        for (Map.Entry<String, Integer> eachItem : itemsInCart.entrySet()) {
            totalBill += (productMap.get(eachItem.getKey()).getPrice() * eachItem.getValue());
        }
        return totalBill;
    }

    void printCart() {
        itemsInCart.forEach((key, value) -> {
            System.out.println(value + " x " + productMap.get(key).getItemName() + " @ " + productMap.get(key).getPrice() + " = "
                    + (value * productMap.get(key).getPrice()));
        });
        System.out.println("Total = " + getTotalBill());
        System.out.println("\nBarcode\t Description\t Price\t");
        System.out.println("--------------------------------");
        for (int i = 0; i < itemsInCart.size(); i++) {

        }
        productMap.forEach((key, value) -> {
            System.out.println(key + "\t" + value.getItemName() + "\t\t" + value.getPrice());
        });
    }

    public static void main(String args[]) {

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItemToList("01001");
        shoppingCart.addItemToList("01001");
        shoppingCart.addItemToList("01002");
        shoppingCart.addItemToList("01003");
        shoppingCart.addItemToList("01003");
        shoppingCart.addItemToList("01003");

        shoppingCart.printCart();
    }
}