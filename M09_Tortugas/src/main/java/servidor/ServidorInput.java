package servidor;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class ServidorInput extends Thread {

     // CONSTRUCTOR
     public ServidorInput() {

          this.puerto = ServidorMain.getPuerto();

          // instancia para los mensajes en consola
          mensaje = new ServidorMensajes();
          // instancia para el clasificador
          servidorObjetos = new ServidorObjetos();
          
       }

       
       // METODOS
       // se pone a la escucha una peticion
       @Override
     public void run() {
          try {
               serverSocket = new ServerSocket(puerto); // abro el puerto para vuelta
               mensaje.mensaje(ServidorMain.panelServidor, "En conexion", Color.BLACK);
               
               
               while (true) {
                    socket = serverSocket.accept(); // espera que llegen datos

                    // creamos un flujo de entrada
                    objectInputStream = new ObjectInputStream(socket.getInputStream());
                    try {
                         // Leemos un objeto
                         object = objectInputStream.readObject();
                                                  
                         // mando objeto y clasifico
                         servidorObjetos.setObject(object);
                         servidorObjetos.clasificaObjectos();
                         
                    } catch (ClassNotFoundException ex) {
                         mensaje.mensaje(ServidorMain.panelServidor, "Error: " + ex, Color.red);
                    }
                    
                    // cerramos el flujo de entrada
                    objectInputStream.close();
               }
          } catch (IOException ex) {
               mensaje.mensaje(ServidorMain.panelServidor, "Error: " + ex, Color.RED);
          }
     }

       // ATRIBUTOS
       private int puerto;
     
       private ServerSocket serverSocket;
       private Socket socket;
       private ObjectInputStream objectInputStream;
       private Object object;
       
       private ServidorMensajes mensaje;
       private ServidorObjetos servidorObjetos;
       
}

       
