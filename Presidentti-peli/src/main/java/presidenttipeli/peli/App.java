package presidenttipeli.peli;

import javax.swing.SwingUtilities;
import presidenttipeli.gui.*;

public class App {

    public static void main(String[] args) {
        AloitusGUI gui = new AloitusGUI();
        SwingUtilities.invokeLater(gui);
        gui.setVisible(true);
    }

}
