public class Order {
    private static int idCounter = 0;
    public int id;
    private final String productCode;

    public Order(String productCode) {
        this.productCode = productCode;
        id = idCounter;
        idCounter ++;
    }

    public String toString() {
        return "Order " + id + " contains product " + productCode;
    }
}