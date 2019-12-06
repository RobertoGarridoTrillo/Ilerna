package cliente;

import java.awt.Color;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.text.DefaultCaret;
import tortuga.Tortuga;


public class ClienteMain extends javax.swing.JFrame {

       @SuppressWarnings("unchecked")
       // poner setLayout null, setMinimunSize, setMaximumSize, size tal vez. 
       // en code pulsar generate center para centrarlo ->setLocationRelativeTo(null) y designer size.
       // al frame tuve que darle 20px de ancho mas al ejecutar, aun no se porque y de 835 a 875 (40PX) por el marco superior
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          botonIniciar = new javax.swing.JButton();
          botonPuerto = new javax.swing.JButton();
          botonIP = new javax.swing.JButton();
          botonSalir = new javax.swing.JButton();
          jScrollPane2 = new javax.swing.JScrollPane();
          panelCliente = new javax.swing.JTextPane();
          botonCrear = new javax.swing.JButton();
          botonCarrera = new javax.swing.JButton();
          botonMostrar = new javax.swing.JButton();
          botonBorrar = new javax.swing.JButton();
          jLabelCliente = new javax.swing.JLabel();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setTitle("CLIENTE");
          setLocation(new java.awt.Point(40, 40));
          setMinimumSize(new java.awt.Dimension(884, 875));
          setResizable(false);
          setSize(new java.awt.Dimension(884, 875));
          getContentPane().setLayout(null);

          botonIniciar.setBackground(Color.GREEN);
          botonIniciar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
          botonIniciar.setText("Iniciar");
          botonIniciar.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonIniciar(evt);
               }
          });
          getContentPane().add(botonIniciar);
          botonIniciar.setBounds(40, 630, 80, 30);

          botonPuerto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
          botonPuerto.setText("Puerto");
          botonPuerto.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonPuerto(evt);
               }
          });
          getContentPane().add(botonPuerto);
          botonPuerto.setBounds(40, 730, 80, 30);

          botonIP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
          botonIP.setText("IP");
          botonIP.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonIP(evt);
               }
          });
          getContentPane().add(botonIP);
          botonIP.setBounds(40, 680, 80, 30);

          botonSalir.setBackground(new java.awt.Color(255, 0, 51));
          botonSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
          botonSalir.setForeground(new java.awt.Color(255, 255, 255));
          botonSalir.setText("Salir");
          botonSalir.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonSalir(evt);
               }
          });
          getContentPane().add(botonSalir);
          botonSalir.setBounds(40, 780, 80, 30);

          jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

          panelCliente.setEditable(false);
          panelCliente.setCaretColor(new java.awt.Color(255, 255, 255));
          panelCliente.setName(""); // NOI18N
          jScrollPane2.setViewportView(panelCliente);

          getContentPane().add(jScrollPane2);
          jScrollPane2.setBounds(155, 630, 560, 180);

          botonCrear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
          botonCrear.setText("Crear");
          botonCrear.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonCrear(evt);
               }
          });
          getContentPane().add(botonCrear);
          botonCrear.setBounds(750, 630, 80, 30);

          botonCarrera.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
          botonCarrera.setText("Carrera");
          botonCarrera.setToolTipText("");
          botonCarrera.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonCarrera(evt);
               }
          });
          getContentPane().add(botonCarrera);
          botonCarrera.setBounds(750, 780, 80, 30);

          botonMostrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
          botonMostrar.setText("Mostrar");
          botonMostrar.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonMostrar(evt);
               }
          });
          getContentPane().add(botonMostrar);
          botonMostrar.setBounds(750, 730, 80, 30);

          botonBorrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
          botonBorrar.setText("Borrar");
          botonBorrar.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonBorrar(evt);
               }
          });
          getContentPane().add(botonBorrar);
          botonBorrar.setBounds(750, 680, 80, 30);

          jLabelCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          jLabelCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClienteImagenes/cesped.jpg"))); // NOI18N
          jLabelCliente.setRequestFocusEnabled(false);
          getContentPane().add(jLabelCliente);
          jLabelCliente.setBounds(20, 620, 830, 200);

          pack();
     }// </editor-fold>//GEN-END:initComponents

       // CONSTRUCTOR 
       public ClienteMain(String ip, int puerto) {
              initComponents();
              initComponets02();

              // hago una instancia de la clase mensaje para los mensajes en consola
              mensaje = new ClienteMensajes();

              // intancio la variables que definen la conexion con el servidor
              this.ip = ip;
              this.puerto = puerto;

              // iniciarCliente, el estado inicial del boton enceder
              iniciarCliente = false; // false = apagodo
              // boolean apagar encender botones en carrera
              desconectarBotones = false; // true = encendidos
              
       }

     
       
       
       
              
       // METODOS
       
       // creo mis propios componentes sin el disenio o automatico
       private void initComponets02() {

              animal = new javax.swing.JLabel[8];

              for (int i = 0; i < 8; i++) {
                     animal[i] = new javax.swing.JLabel();
                     animal[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClienteImagenes/animal01.png")));
              }

          animal[7].setBounds(70, 511, 55, 76);
          animal[6].setBounds(70, 440, 55, 76);
          animal[5].setBounds(70, 368, 55, 76);
          animal[4].setBounds(70, 295, 55, 76);
          animal[3].setBounds(70, 222, 55, 76);
          animal[2].setBounds(70, 148, 55, 76);
          animal[1].setBounds(70, 70, 55, 76);
          animal[0].setBounds(70, 2, 55, 76);
          for (int i = 0; i < 8; i++) {
               animal[i].setVisible(false);
          }

          jLabelPista = new javax.swing.JLabel();
          jLabelPista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClienteImagenes/pista.png")));
          jLabelPista.setBounds(10, 0, 850, 600);
          for (int i = 7; i >= 0; i--) {
               getContentPane().add(animal[i]);
          }
          getContentPane().add(jLabelPista).setVisible(true);
          pack();
          // para auto-scroll del jTextPane
          DefaultCaret caret = (DefaultCaret) panelCliente.getCaret();
          caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
     }

     // para comprobar que el servidor está encendido cuando se pulsa algo
     public boolean comprobarClienteActivo() {

          if (!iniciarCliente) {
               mensaje.mensaje(panelCliente, "El cliente no esta iniciado", Color.red);
          }
          return iniciarCliente;
     }

     // encender cliente
     public void iniciarcliente() {

              if (!iniciarCliente) {
                     iniciarCliente = true;
                     botonIniciar.setBackground(new Color(185,207,230));
                     botonIniciar.setForeground(Color.BLACK);  
                     botonIniciar.setText("Activo");
                     botonIniciar.setEnabled(false);
                     
              }

       }
       
       // extraigo los datos de la tortuga y se los pongo a la "piel" (jlabel)
       public static void setTortuga(Tortuga tortuga) {
            
            String nombre = tortuga.getNombre();
            int dorsal = tortuga.getDorsal();
            boolean visible = tortuga.isVisible();
            int x = tortuga.getX();
            int y = tortuga.getY();
            ClienteMain.animal[dorsal - 1].setLocation(x, y);
            ClienteMain.animal[dorsal - 1].setVisible(visible);
      }   
             
               
 

       // gettet del puerto
       public static int getPuerto() {
              return puerto;
       }

       // gettet de la IP
       public static String getIP() {
              return ip;
       }

       // conectar/desconectar botones
       public static void desconectarBotones() {
            
            botonIP.setEnabled(desconectarBotones);
            botonPuerto.setEnabled(desconectarBotones);
            botonCrear.setEnabled(desconectarBotones);
            botonBorrar.setEnabled(desconectarBotones);
            botonMostrar.setEnabled(desconectarBotones);
            botonCarrera.setEnabled(desconectarBotones);
            desconectarBotones = !desconectarBotones;
       }
      
       
     // Puerto
    private void botonPuerto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPuerto

         int numero;
         String texto;
         
         // introduce puerto
         mensaje.mensaje(panelCliente, "Tu puerto actual es " + puerto, Color.BLACK);
         texto = mensaje.pedirDato(panelCliente, "Introduce el nuevo puerto. \n "
                 + "No puede ser menor de 1024 o mayor de 49161 \n "
                 + "Solo sirve antes de iniciar el cliente", 5);

         // si es escape retorna sin ClienteMensajes.mensaje
         if (texto.equals("null")) {
              return;
         }
         // si está en blanco error
         if (!texto.equals("")) {
              try {
                   numero = Integer.parseInt(texto);
                   // si es menor 1 o mayor de 8 error
                   if ((numero < 1024) || (numero > 49160)) {
                        mensaje.errorDato(panelCliente, "El numero debe estar entre 1024 y 49160", 6);
                        return;
                   }// si no es un numero
              } catch (NumberFormatException e) {
                   mensaje.errorDato(panelCliente, "Eso no es un numero", 6);
                   return;
              }
         } else {
              mensaje.errorDato(panelCliente, "No has introducido nada", 6);
              return;
         }
         // paso el texto a la variable dorsal
         puerto = Integer.valueOf(texto);
         mensaje.mensaje(panelCliente, "Tu puerto actual es " + puerto, Color.GREEN);

    }//GEN-LAST:event_botonPuerto

     // IP
    private void botonIP(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIP

         String  texto, regex;

         // introduce ip
         mensaje.mensaje(panelCliente, "Tu ip actual es " + ip, Color.BLACK);
         texto = mensaje.pedirDato(panelCliente, "Introduce la nueva IP \n con un formato "
                 + "decimal \n XXX.XXX.XXX.XXX \n "
                 + "Solo sirve antes de iniciar el cliente", 3);

         // si es escape retorna sin ClienteMensajes.mensaje
         if (texto.equals("null")) {
              return;
         }

         // si esta en blanco error
         if (texto.equals("")) {
              mensaje.errorDato(panelCliente, "No has introducido nada", 4);
              return;
         }

         // compruebo que corresponde al patron de una IP
         try {
              regex = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$";
              Pattern pattern = Pattern.compile(regex);
              Matcher matcher = pattern.matcher(texto);

              // si hay una coincidencia lo dice (boolean)
              if ((matcher.find())) {
                   // comprueba los grupos de octetos
                   String octeto[] = new String[]{"", "", "", ""};
                   int cont = 0;
                   char letra = ' ';// inicializar char con comillas simples

                   //
                   for (int i = 0; i < texto.length(); i++) {
                        letra = texto.charAt(i);
                        if (letra == ".".charAt(0)) {
                             // compruebo que el octecto>0 && <255
                             if ((Integer.parseInt(octeto[cont]) < 0) || (Integer.parseInt(octeto[cont]) > 255)) {
                                  mensaje.errorDato(panelCliente, "Los octetos no pueden ser mayores de 255 o menores de 0", 4);
                                  return;
                             }
                             cont++;
                        } else {
                             octeto[cont] += letra;
                        }
                   }
                   octeto[cont] += letra;

                   ip = texto;
                   mensaje.mensaje(panelCliente, "Tu ip actual es " + ip, Color.GREEN);
              } else {
                   mensaje.errorDato(panelCliente, "No has puesto la IP en formato correcto", 4);
              }
         } catch (PatternSyntaxException e) {
              mensaje.errorDato(panelCliente, "Error en el formato regex", 4);
         }
    }//GEN-LAST:event_botonIP

     // Salir
       private void botonSalir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalir

            // creo una instancia de Thread con una clase interna anonima
            Thread retardo = new Thread() {
                 @Override
                 public void run() {
                      mensaje.mensaje(ClienteMain.panelCliente, "Apagando el Cliente", Color.BLACK);
                      try {
                           sleep(2000);
                      } catch (InterruptedException ex) {
                           mensaje.mensaje(panelCliente, "Error : " + ex, Color.red);
                      }
                      System.exit(0);
                 }
            };
            retardo.start();
       }//GEN-LAST:event_botonSalir

     // Borrar
       private void botonBorrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrar

            // compruebo que el cliente está iniciado
            if (!comprobarClienteActivo()) {
                 return;
            }
            
            String texto;
            int numero;

            // introduce dorsal
            texto = mensaje.pedirDato(panelCliente, "Introduce el numero del dorsal. \n que quiere dorsal", 7);

            // si es escape retorna sin ClienteMensajes.mensaje
            if (texto.equals("null")) {
                 return;
            }

            // si está en blanco error
            if (!texto.equals("")) {
                 try {
                      numero = Integer.parseInt(texto);
                      // si es menor 1 o mayor de 8 error
                      if ((numero < 1) || (numero > 8)) {
                           mensaje.errorDato(panelCliente, "El dorsal debe estar entre 1 y 8", 8);
                           return;
                      } // si no es un numero
                 } catch (NumberFormatException e) {
                      mensaje.errorDato(panelCliente, "Eso no es un numero", 8);
                      return;
                 }
            } else {
                 mensaje.errorDato(panelCliente, "No has introducido nada", 8);
                 return;
            }

            // ENVIO para borrar ------->
            mensaje.mensaje(ClienteMain.panelCliente, "Solicitando el borrando de la tortuga " + " con dorsal " + numero, Color.BLACK);
            
            clienteOutput = new ClienteOutput(); // instancia de servidor output

            clienteOutput.setObject(String.valueOf(numero)); // creo el objeto que vouy a enviar

            clienteOutput.start(); // activo el hilo y la mando            
       }//GEN-LAST:event_botonBorrar

     // Carrera
       private void botonCarrera(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCarrera
          // compruebo que el cliente está iniciado
          if (!comprobarClienteActivo()){
               return;
          }
            // ENVIO para carrera ------->
            mensaje.mensaje(ClienteMain.panelCliente, "Solicitando una carrera", Color.BLACK);
            
            clienteOutput = new ClienteOutput(); // instancia de servidor output

            clienteOutput.setObject("carrera"); // creo el objeto que vouy a enviar

            clienteOutput.start(); // activo el hilo y la mando    
       }//GEN-LAST:event_botonCarrera

     // Iniciar 
       private void botonIniciar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciar

            iniciarcliente(); // activo boton de encendido

            clienteInput = new ClienteInput(); // instancia de servidor input

            clienteInput.start(); // activo el hilo

       }//GEN-LAST:event_botonIniciar

     // Crear
     private void botonCrear(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrear
          // compruebo que el cliente está iniciado
          if (!comprobarClienteActivo()) {
               return;
          }

          String texto;

          // introduce nombre
          nombre = (String) mensaje.pedirDato(panelCliente, "Introduce un nombre para tu tortuga", 0);

          // si es escape retorna sin MensajeCliente.mensaje
          if (nombre.equals("null")) {
               return;
          }

          // si esta en blanco error
          if (nombre.equals("")) {
               mensaje.errorDato(panelCliente, "No has introducido nada", 2);
               return;
          }

          // introduce dorsal
          texto = (String) mensaje.pedirDato(panelCliente, "Introduce un dorsal entre 1 y 8", 1);

          // si es escape retorna sin mensaje
          if (texto.equals("null")) {
               return;
          }
          // si está en blanco -> error
          if (!texto.equals("")) {
               try {
                    dorsal = Integer.parseInt(texto);
                    // si es menor 1 o mayor de 8 error
                    if ((dorsal < 1) || (dorsal > 8)) {
                         mensaje.errorDato(panelCliente, "El numero debe estar entre 1 y 8", 2);
                         return;
                    } // si no es un numero
               } catch (NumberFormatException e) {
                    mensaje.errorDato(panelCliente, "Eso no es un numero", 2);
                    return;
               }
          } else {
               mensaje.errorDato(panelCliente, "No has introducido nada", 2);
               return;
          }

          // envio tortuga  ---------->
          tortuga = new Tortuga(nombre, dorsal);

          mensaje.mensaje(ClienteMain.panelCliente, "Solicitando la creacion de la tortuga "
                  + nombre + " y dorsal " + dorsal, Color.BLACK);

          clienteOutput = new ClienteOutput(); // instancia de servidor output

          clienteOutput.setObject(tortuga); // coloco la tortuga en output

          clienteOutput.start(); // activo el hilo y la mando

          tortuga = null; // elimino la tortuga

     }//GEN-LAST:event_botonCrear

     // Mostrar
     private void botonMostrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrar
          // compruebo que el cliente está iniciado
          if (!comprobarClienteActivo()){
               return;
          }
            // ENVIO para mostrar ------->
            mensaje.mensaje(ClienteMain.panelCliente, "Solicitando la lista de tortugas", Color.BLACK);
            
            clienteOutput = new ClienteOutput(); // instancia de servidor output

            clienteOutput.setObject("mostrar"); // creo el objeto que vouy a enviar

            clienteOutput.start(); // activo el hilo y la mando            
                                   
     }//GEN-LAST:event_botonMostrar

       
       
       // MAIN
       public static void main(String args[]) {

              try {
                     for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                            if ("Nimbus".equals(info.getName())) {
                                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                   break;
                            }
                     }
              } catch (ClassNotFoundException ex) {
                     java.util.logging.Logger.getLogger(ClienteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (InstantiationException ex) {
                     java.util.logging.Logger.getLogger(ClienteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (IllegalAccessException ex) {
                     java.util.logging.Logger.getLogger(ClienteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                     java.util.logging.Logger.getLogger(ClienteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              }
              //</editor-fold>
              //</editor-fold>

              /* Create and display the form */
              java.awt.EventQueue.invokeLater(new Runnable() {
                     @Override
                     public void run() {
                            new ClienteMain("192.168.1.45", 9999).setVisible(true);
                     }
              });
       }
       
       
       // ATRIBUTOS
       private boolean iniciarCliente; //el estado inicial del boton enceder
       
       private ClienteInput clienteInput; // para recibir objetos
       private ClienteOutput clienteOutput; // para mandar objetos
       
       private Tortuga tortuga;// para enviar una tortuga
       private int dorsal;
       private String nombre;
       
       private static String ip; // estaticas para leerlas con los getter
       private static int puerto; // idem
       
       private static javax.swing.JLabel[] animal; // los 8 label que representan las tortugas en la pista
        
       private javax.swing.JLabel jLabelPista; // el label dela pista 
       private ClienteMensajes mensaje; // declaro mensaje para los mensajes en el textpane
       
       private static boolean desconectarBotones;
       

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private static javax.swing.JButton botonBorrar;
     private static javax.swing.JButton botonCarrera;
     private static javax.swing.JButton botonCrear;
     private static javax.swing.JButton botonIP;
     private javax.swing.JButton botonIniciar;
     private static javax.swing.JButton botonMostrar;
     private static javax.swing.JButton botonPuerto;
     private javax.swing.JButton botonSalir;
     private javax.swing.JLabel jLabelCliente;
     private static javax.swing.JScrollPane jScrollPane2;
     public static javax.swing.JTextPane panelCliente;
     // End of variables declaration//GEN-END:variables
}
