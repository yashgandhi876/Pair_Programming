import java.util.*;

class ShoppingCart {

    HashMap<String, Item> map = new HashMap<>();
    ArrayList<Item> cart = new ArrayList<>();
    HashMap<String, Integer> numberOfItem = new HashMap<>();
    double totalBill = 0;

    ShoppingCart() {
        map.put("01001", new Item("01001", "Banana", 0.99));
        map.put("01002", new Item("01002", "Apple", 1.30));
        map.put("01003", new Item("01003", "Carrot", 1.66));
    }

    void addItemToLIst(String barcode) {

        if (numberOfItem.containsKey(barcode)) {
            numberOfItem.replace(barcode, numberOfItem.get(barcode) + 1);
        } else {
            numberOfItem.put(barcode, 1);
            Item item = map.get(barcode);
            cart.add(item);
        }
        totalBill += map.get(barcode).price;
    }

    // it will remove only one item, example if there are 3 banana then it will
    // remove 1 and now there are only 2 banana now.
    void removeItemFromList(String barcode) {
        if (numberOfItem.get(barcode) > 1) {
            numberOfItem.replace(barcode, numberOfItem.get(barcode) - 1);
        } else {
            if (numberOfItem.get(barcode) == 1) {
                numberOfItem.remove(barcode);
                for (int i = 0; i < cart.size(); i++) {
                    if (cart.get(i).barcode == barcode) {
                        cart.remove(i);
                        break;
                    }
                }
            }
        }
        totalBill -= map.get(barcode).price;
    }

    // it will delete item from list like if there are 2 banana then it will delete
    // all 3 banana from it.
    void deleteItemFromList(String barcode) {
        if (numberOfItem.containsKey(barcode)) {
            totalBill -= (numberOfItem.get(barcode) * map.get(barcode).price);
            numberOfItem.remove(barcode);
            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).barcode == barcode) {
                    cart.remove(i);
                    break;
                }
            }
        }
    }

    void printCart(){
        numberOfItem.forEach((key, value) -> {
            System.out.println(value + " x " + map.get(key).itemName + " @ "
                    + map.get(key).price + " = " + (value * map.get(key).price));
        });
        System.out.println("Total = " + totalBill);
        System.out.println("\n");
        System.out.println("Barcode\t Description\t Price\t");
        System.out.println("--------------------------------");
        for (int i = 0; i < numberOfItem.size(); i++) {

            Item tempItem = cart.get(i);
            System.out.println(tempItem.barcode + "\t" + tempItem.itemName + "\t\t" + tempItem.price);
        }
    }

    public static void main(String args[]) {

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItemToLIst("01001");
        shoppingCart.addItemToLIst("01001");
        shoppingCart.addItemToLIst("01002");
        shoppingCart.addItemToLIst("01003");
        shoppingCart.addItemToLIst("01003");
        shoppingCart.addItemToLIst("01003");

        shoppingCart.printCart();

    }
}