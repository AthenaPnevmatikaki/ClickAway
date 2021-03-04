import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickAwayHandler implements ActionListener {
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