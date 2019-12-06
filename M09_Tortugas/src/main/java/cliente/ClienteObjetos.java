package cliente;

import java.awt.Color;
import tortuga.Tortuga;

public class ClienteObjetos {
     
     // CONSTRUCTOR
     public ClienteObjetos() {
          mensaje = new ClienteMensajes();
     }
     
     // METODOS
     // setter Objetos
     public void setObject(Object object) {
          this.object = object;
     }

     // clasifica
     public void clasificacionObjetos() {

          // si el objeto es una tortuga <--------------------
          if (object instanceof Tortuga) {

               tortuga = (Tortuga) object;
               int dorsal = tortuga.getDorsal();
               boolean visible = tortuga.isVisible();
               String nota = tortuga.getTexto();
               
               String texto = (visible) ? "creada con exito" : "borrada con exito"; 
               if (nota.equals("")) {
                    mensaje.mensaje(ClienteMain.panelCliente,
                       "La tortuga con nombre " + tortuga.getNombre()
                       + " y dorsal " + dorsal + texto, Color.GREEN);
               }
               // llamo al setter que configura la tortuga
               ClienteMain.setTortuga(tortuga); 
          }
          
          // si el objeto pasado es un String <----------------
          if (object instanceof String) {
               String texto = String.valueOf(object);

               switch (texto) {
                    case "carrera":
                         ClienteMain.desconectarBotones();
                         break;
               default:
                    mensaje.mensaje(ClienteMain.panelCliente, texto, Color.BLACK);
               }
          }

          // si el objeto es una lista <----------------------
          if (object instanceof Tortuga[]) {
               listaTortugas = (Tortuga[]) object;

               try {
                    for (int i = 0; i < listaTortugas.length; i++) {
                         if (listaTortugas[i] != null) {
                              nombre = listaTortugas[i].getNombre();
                              dorsal = listaTortugas[i].getDorsal();
                              Color c = ((i % 2) == 0) ? Color.BLUE : Color.MAGENTA;
                                   mensaje.mensaje(ClienteMain.panelCliente, (i+1) + "   Nombre: " + nombre + " - Dorsal: " + dorsal, c);
                              
                              if (i<listaTortugas.length) {
                              }
                         }
                    }
               } catch (Exception e) {
                    mensaje.mensaje(ClienteMain.panelCliente, "Error: "+e, Color.red);
               }
          }
     }
     
     // ATRIBUTOS
     private  Object object;
     private  Tortuga tortuga;
     private String nombre;
     private int dorsal;
     
     
     private ClienteMensajes mensaje;
     private Tortuga listaTortugas[];
}
