package servidor;

import java.awt.Color;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.StyleConstants;
import javax.swing.text.BadLocationException;

public class ServidorMensajes {

       // CONSTRUCTOR
       public ServidorMensajes() {
              // array para el fichero de los animales
              nombreAnimal = new String[]{
                     "tortuga01", "tortuga01Dorsal", "tortuga01Error",
                     "gallina", "gallinaError",
                     "tortuga02", "tortuga02Error",
                     "niño01", "niño01Error"
              };
       }
       
       
       // METODOS 
       // escribe un mensaje en el jTextArea
       public void mensaje(JTextPane panel, String texto, Color c) {
              // seleccionamos texto plano, no rtf ni html
              panel.setContentType("text/plain");

              // Creamos el objeto atributo para cambiar los atributos del texto
              SimpleAttributeSet attrs = new SimpleAttributeSet();
              StyleConstants.setForeground(attrs, c);

              //
              int lonjitud = panel.getStyledDocument().getLength();
              try {

                     panel.getStyledDocument().insertString(lonjitud, texto + "\n", attrs);

              } catch (BadLocationException e) {
                     errorDato(panel, "El cliente tiene problemas con la pantalla de mensajes", 2);
                     panel.setText(texto);
              }
       }

       // errores personalizados 
       public void errorDato(JTextPane panel, String texto, int imagen) {
              JOptionPane.showMessageDialog(
                      panel,
                      texto,
                      "Error",
                      JOptionPane.ERROR_MESSAGE,
                      new ImageIcon(getClass().getResource("/ClienteImagenes/" + nombreAnimal[imagen] + ".png"))
              );
       }

       // pedir dato personalizado
       public String pedirDato(JTextPane panel, String texto, int imagen) {
              texto = String.valueOf(JOptionPane.showInputDialog(
                      panel,
                      texto,
                      "Elige nombre",
                      JOptionPane.QUESTION_MESSAGE,
                      new ImageIcon(getClass().getResource("/ClienteImagenes/" + nombreAnimal[imagen] + ".png")),
                      null, null
              ));
              return texto;
       }

       // ATRIBUTOS
       private static String nombreAnimal[] ;
}
