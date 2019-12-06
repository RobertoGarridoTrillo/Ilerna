package tortuga;

import java.io.Serializable;

public class Tortuga extends Thread implements Serializable {

     // CONSTRUCTOR 
     public Tortuga(String nombre, int dorsal, boolean visible, int x, int y, String texto) {
          this.nombre = nombre;
          this.dorsal = dorsal;
          this.visible = visible;
          this.x = x;
          this.y = y;
          this.texto = texto;
         
     }
     
     // SOBRECARGA POR DEFECTO CON NOMBRE, DORSAL Y VISIBILIDADA
     public Tortuga(String nombre, int dorsal) {
          this.nombre = nombre;
          this.dorsal = dorsal;
          this.visible = true;
          x = 70;
          switch (dorsal) { 
               case 1: y = 2;break;
               case 2: y = 70;break;
               case 3: y = 148;break;
               case 4: y = 222;break;
               case 5: y = 295;break;
               case 6: y = 368;break;
               case 7: y = 440;break;
               case 8: y = 511;break; 
          }
          this.texto = "";
     }

     // METODOS 
     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public int getDorsal() {
          return dorsal;
     }

     public void setDorsal(int dorsal) {
          this.dorsal = dorsal;
     }

     public boolean isVisible() {
          return visible;
     }

     public void setVisible(boolean visible) {
          this.visible = visible;
     }

     public int getX() {
          return x;
     }

     public void setX(int x) {
          this.x = x;
     }

     public int getY() {
          return y;
     }

     public void setY(int y) {
          this.y = y;
     }

     public String getTexto() {
          return texto;
     }

     public void setTexto(String texto) {
          this.texto = texto;
     }


     // ATRIBUTOS
     private String nombre;
     private int dorsal;
     private boolean visible;
     private int x, y;
     private String texto;
}
