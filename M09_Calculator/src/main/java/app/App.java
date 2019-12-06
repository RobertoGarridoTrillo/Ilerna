package app;

import java.awt.EventQueue;
import panel.FrameInicio;

public class App {

    public static void main (String[] args) {
        EventQueue.invokeLater(() -> {
            var panelInicio = new FrameInicio();
        });
    }    
}   

