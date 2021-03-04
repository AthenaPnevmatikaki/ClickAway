import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCostumerHandler implements ActionListener {
    public Gui gui;

    public ButtonCostumerHandler(Gui gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent pushingButton0) {
        System.out.println("button costumer pressed");
        gui.c = new Customer(gui.b);
    }
}
