import java.awt.*;
import java.awt.event.*;

public class Main {

    public static void main (String[] args) {
        Gui gui = new Gui();
    }
}


class Gui extends Frame{
    public Button buttonCustomer;
    public Button buttonShopkeeper;
    public Button buttonClickAway;
    public Buffer b = new Buffer();
    public Customer c;
    public Shopkeeper s;

    public Gui() {
        super ("Producer Consumer");

        this.setLocation(50,100);
        this.setSize(new Dimension (300, 300));
        this.setFont(new Font ("TimesRoman", Font.PLAIN, 12));
        this.setBackground(Color.lightGray);
        this.setVisible(true);
        this.setResizable(false);
        this.toFront();
        this.setLayout(null);
        this.addWindowListener(new CloseWindowAndExit());

        buttonCustomer = new Button("Create Costumer");
        buttonCustomer.setFont(new Font ("TimesRoman", Font.PLAIN, 14));
        buttonCustomer.setBounds(new Rectangle (20, 50, 120, 27));
        buttonCustomer.setBackground(Color.WHITE);
        buttonCustomer.setForeground(Color.black);
        this.add(buttonCustomer);
        buttonCustomer.addActionListener(new ButtonCostumerHandler(this));

        buttonShopkeeper = new Button("Create Shopkeeper");
        buttonShopkeeper.setFont(new Font ("TimesRoman", Font.PLAIN, 14));
        buttonShopkeeper.setBounds(new Rectangle (20, 100, 120, 27));
        buttonShopkeeper.setBackground(Color.WHITE);
        buttonShopkeeper.setForeground(Color.black);
        this.add(buttonShopkeeper);
        buttonShopkeeper.addActionListener(new ButtonShopKeeperHandler(this));

        buttonClickAway = new Button("Start Click Away");
        buttonClickAway.setFont(new Font ("TimesRoman", Font.PLAIN, 14));
        buttonClickAway.setBounds(new Rectangle (20, 150, 120, 27));
        buttonClickAway.setBackground(Color.WHITE);
        buttonClickAway.setForeground(Color.black);
        this.add(buttonClickAway);
        buttonClickAway.addActionListener(new ButtonClickAwayHandler(this));

    }
}


class CloseWindowAndExit extends WindowAdapter {
    public void windowClosing (WindowEvent closeWindowAndExit) {
        System.exit(0);
    }
}


class Order {
    private static int id = 0;
    private String productCode;

    public Order(String productCode) {
        this.productCode = productCode;
        id ++;
    }

    public String toString() {
        return "Order " + id + " contains product " + productCode;
    }
}


class Buffer {
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


class ButtonCostumerHandler implements ActionListener{
    public Gui gui;

    public ButtonCostumerHandler(Gui gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent pushingButton0) {
        System.out.println("button costumer pressed");
        gui.c = new Customer(gui.b);
    }
}


class ButtonShopKeeperHandler implements ActionListener{
    public Gui gui;

    public ButtonShopKeeperHandler(Gui gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent pushingButton0) {
        System.out.println("button shopkeeper pressed");
        gui.s = new Shopkeeper(gui.b);
    }
}


class ButtonClickAwayHandler implements ActionListener{
    public Gui gui;

    public ButtonClickAwayHandler(Gui gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent pushingButton0) {
        System.out.println("button click away pressed");
        gui.c.start();
        gui.s.start();
        while (gui.c.isAlive() || gui.s.isAlive()) {}
        System.out.println("Lost orders: " + (gui.s.counter - gui.c.counter));
    }
}


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


class Shopkeeper extends Thread {
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