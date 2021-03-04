import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Gui extends Frame {
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