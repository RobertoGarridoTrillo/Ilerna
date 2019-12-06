package cliente;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class ClienteInput extends Thread {

     // CONSTRUCTOR
     public ClienteInput() {

          this.puerto = ClienteMain.getPuerto();
          // hago una instancia de la clase mensaje para los mensajes en consola
          mensaje = new ClienteMensajes();
          // instancia para clasificador
          clienteObjetos = new ClienteObjetos();

     }

     
     
     // METODOS
     // se pone a la escucha una peticion
     @Override
     public void run() {
          try {
               serverSocket = new ServerSocket(puerto + 1); // abro el puerto+1 para vuelta
               mensaje.mensaje(ClienteMain.panelCliente, "En conexion", Color.BLACK);
               
               while (true) {
                    socket = serverSocket.accept(); // espera que llegen datos

                    // creamos un flujo de entrada
                    objectInputStream = new ObjectInputStream(socket.getInputStream());
                    try {
                         // leemos un objeto
                         object = objectInputStream.readObject();
                         
                         // mando el objeto a ClienteObjeto para clasificarlo                         
                         clienteObjetos.setObject(object);
                         clienteObjetos.clasificacionObjetos();
                         
                         
                    } catch (ClassNotFoundException ex) {
                         mensaje.mensaje(ClienteMain.panelCliente, "Error: " + ex, Color.red);
                    }
                      
                    // cerramos el flujo de entrada
                    objectInputStream.close();

               }

          } catch (IOException ex) {
               mensaje.mensaje(ClienteMain.panelCliente, "Error: " + ex, Color.red);
          }
     }

     // ATRIBUTOS
     private int puerto;

     private ServerSocket serverSocket;
     public  Socket socket;
     private ObjectInputStream objectInputStream;
     private Object object;

     private ClienteMensajes mensaje;
     private ClienteObjetos clienteObjetos;
  
}
