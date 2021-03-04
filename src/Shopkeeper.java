public class Shopkeeper extends Thread {
    private Buffer b;
    public int counter = 0;

    public Shopkeeper (Buffer b) {
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
            System.out.println("Shopkeeper processed " + b.get().toString());
            counter++;
        }
    }
}