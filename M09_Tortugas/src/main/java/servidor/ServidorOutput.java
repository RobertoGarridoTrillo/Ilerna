package servidor;

import java.awt.Color;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import java.net.UnknownHostException;


public class ServidorOutput extends Thread {

       // CONSTRUCTOR
       public ServidorOutput() {

              this.ip = ServidorMain.getIP();
              this.puerto = ServidorMain.getPuerto();
              // creo una instancia de mensaje
              mensaje = new ServidorMensajes();

       }

       // METODOS
       
       // setter Object
       public void setObject(Object object) {
              this.object = object;
       }
        
       // sobreescribe el run()       
       @Override
       public synchronized void run() {

          try {

               socketSalida = new Socket(ip, puerto + 1);
               servidorSalida = new ObjectOutputStream(socketSalida.getOutputStream());

               servidorSalida.writeObject(object);
                              
               servidorSalida.close();
               socketSalida.close();

          } catch (UnknownHostException e) {
               mensaje.mensaje(ServidorMain.panelServidor, "Host desconocido" + ip, Color.RED);

          } catch (IOException e) {
               mensaje.mensaje(ServidorMain.panelServidor, "Error, problemas en la conexión", Color.RED);
          }

     }

       // ATRIBUTOS
       private String ip;
       private int puerto;
       private int dorsal;
       
       private String salida;
       private String texto;
       private Object object;
       
       private ServidorMensajes mensaje;

       private Socket socketSalida;
       private ObjectOutputStream servidorSalida;
       
       private ServidorOutput servdor;

}