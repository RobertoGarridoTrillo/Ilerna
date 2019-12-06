package button;

import constantes.Constantes;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Color;


public class ButtonsFactory {

    public static JGradientButton createButton(Buttons b) {
        
        JGradientButton button;
        int width, height, x, y;
        String text = "";
        String tooltip = "";
        Color c;
        
        
        switch (b) {
            case CERO:              x = 100; y = 560; width = 90; height = 80; text = "0"; 
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla 0</h2>"; c = Color.GRAY; break; 
            case UNO:               x = 10;  y = 480; width = 90; height = 80; text = "1";
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla 1</h2>"; c = Color.GRAY; break; 
            case DOS:               x = 100; y = 480; width = 90; height = 80; text = "2";
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla 2</h2>"; c = Color.GRAY; break; 
            case TRES:              x = 190; y = 480; width = 90; height = 80; text = "3";
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla 3</h2>"; c = Color.GRAY; break; 
            case CUATRO:            x = 10;  y = 400; width = 90; height = 80; text = "4";
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla 4</h2>"; c = Color.GRAY; break; 
            case CINCO:             x = 100; y = 400; width = 90; height = 80; text = "5";
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla 5</h2>"; c = Color.GRAY; break; 
            case SEIS:              x = 190; y = 400; width = 90; height = 80; text = "6";
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla 6</h2>"; c = Color.GRAY; break; 
            case SIETE:             x = 10;  y = 320; width = 90; height = 80; text = "7";
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla 7</h2>"; c = Color.GRAY; break; 
            case OCHO:              x = 100; y = 320; width = 90; height = 80; text = "8";
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla 8</h2>"; c = Color.GRAY; break; 
            case NUEVE:             x = 190; y = 320; width = 90; height = 80; text = "9";
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla 9</h2>"; c = Color.GRAY; break; 
            case SUMAR:             x = 280; y = 480; width = 90; height = 80; text = "+";
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla +</h2>"; c = Color.DARK_GRAY; break; 
            case RESTAR:            x = 280; y = 400; width = 90; height = 80; text = "-";
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla -</h2>"; c = Color.DARK_GRAY; break; 
            case MULTIPLICAR:       x = 280; y = 320; width = 90; height = 80; text = "x"; 
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla *</h2>"; c = Color.DARK_GRAY; break; 
            case DIVIDIR:           x = 280; y = 240; width = 90; height = 80; text = "÷"; 
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla /</h2>"; c = Color.DARK_GRAY; break; 
            case BORRARPARTE:       x = 10;  y = 240; width = 90; height = 80; text = "CE"; 
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla Suprimir</h2>"; c = Color.DARK_GRAY; break; 
            case BORRARTODO:        x = 100; y = 240; width = 90; height = 80; text = "C"; 
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla Inicio</h2>"; c = Color.DARK_GRAY; break; 
            case BORRARATRAS:       x = 190; y = 240; width = 90; height = 80; text = "◄"; 
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla Retroceso</h2>"; c = Color.DARK_GRAY; break; 
            case MASMENOS:          x = 10;  y = 560; width = 90; height = 80; text = "±"; 
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla Pagina abajo</h2>"; c = Color.DARK_GRAY; break; 
            case COMA:              x = 190; y = 560; width = 90; height = 80; text = ","; 
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla NUMPAD .</h2>"; c = Color.DARK_GRAY; break; 
            case IGUAL:             x = 280; y = 560; width = 90; height = 80; text = "="; 
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla INTRO</h2>"; c = Color.DARK_GRAY; break; 
            case TANTOPORCIENTO:    x = 10;  y = 160; width = 90; height = 80; text = "%";  
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla F9</h2>"; c = Color.DARK_GRAY; break; 
            case CUADRADO:          x = 100; y = 160; width = 90; height = 80; text = "x²"; 
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla F10</h2>"; c = Color.DARK_GRAY; break; 
            case RAIZCUADRADA:      x = 190; y = 160; width = 90; height = 80; text = "²√"; 
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla F11</h2>"; c = Color.DARK_GRAY; break; 
            case FRACCION:          x = 280; y = 160; width = 90; height = 80; text = "¹/x"; 
                                    tooltip="<html><h2 style='color:black;text-align:center;'>Tecla F12</h2>"; c = Color.DARK_GRAY; break; 
            default:
                throw new AssertionError();
        }
        
        button = new JGradientButton(c);                
        button.setActionCommand(String.valueOf(b));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(Constantes.BUTTON_FONT);
        button.setText(text);
        button.setToolTipText(tooltip);
        button.setPreferredSize(new Dimension(width, height));
        button.setMaximumSize(button.getPreferredSize());
        button.setMinimumSize(button.getPreferredSize());
        button.setBounds(x, y, width, height);
        return button;

    }
}  
