package bd301;

import javax.swing.SwingUtilities;

public class Bd301 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BienvenidaFrame bienvenida = new BienvenidaFrame();
            bienvenida.setVisible(true);
            
        });
    }
}

