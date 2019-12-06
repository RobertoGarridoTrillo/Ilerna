package callbacks;

import button.JGradientButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ToolTipManager;
import teclas.RecogeClicks;

public class EscuchadorEventosRaton implements ActionListener{
    
    // Field attributes
    private final JGradientButton button;
    private final RecogeClicks recogeClicks;

    public EscuchadorEventosRaton(JGradientButton button) {
        this.button = button;
        recogeClicks = new RecogeClicks();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        recogeClicks.actionPerformed(e);
    }
    
}
