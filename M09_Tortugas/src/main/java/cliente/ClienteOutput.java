package cliente;

import java.awt.Color;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import java.net.UnknownHostException;


public class ClienteOutput extends Thread {

       // CONSTRUCTOR
       public ClienteOutput() {
              
              this.ip = ClienteMain.getIP();
              this.puerto = ClienteMain.getPuerto();
              // creo una instancia de mensaje
              mensaje = new ClienteMensajes();

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
                     socketSalida = new Socket(ip, puerto);
                     clienteSalida = new ObjectOutputStream(socketSalida.getOutputStream());

                     clienteSalida.writeObject(object);
                                         
                     clienteSalida.close();
                     socketSalida.close();

              } catch (UnknownHostException e) {
                     mensaje.mensaje(ClienteMain.panelCliente, "Host desconocido" + ip, Color.RED);
              } catch (IOException e) {
                     mensaje.mensaje(ClienteMain.panelCliente, "Error, problemas en la conexión", Color.RED);
              }

       }
       
       // ATRIBUTOS
       private String ip;
       private int puerto;
       private String Dorsal;
       
       private String salida;
       private String texto;
       private Object object;
 
       
       private ClienteMensajes mensaje;

       private Socket socketSalida;
       private ObjectOutputStream clienteSalida;
       
       private ClienteOutput cliente;
}
      
