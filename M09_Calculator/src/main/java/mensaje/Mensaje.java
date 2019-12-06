package mensaje;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import static panel.PanelPrincipal.jTextPane;

public class Mensaje {

    // escribe un mensaje haciendo scroll en el jTextArea
    public static void mensaje(JTextPane panel, String texto, Color c, int tipo) {

        // aplica una mascara para que no haga scroll
        DefaultCaret caret = (DefaultCaret) jTextPane.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        // seleccionamos texto plano, no rtf ni html
        panel.setContentType("text/plain");

        // Creamos el objeto atributo para cambiar los atributos del texto
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setForeground(attrs, c);

        //
        int lonjitud = panel.getStyledDocument().getLength();
        try {

            switch (tipo) {
                case -1: {
                    // write normally 
                    panel.getStyledDocument().insertString(lonjitud, texto, attrs);
                    break;
                }
                case -2: {
                    // write deleting a character
                    if (lonjitud > 1) {
                        String textos = panel.getText().substring(0, lonjitud - 1);
                        panel.setText(textos);
                    } else {
                        panel.setText("");
                    }
                    break;
                }
                case -3: {
                    // complety eraser
                    panel.setText("");
                    break;
                }
                case -4: {
                    // write in an add, minus, multiply or dividy character
                    texto = "\n" + texto + "\n";
                    panel.getStyledDocument().insertString(lonjitud, texto, attrs);
                    break;
                }
                case -5: {
                    // write in an add, minus, multiply or dividy character
                    texto = texto + "\n";
                    panel.getStyledDocument().insertString(lonjitud, texto, attrs);
                    break;
                }
                case -6: {
                    // write deleting a character
                    String textos = panel.getText().substring(0, lonjitud + 1);
                    panel.setText(textos);
                    break;
                }
                default: {
                    // write deleting a line
                    String textos = panel.getText().substring(0, lonjitud - tipo);
                    panel.setText(textos);
                    break;
                }
            }

        } catch (BadLocationException e) {
            errorDato(panel, "La calculadora tiene problemas con la pantalla de mensajes");
        }

    }

    // lanza un modal en caso de fallo en la pantalla
    public static void errorDato(JTextPane panel, String texto) {
        JOptionPane.showMessageDialog(
                panel,
                texto,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

}
