package callbacks;

import button.JGradientButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import teclas.RecogeTeclas;

public class EscuchadorEventosTeclado extends KeyAdapter {

    // Field attributes
    private final JGradientButton button;
    private final RecogeTeclas recogeTeclas;

    // constructor
    public EscuchadorEventosTeclado(JGradientButton button) {
        this.button = button;
        recogeTeclas = new RecogeTeclas();
    }

     @Override
    public void keyPressed(KeyEvent e) {
        recogeTeclas.keyPressed(e);
    }

}
