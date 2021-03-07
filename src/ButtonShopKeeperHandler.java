import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonShopKeeperHandler implements ActionListener {
    public Gui gui;

    public ButtonShopKeeperHandler(Gui gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent pushingButton0) {
        System.out.println("button shopkeeper pressed");
        gui.s = new Shopkeeper(gui.b);
        gui.buttonClickAway.setEnabled(true);
    }
}
