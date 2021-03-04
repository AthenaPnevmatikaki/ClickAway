public class Buffer {
    private Order order;

    public Buffer() {
        order = new Order("Dummy");
    }

    public void put (Order order) {
        this.order = order;
    }
    public Order get() {
        return order;
    }
}
