package servidor;

import java.awt.Color;
import tortuga.Tortuga;

public class ServidorObjetos {

     // CONSTRUCTOR
     public ServidorObjetos() {

          listaTortugas = new Tortuga[8]; // lista de tortugas
          mensaje = new ServidorMensajes(); // para escribir en el textpanel
     }

     // METODOS
     // setter Objetos
     public void setObject(Object object) {
          this.object = object;
     }
         
     // clasifica el objeto y manda segun la clase
     public void clasificaObjectos() {

          if (object instanceof Tortuga) {
               clasificaTortuga();
          }
          if (object instanceof String) {
               clasificaString();
          }

     }

     // destino objetos tortugas
     private void clasificaTortuga() {

          String texto;
          int numero;

          servidorOutput = new ServidorOutput();
          tortuga = (Tortuga) object;
          numero = tortuga.getDorsal() - 1;
          texto = tortuga.getNombre();
          mensaje.mensaje(ServidorMain.panelServidor, "Se ha solicitado crear una tortuga con nombre "
                  + texto + " y dorsal " + (numero + 1), Color.BLACK);

          try {
               // si no existe
               if (listaTortugas[numero] == null) {
                    listaTortugas[numero] = tortuga;
                    mensaje.mensaje(ServidorMain.panelServidor,
                            "La tortuga con nombre " + texto
                            + " y dorsal " + (numero + 1) + " a sido creada con exito", Color.GREEN);
                    // pongo la tortuga para mandarla al cliente y que la ponga en la pista
                    servidorOutput.setObject(listaTortugas[numero]);
                    servidorOutput.start();

               } else {
                    // si existe     
                    texto = "La tortuga con numero " + (numero + 1)
                            + " ya estaba creada";
                    mensaje.mensaje(ServidorMain.panelServidor, texto, Color.red);
                    servidorOutput.setObject(texto); // colocando objeto a enviar
                    servidorOutput.start(); // enviando
               }
          } catch (Exception e) {
               mensaje.mensaje(ServidorMain.panelServidor, "Error: " + e, Color.red);
          }

     }
     
     // destino objetos String
     private void clasificaString() {

          String texto;
          int numero;

          texto = String.valueOf(object);

          switch (texto) {

                case "mostrar":
                    clasificaMostrar();
                    break;
               case "carrera":
                    clasificaCarrera();
                    break;              
               default:
                    clasificaBorrar();
          }
     }
     
     // destino objetos string (mostrar)
     private void clasificaMostrar() {

          String texto;
          int numero;
          mensaje.mensaje(ServidorMain.panelServidor, "Se ha solicitado mostrar una lista de las tortugas", Color.BLACK);
          servidorOutput = new ServidorOutput();
          servidorOutput.setObject(listaTortugas); // colocando objeto a enviar
          servidorOutput.start(); // enviando
          mensaje.mensaje(ServidorMain.panelServidor, "La lista de las tortugas se ha enviado con exito", Color.GREEN);

     }
     
     // destino objetos string (carrera)
     private void clasificaCarrera() {

          String texto;
          int numero;
          
          mensaje.mensaje(ServidorMain.panelServidor, "Se ha solicitado una carrera", Color.BLACK);
          
          // cuento las tortugas, si no hay al menos dos, no hay carrera.
          int contador = 0;
          for (int i = 0; i < 7; i++) {
               if (listaTortugas[i] != null) {
                    contador++;
               }
          }
          
          if (contador < 2) {
               texto = "Deben de haber al menos dos tortugas para correr";
               mensaje.mensaje(ServidorMain.panelServidor, texto, Color.red);
               servidorOutput = new ServidorOutput();
               servidorOutput.setObject(texto); // colocando objeto a enviar
               servidorOutput.start(); // enviando
               return;
          }
          
          // mando un mensaje al cliente para que desactive los botones
          servidorOutput = new ServidorOutput();
          servidorOutput.setObject("carrera");
          servidorOutput.start();

          // hago una cuenta atras
          for (int i = 5; i >= 1; i--) {
               try {
                    texto = "La carrera empieza en " + i + ((i > 1) ? " segundos" : " segundo");
                    mensaje.mensaje(ServidorMain.panelServidor, texto, Color.BLACK);

                    servidorOutput = new ServidorOutput();
                    servidorOutput.setObject(texto); // colocando objeto a enviar
                    servidorOutput.start(); // enviando
                    servidorOutput.join();
                    servidorOutput.sleep(1000);

               } catch (InterruptedException ex) {
                    mensaje.mensaje(ServidorMain.panelServidor, "Error: " + ex, Color.red);
               }
          }
          
          // GO!!!
          servidorOutput = new ServidorOutput();
          servidorOutput.setObject("Comienza!!!");
          servidorOutput.start();
          
          // Hago una instancia de la clase carreras
          carrera = new Carrera(listaTortugas);
          carrera.start();

     }
     
     // destino objetos string (borrar)
     private void clasificaBorrar() {

          String texto;
          int numero;
          

          servidorOutput = new ServidorOutput();
          try {
               // paso el objeto a entero
               numero = (Integer.parseInt(String.valueOf(object)) - 1);

          } catch (NumberFormatException e) {
               mensaje.mensaje(ServidorMain.panelServidor, "Error: " + e, Color.red);
               return;
          }

          mensaje.mensaje(ServidorMain.panelServidor, "Se ha solicitado borrar la tortuga " + (numero + 1), Color.BLACK);
          try {
               if (listaTortugas[numero] == null) {

                    // si no existe la tortuga
                    texto = "La tortuga con el dorsal " + (numero + 1) + " no existe";
                    mensaje.mensaje(ServidorMain.panelServidor,
                            texto, Color.RED);
                    // envio la respuesta
                    servidorOutput.setObject(texto);
                    servidorOutput.start();

               } else {

                    // si existe
                    // la invisibilizo y envio para que la borre de la pista
                    listaTortugas[numero].setVisible(false);
                    servidorOutput.setObject(listaTortugas[numero]);
                    servidorOutput.start();

                    texto = "La tortuga con numero " + (numero + 1)
                            + " ha sido borrada con exito";
                    mensaje.mensaje(ServidorMain.panelServidor, texto, Color.GREEN);
                    // y ahora ya la borro
                    listaTortugas[numero] = null;
               }

          } catch (Exception e) {
               mensaje.mensaje(ServidorMain.panelServidor, "Error: " + e, Color.red);
          }
     }


     // ATRIBUTOS
     private Object object;
     private Tortuga tortuga;

     private Tortuga listaTortugas[];
     private ServidorOutput servidorOutput;
     private ServidorMensajes mensaje;
     private Carrera carrera;
}
