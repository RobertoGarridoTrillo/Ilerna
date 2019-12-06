package teclas;

import button.Buttons;
import java.awt.event.ActionEvent;

public class RecogeClicks extends Clasificador {

    // Field attributes
        private Object key;

    // methods
    public void actionPerformed(ActionEvent e) {
        // reading keys
        key = e.getActionCommand();

        // sorting keys
        // this method checks if it´s a number
        for (int i = 0; i <= 9; i++) {
            if (key == Buttons.BUTTONSNAME.buttonName(i).toString()) {
                vk_number(String.valueOf(i));
                break;
            }
        }
        //System.out.println(key);
        if (key == "BORRARATRAS") { vk_back_space(); }
        if (key == "BORRARPARTE") { vk_delete(); }
        if (key == "BORRARTODO") { vk_home(); }
        
        if (key == "SUMAR") { vk_operator("+"); }
        if (key == "RESTAR") { vk_operator("-"); }
        if (key == "MULTIPLICAR") { vk_operator("*"); }
        if (key == "DIVIDIR") { vk_operator("/"); }
        
        if (key == "COMA") { vk_decimal(); }
        if (key == "MASMENOS") {vk_page_down(); }
        
        if (key == "IGUAL") { vk_enter(); }

        if (key == "TANTOPORCIENTO") {
        }
        if (key == "CUADRADO") {
        }
        if (key == "RAIZCUADRADA") {
        }
        if (key == "FRACCION") {
        }
    }

}
