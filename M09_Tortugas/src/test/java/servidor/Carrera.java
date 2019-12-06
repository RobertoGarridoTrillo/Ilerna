package servidor;

import java.awt.Color;
import tortuga.Tortuga;

public class Carrera extends Thread{
     
     // CONSTRUCTOR
     public Carrera(Tortuga[] listaTortugas) {
          
          this.listaTortugas = listaTortugas;
          mensaje = new ServidorMensajes();
          step = new int[8];
          meta = 800;
          retardo =30;
     }
     
     
     // METODOS
     
     // calcula las velocidades al azar
     private void calcularStep() {

          // pongo las velocidades de las tortugas al azar
          int azar;
          boolean salida = true;
          int contador = 0;
          //mensaje.mensaje(ServidorMain.panelServidor, "Calculando avance para cada tortuga: ", Color.BLACK);

          while (contador < 8) {
               azar = (int)((Math.random() * 10) + 1);
               salida = true;
               for (int k = 0; k < 8; k++) {
                    if (step[k] == azar) {
                         salida = false;
                    }
               }
               if (salida) {
                    step[contador] = azar;
                    //mensaje.mensaje(ServidorMain.panelServidor, "avance " + contador + " --> " + step[contador], Color.red);
                    salida = false;
                    contador++;
               }
          }

     }

     // metodo principal
     @Override
     public void run() {
          
          // cuentos los participantes
          for (int i = 0; i < 8; i++) {
               if (listaTortugas[i] != null) cont1++;
          }
          // llamo a calcular el avance
          calcularStep();
          
          // creo un hilo para cada tortuga (uso una clase interna anonima)
           
         Thread tortuga0 = new Thread() {
               @Override
               public void run() {
                    try {
                         boolean salida = true;
                         int x = 0;
                         while (salida) {
                              // modifico la variable texto
                              listaTortugas[x].setTexto("false");
                              // le sumo a la posicion X de la tortuga el step individual
                              listaTortugas[x].setX((int)(listaTortugas[x].getX() + step[x]));
                              // si llega a la meta salgo del bucle
                              if (listaTortugas[x].getX() >= meta) {salida = false;}
                              // la envio al cliente para que la muestre
                              ServidorOutput servidorOutput = new ServidorOutput();
                              servidorOutput.setObject(listaTortugas[x]);
                              servidorOutput.start();
                              sleep(retardo);
                         }//while
                         // envio al cliente los datos de orden de llegada
                         ServidorOutput servidorOutput = new ServidorOutput();
                         cont2++;
                         String texto ="Puesto: " + cont2 + " Nombre: " + listaTortugas[x].getNombre() + " Dorsal: " + listaTortugas[x].getDorsal();
                         mensaje.mensaje(ServidorMain.panelServidor, texto, Color.BLACK);
                         servidorOutput.setObject(texto);
                         servidorOutput.start();
                    } catch (InterruptedException ex) {
                         mensaje.mensaje(ServidorMain.panelServidor, "Error : " + ex, Color.red);
                    }//try catch
               }//run
          };//thread
         
          
         Thread tortuga1 = new Thread() {
               @Override
               public void run() {
                    try {
                         boolean salida = true;
                         int x = 1;
                         while (salida) {
                              // modifico la variable texto
                              listaTortugas[x].setTexto("false");
                              // le sumo a la posicion X de la tortuga el step individual
                              listaTortugas[x].setX((int)(listaTortugas[x].getX() + step[x]));
                              // si llega a la meta salgo del bucle
                              if (listaTortugas[x].getX() >= meta) {salida = false;}
                              // la envio al cliente para que la muestre
                              ServidorOutput servidorOutput = new ServidorOutput();
                              servidorOutput.setObject(listaTortugas[x]);
                              servidorOutput.start();
                              sleep(retardo);
                         }//while
                         // envio al cliente los datos de orden de llegada
                         ServidorOutput servidorOutput = new ServidorOutput();
                         cont2++;
                         String texto ="Puesto: " + cont2 + " Nombre: " + listaTortugas[x].getNombre() + " Dorsal: " + listaTortugas[x].getDorsal();
                         mensaje.mensaje(ServidorMain.panelServidor, texto, Color.BLACK);
                         servidorOutput.setObject(texto);
                         servidorOutput.start();            
                    } catch (InterruptedException ex) {
                         mensaje.mensaje(ServidorMain.panelServidor, "Error : " + ex, Color.red);
                    }//try catch
               }//run
          };//thread

         Thread tortuga2 = new Thread() {
               @Override
               public void run() {
                    try {
                         boolean salida = true;
                         int x = 2;
                         while (salida) {
                              // modifico la variable texto
                              listaTortugas[x].setTexto("false");
                              // le sumo a la posicion X de la tortuga el step individual
                              listaTortugas[x].setX((int)(listaTortugas[x].getX() + step[x]));
                              // si llega a la meta salgo del bucle
                              if (listaTortugas[x].getX() >= meta) {salida = false;}
                              // la envio al cliente para que la muestre
                              ServidorOutput servidorOutput = new ServidorOutput();
                              servidorOutput.setObject(listaTortugas[x]);
                              servidorOutput.start();
                              sleep(retardo);
                         }//while
                         // envio al cliente los datos de orden de llegada
                         ServidorOutput servidorOutput = new ServidorOutput();
                         cont2++;
                         String texto ="Puesto: " + cont2 + " Nombre: " + listaTortugas[x].getNombre() + " Dorsal: " + listaTortugas[x].getDorsal();
                         mensaje.mensaje(ServidorMain.panelServidor, texto, Color.BLACK);
                         servidorOutput.setObject(texto);
                         servidorOutput.start();
 
                    } catch (InterruptedException ex) {
                         mensaje.mensaje(ServidorMain.panelServidor, "Error : " + ex, Color.red);
                    }//try catch
               }//run
          };//thread
         
          
         Thread tortuga3 = new Thread() {
               @Override
               public void run() {
                    try {
                         boolean salida = true;
                         int x = 3;
                         while (salida) {
                              // modifico la variable texto
                              listaTortugas[x].setTexto("false");
                              // le sumo a la posicion X de la tortuga el step individual
                              listaTortugas[x].setX((int)(listaTortugas[x].getX() + step[x]));
                              // si llega a la meta salgo del bucle
                              if (listaTortugas[x].getX() >= meta) {salida = false;}
                              // la envio al cliente para que la muestre
                              ServidorOutput servidorOutput = new ServidorOutput();
                              servidorOutput.setObject(listaTortugas[x]);
                              servidorOutput.start();
                              sleep(retardo);
                         }//while
                         // envio al cliente los datos de orden de llegada
                         ServidorOutput servidorOutput = new ServidorOutput();
                         cont2++;
                         String texto ="Puesto: " + cont2 + " Nombre: " + listaTortugas[x].getNombre() + " Dorsal: " + listaTortugas[x].getDorsal();
                         mensaje.mensaje(ServidorMain.panelServidor, texto, Color.BLACK);
                         servidorOutput.setObject(texto);
                         servidorOutput.start();
                   } catch (InterruptedException ex) {
                         mensaje.mensaje(ServidorMain.panelServidor, "Error : " + ex, Color.red);
                    }//try catch
               }//run
          };//thread  
         
         Thread tortuga4 = new Thread() {
               @Override
               public void run() {
                    try {
                         boolean salida = true;
                         int x = 4;
                         while (salida) {
                              // modifico la variable texto
                              listaTortugas[x].setTexto("false");
                              // le sumo a la posicion X de la tortuga el step individual
                              listaTortugas[x].setX((int)(listaTortugas[x].getX() + step[x]));
                              // si llega a la meta salgo del bucle
                              if (listaTortugas[x].getX() >= meta) {salida = false;}
                              // la envio al cliente para que la muestre
                              ServidorOutput servidorOutput = new ServidorOutput();
                              servidorOutput.setObject(listaTortugas[x]);
                              servidorOutput.start();
                              sleep(retardo);
                         }//while
                         // envio al cliente los datos de orden de llegada
                         ServidorOutput servidorOutput = new ServidorOutput();
                         cont2++;
                         String texto ="Puesto: " + cont2 + " Nombre: " + listaTortugas[x].getNombre() + " Dorsal: " + listaTortugas[x].getDorsal();
                         mensaje.mensaje(ServidorMain.panelServidor, texto, Color.BLACK);
                         servidorOutput.setObject(texto);
                         servidorOutput.start();
                    } catch (InterruptedException ex) {
                         mensaje.mensaje(ServidorMain.panelServidor, "Error : " + ex, Color.red);
                    }//try catch
               }//run
          };//thread
         
          
         Thread tortuga5 = new Thread() {
               @Override
               public void run() {
                    try {
                         boolean salida = true;
                         int x = 5;
                         while (salida) {
                              // modifico la variable texto
                              listaTortugas[x].setTexto("false");
                              // le sumo a la posicion X de la tortuga el step individual
                              listaTortugas[x].setX((int)(listaTortugas[x].getX() + step[x]));
                              // si llega a la meta salgo del bucle
                              if (listaTortugas[x].getX() >= meta) {salida = false;}
                              // la envio al cliente para que la muestre
                              ServidorOutput servidorOutput = new ServidorOutput();
                              servidorOutput.setObject(listaTortugas[x]);
                              servidorOutput.start();
                              sleep(retardo);
                         }//while
                         // envio al cliente los datos de orden de llegada
                         ServidorOutput servidorOutput = new ServidorOutput();
                         cont2++;
                         String texto ="Puesto: " + cont2 + " Nombre: " + listaTortugas[x].getNombre() + " Dorsal: " + listaTortugas[x].getDorsal();
                         mensaje.mensaje(ServidorMain.panelServidor, texto, Color.BLACK);
                         servidorOutput.setObject(texto);
                         servidorOutput.start();
                    } catch (InterruptedException ex) {
                         mensaje.mensaje(ServidorMain.panelServidor, "Error : " + ex, Color.red);
                    }//try catch
               }//run
          };//thread

          Thread tortuga6 = new Thread() {
               @Override
               public void run() {
                    try {
                         boolean salida = true;
                         int x = 6;
                         while (salida) {
                              // modifico la variable texto
                              listaTortugas[x].setTexto("false");
                              // le sumo a la posicion X de la tortuga el step individual
                              listaTortugas[x].setX((int)(listaTortugas[x].getX() + step[x]));
                              // si llega a la meta salgo del bucle
                              if (listaTortugas[x].getX() >= meta) {salida = false;}
                              // la envio al cliente para que la muestre
                              ServidorOutput servidorOutput = new ServidorOutput();
                              servidorOutput.setObject(listaTortugas[x]);
                              servidorOutput.start();
                              sleep(retardo);
                         }//while
                         // envio al cliente los datos de orden de llegada
                         ServidorOutput servidorOutput = new ServidorOutput();
                         cont2++;
                         String texto ="Puesto: " + cont2 + " Nombre: " + listaTortugas[x].getNombre() + " Dorsal: " + listaTortugas[x].getDorsal();
                         mensaje.mensaje(ServidorMain.panelServidor, texto, Color.BLACK);
                         servidorOutput.setObject(texto);
                         servidorOutput.start();
                    } catch (InterruptedException ex) {
                         mensaje.mensaje(ServidorMain.panelServidor, "Error : " + ex, Color.red);
                    }//try catch
               }//run
          };//thread
         
          
         Thread tortuga7 = new Thread() {
               @Override
               public void run() {
                    try {
                         boolean salida = true;
                         int x = 7;
                         while (salida) {
                              // modifico la variable texto
                              listaTortugas[x].setTexto("false");
                              // le sumo a la posicion X de la tortuga el step individual
                              listaTortugas[x].setX((int)(listaTortugas[x].getX() + step[x]));
                              // si llega a la meta salgo del bucle
                              if (listaTortugas[x].getX() >= meta) {salida = false;}
                              // la envio al cliente para que la muestre
                              ServidorOutput servidorOutput = new ServidorOutput();
                              servidorOutput.setObject(listaTortugas[x]);
                              servidorOutput.start();
                              sleep(retardo);
                         }//while
                         // envio al cliente los datos de orden de llegada
                         ServidorOutput servidorOutput = new ServidorOutput();
                         cont2++;
                         String texto ="Puesto: " + cont2 + " Nombre: " + listaTortugas[x].getNombre() + " Dorsal: " + listaTortugas[x].getDorsal();
                         mensaje.mensaje(ServidorMain.panelServidor, texto, Color.BLACK);
                         servidorOutput.setObject(texto);
                         servidorOutput.start();
                    } catch (InterruptedException ex) {
                         mensaje.mensaje(ServidorMain.panelServidor, "Error : " + ex, Color.red);
                    }//try catch
               }//run
          };//thread
         
          // empiezo la carrera
          if (listaTortugas[0].isVisible()) tortuga0.start();
          if (listaTortugas[1].isVisible()) tortuga1.start();
          if (listaTortugas[2].isVisible()) tortuga2.start();
          if (listaTortugas[3].isVisible()) tortuga3.start();          
          if (listaTortugas[4].isVisible()) tortuga4.start();
          if (listaTortugas[5].isVisible()) tortuga5.start();
          if (listaTortugas[6].isVisible()) tortuga6.start();
          if (listaTortugas[7].isVisible()) tortuga7.start();           
            
          // compruebo el final de la carrera
          if (cont1 == cont2) {
               ServidorOutput servidorOutput = new ServidorOutput();
               servidorOutput.setObject("Comienza!!!");
               servidorOutput.start();
     }
     }
     
     // ATRIBUTOS
     private Tortuga listaTortugas[];
     private int step[];
     private ServidorMensajes mensaje;
     private int meta;
     private int retardo;
     private static int cont1 = 0;
     private static int cont2 = 0;
     //private ServidorOutput servidorOutput;

}
