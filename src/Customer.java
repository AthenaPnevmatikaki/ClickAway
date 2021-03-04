class Customer extends Thread {
    private Buffer b;
    public int counter = 0;

    public Customer (Buffer b) {
        this.b = b;
    }

    public void run() {
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(1L);
            }
            catch (InterruptedException e) {
                System.err.println("Exception: " + e.toString());
            }
            Order order = new Order("SC1072747");
            b.put(order);
            System.out.println("Customer placed order " + order.toString());
            counter++;
        }
    }
}
