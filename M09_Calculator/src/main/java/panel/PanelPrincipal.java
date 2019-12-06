package panel;

//<editor-fold defaultstate="collapsed" desc="import">
import button.Buttons;
import button.ButtonsFactory;
import button.JGradientButton;
import constantes.Constantes;
import callbacks.EscuchadorEventosTeclado;
import callbacks.EscuchadorEventosRaton;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
//</editor-fold>
public class PanelPrincipal extends JPanel {

//<editor-fold defaultstate="collapsed" desc="Field variables">
    // field attributes
    private JScrollPane jScrollPane1;
    public static JTextPane jTextPane;

    private static JGradientButton b[];
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="constructor">
    public PanelPrincipal() {
        initilizeVariable();
        initializeLayout();
      }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="initilizeVariable">
    private void initilizeVariable() {
        
        jScrollPane1 = new JScrollPane();
        jTextPane = new JTextPane();
        b = new JGradientButton[24];
    }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="initializeLayout"> 
    private void initializeLayout() {
        
    //<editor-fold defaultstate="collapsed" desc="inicializar jpanel">
        // panel
        setPreferredSize(new Dimension(Constantes.HEIGHT_WINDOW, Constantes.HEIGHT_WINDOW));
        setSize(getPreferredSize());
        setMaximumSize(getPreferredSize());
        setMinimumSize(getPreferredSize());
        setLayout(null);
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="inicializar jtexpanel">
        // jtextpanel
        jTextPane.setBorder(BorderFactory.createEtchedBorder());
        jTextPane.setFont(new Font("Consolas", 1, 24));

        jTextPane.setFocusable(false);

        jScrollPane1.setViewportView(jTextPane);
        jScrollPane1.setBounds(10, 10, 360, 220);

        add(jScrollPane1);
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="inicializar botones">
        // butons
        for (int i = 0; i < 20; i++) {
            b[i] = ButtonsFactory.createButton(Buttons.BUTTONSNAME.buttonName(i));
            // I add one keylistener and one ActionListener to each key
            b[i].addKeyListener(new EscuchadorEventosTeclado(b[1]));
            b[i].addActionListener(new EscuchadorEventosRaton(b[i]));
            add(b[i]);
        }
    //</editor-fold>
}// </editor-fold>             
// jTextPane1.setToolTipText("<html>\n<h1 style=\"color:blue;text-align:center;\">This is a heading</h1>");
}
