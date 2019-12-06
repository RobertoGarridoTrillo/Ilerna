package panel;

import constantes.Constantes;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class FrameInicio extends JFrame {

    public FrameInicio() {
        initializaLayout();
    }

    private void initializaLayout() {
        
        // we started the JFrame        
        setPreferredSize(new Dimension(394, 688));
        setMaximumSize(getPreferredSize());
        setMinimumSize(getPreferredSize());
        setSize(getPreferredSize());
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(Constantes.TITLE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(Constantes.ICONO_URL)));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        
        // we added the jpanel
        add(new PanelPrincipal());
        pack();
        
        setVisible(true);
    }
}
