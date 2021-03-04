public class Order {
    private static int id = 0;
    private final String productCode;

    public Order(String productCode) {
        this.productCode = productCode;
        id ++;
    }

    public String toString() {
        return "Order " + id + " contains product " + productCode;
    }
}