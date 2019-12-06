package teclas;

import java.awt.Color;
import javax.swing.JOptionPane;
import static mensaje.Mensaje.mensaje;
import static mensaje.Mensaje.errorDato;
import static panel.PanelPrincipal.jTextPane;

public class Clasificador {

//<editor-fold defaultstate="collapsed" desc="Header class">
    // Field attributes
    private static String textoMenosUno, textIn, textOut;
    private static int decimal[];
    private static int lineaInicio;
    private static String linea[];
    private static boolean contador;

    public Clasificador() {
        linea = new String[3];
        decimal = new int[3];
        iniciarVariable();
    }

    private void iniciarVariable() {
        lineaInicio = 0;
        // array with the three lineas of calculation
        linea[0] = "";
        linea[1] = "";
        linea[2] = "";
        // array with decimal numbers by line
        decimal[0] = 0;
        decimal[1] = 0;
        decimal[2] = 0;
        contador = false;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="vk_number()">
    // if it´s pressed 0-9 or numpad 0-9 writes one numbre
    protected void vk_number(String key) {
        if (contador) {
            vk_home();
            return;
        }
        if (lineaInicio != 1) {
            if (linea[lineaInicio] == null) {
                linea[lineaInicio] = key;
            } else {
                linea[lineaInicio] += key;
            }
            mensaje(jTextPane, key, Color.BLUE, -1);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="vk_back_space()">
    protected void vk_back_space() {
        if (contador) {
            vk_home();
            return;
        }
        // only it erases if it´s not the begging of the jtextpanel

        // I check if the letter erased is a comma
        if (linea[lineaInicio].length() > 0) {

            textIn = linea[lineaInicio].substring(linea[lineaInicio].length() - 1, linea[lineaInicio].length());
            if (textIn.equals(".")) {
                decimal[lineaInicio] = (decimal[lineaInicio] - 1);
            }

            textoMenosUno = linea[lineaInicio].substring(0, linea[lineaInicio].length() - 1);
            linea[lineaInicio] = textoMenosUno;

            if (lineaInicio == 0) {
                mensaje(jTextPane, "", Color.BLUE, -2);
            } else if (lineaInicio == 2) {
                mensaje(jTextPane, "", Color.BLUE, -6);
            }
        }
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="vk_delete()">
    protected void vk_delete() {
        if (contador) {
            vk_home();
            return;
        }
        mensaje(jTextPane, "", Color.BLUE, linea[lineaInicio].length());
        linea[lineaInicio] = "";
        // we clean decimals numbers
        decimal[lineaInicio] = 0;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="vk_home()">
    protected void vk_home() {
        // we initalize the varibles
        iniciarVariable();
        mensaje(jTextPane, "", Color.BLUE, -3);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="vk_operator()">
    protected void vk_operator(String operator) {
        if (contador) {
            vk_home();
            return;
        }
        // only if it´s in the second line and it´s the first chatacter or
        // if it´s in the first line and it´s not the first chatacter
        if ((lineaInicio == 0 && !linea[lineaInicio].equals(""))
                || (lineaInicio == 1 && linea[lineaInicio].equals(""))) {
            lineaInicio++;
            linea[lineaInicio] = operator;
            lineaInicio++;
            mensaje(jTextPane, operator, Color.BLUE, -4);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="vk_decimal">
    protected void vk_decimal() {
        if (contador) {
            vk_home();
            return;
        }
        if (linea[lineaInicio].length() == 0) {
            linea[lineaInicio] = "0";
            mensaje(jTextPane, "0", Color.BLUE, -1);

        }
        if (decimal[lineaInicio] < 1) {
            linea[lineaInicio] += ".";
            decimal[lineaInicio]++;
            mensaje(jTextPane, ".", Color.BLUE, -1);
        }

    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="vk_page_down()">
    protected void vk_page_down() {
        if (contador) {
            vk_home();
            return;
        }
        if (linea[lineaInicio].length() > 0 && lineaInicio != 1) {
            textIn = linea[lineaInicio].substring(0, 1);
            if (textIn.equals("-")) {
                // extrae la linea menos el guion
                textIn = linea[lineaInicio].substring(1, linea[lineaInicio].length());

                // erase and write the message without the '-'
                if (lineaInicio >= 1) {
                    mensaje(jTextPane, "\n", Color.BLUE, -1);
                }
                mensaje(jTextPane, "", Color.BLUE, (linea[lineaInicio].length()));
                linea[lineaInicio] = textIn;
                mensaje(jTextPane, linea[lineaInicio], Color.BLUE, -1);
            } else {
                textOut = "-" + linea[lineaInicio];

                // erase and write the message with the '-'
                if (lineaInicio >= 1) {
                    mensaje(jTextPane, "\n", Color.BLUE, -1);
                }
                mensaje(jTextPane, "", Color.BLUE, (linea[lineaInicio].length()));
                linea[lineaInicio] = textOut;
                mensaje(jTextPane, linea[lineaInicio], Color.BLUE, -1);

            }
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="vk_enter()">
    protected void vk_enter() {
        if (contador) {
            vk_home();
            return;
        }
        double dato1, dato2;
        String resul;
        // if anything is empty error
        if (linea[0].equals("") || linea[1].equals("") || linea[2].equals("")) {
            errorDato(jTextPane, "Falta algun dato");
        } else {
            dato1 = Double.valueOf(linea[0]);
            dato2 = Double.valueOf(linea[2]);
            // add
            if (linea[1].equals("+")) {
                resul = String.valueOf(dato1 + dato2);
                mensaje(jTextPane, resul, Color.GREEN, -4);
                iniciarVariable();
            }
            // minus
            if (linea[1].equals("-")) {
                resul = String.valueOf(dato1 - dato2);
                mensaje(jTextPane, resul, Color.GREEN, -4);
                iniciarVariable();
            }
            // multiply
            if (linea[1].equals("*")) {
                resul = String.valueOf(dato1 * dato2);
                mensaje(jTextPane, resul, Color.GREEN, -4);
                iniciarVariable();
            }
            // divide
            if (linea[1].equals("/")) {
                resul = String.valueOf(dato1 / dato2);
                mensaje(jTextPane, resul, Color.GREEN, -4);

            }
            contador = true;

        }

    }
//</editor-fold>  

//<editor-fold defaultstate="collapsed" desc="vk_exit()">
    // if returned = 2 then exit, if it´s zero nothing happens
    protected void vk_exit() {
        if (javax.swing.JOptionPane.showConfirmDialog(
                jTextPane,
                "Cerrando aplicacion...",
                "Calculadora",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0) {
            System.exit(0);
        }

    }
//</editor-fold> 

}
//</editor-fold>

