public final class Item {

    private String barcode;
    private String itemName;
    private double price;

    Item(String barcode, String itemName, double price) {
        this.barcode = barcode;
        this.itemName = itemName;
        this.price = price;
    }

    // getter methods

    String getBarcode() {
        return this.barcode;
    }

    String getItemName() {
        return this.itemName;
    }

    double getPrice() {
        return this.price;
    }

}
