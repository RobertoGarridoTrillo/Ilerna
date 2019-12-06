package servidor;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.text.DefaultCaret;


public class ServidorMain extends javax.swing.JFrame {

       @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          servidorOutput1 = new servidor.ServidorOutput();
          botonIniciar = new javax.swing.JButton();
          botonPuerto = new javax.swing.JButton();
          botonSalir = new javax.swing.JButton();
          botonIP = new javax.swing.JButton();
          jScrollPane2 = new javax.swing.JScrollPane();
          panelServidor = new javax.swing.JTextPane();
          jLabelServidor = new javax.swing.JLabel();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setTitle("SERVIDOR");
          setFocusable(false);
          setLocation(new java.awt.Point(910, 512));
          setMinimumSize(new java.awt.Dimension(600, 403));
          getContentPane().setLayout(null);

          botonIniciar.setBackground(new java.awt.Color(0, 255, 0));
          botonIniciar.setText("Iniciar");
          botonIniciar.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonIniciar(evt);
               }
          });
          getContentPane().add(botonIniciar);
          botonIniciar.setBounds(440, 50, 80, 30);

          botonPuerto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
          botonPuerto.setText("Puerto");
          botonPuerto.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonPuerto(evt);
               }
          });
          getContentPane().add(botonPuerto);
          botonPuerto.setBounds(440, 200, 80, 30);

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
          botonSalir.setBounds(440, 280, 80, 30);

          botonIP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
          botonIP.setText("I P");
          botonIP.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonIP(evt);
               }
          });
          getContentPane().add(botonIP);
          botonIP.setBounds(440, 120, 80, 30);

          jScrollPane2.setMaximumSize(new java.awt.Dimension(164, 94));
          jScrollPane2.setMinimumSize(new java.awt.Dimension(164, 94));
          jScrollPane2.setPreferredSize(new java.awt.Dimension(164, 94));

          panelServidor.setFocusable(false);
          jScrollPane2.setViewportView(panelServidor);

          getContentPane().add(jScrollPane2);
          jScrollPane2.setBounds(60, 50, 360, 260);

          jLabelServidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ServidorImagenes/cesped02.jpg"))); // NOI18N
          getContentPane().add(jLabelServidor);
          jLabelServidor.setBounds(30, 30, 520, 300);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     
     
       // CONSTRUCTOR 
       public ServidorMain(String ip, int puerto) {
              initComponents();
              initComponents02();

              // hago una instancia de la clase mensaje para los mensajes en consola
              mensaje = new ServidorMensajes();

             // intancio la variables que definen la conexion con el servidor
              ServidorMain.ip = ip;
              ServidorMain.puerto = puerto;

              // iniciarServidor, el estado inicial del boton enceder
              iniciarServidor = false; // false = apagado
   
       }
 
    


       // METODOS
       
       // creo mis propios componentes sin el disenio automativo
       private void initComponents02() {
              // para auto-scroll del jTextPane
              DefaultCaret caret = (DefaultCaret) panelServidor.getCaret();
              caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
       }
       
       // para comprobar que el servidor está activo cuando se pulsa algo
        public boolean comprobarServidorActivo() {

              if (!iniciarServidor) {
                     mensaje.mensaje(panelServidor, "El servidro no esta iniciado", Color.red);
              }
              return iniciarServidor;             
       }
       
       // encender servidor
       public void iniciarServidor() {

              if (!iniciarServidor) {
                     iniciarServidor = true;
                     botonIniciar.setBackground(new Color(0xb9, 0xcf, 0xe6));
                     botonIniciar.setForeground(Color.BLACK);  
                     botonIniciar.setText("Activo");
                     botonIniciar.setEnabled(false);
                     
              }

       }

       
       
       
       // gettet del puerto
       public static int getPuerto() {
              return puerto;
       }

       // gettet de la IP
       public static String getIP() {
              return ip;
       }

       
       
       
    // Puerto
    private void botonPuerto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPuerto

           int numero;
           String texto;

           // introduce puerto
           mensaje.mensaje(panelServidor, "Tu puerto actual es " + puerto, Color.BLACK);
           texto = mensaje.pedirDato(ServidorMain.panelServidor, "Introduce el nuevo puerto. \n "
                 + "No puede ser menor de 1024 o mayor de 49161 \n "
                 + "Solo sirve antes de iniciar el cliente", 5);

           // si es escape retorna sin mensajeCliente
           if (texto.equals("null")) {
                  return;
           }
           // si está en blanco error
           if (!texto.equals("")) {
                  try {
                         numero = Integer.parseInt(texto);
                         // si es menor 1 o mayor de 8 error
                         if ((numero < 1024) || (numero > 49160)) {
                                mensaje.errorDato(panelServidor, "El numero debe estar entre 1024 y 49160", 6);
                                return;
                         }// si no es un numero
                  } catch (NumberFormatException e) {
                         mensaje.errorDato(panelServidor, "Eso no es un numero", 6);
                         return;
                  }
           } else {
                  mensaje.errorDato(panelServidor, "No has introducido nada", 6);
                  return;
           }
           // paso el texto a la variable puerto
           puerto = Integer.valueOf(texto);
           mensaje.mensaje(panelServidor, "Tu puerto actual es " + puerto, Color.GREEN);

    }//GEN-LAST:event_botonPuerto

    // IP
    private void botonIP(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIP

           String texto, regex;
           
           // introduce ip
           mensaje.mensaje(panelServidor, "Tu ip actual es " + ip, Color.BLACK);
           texto = mensaje.pedirDato(ServidorMain.panelServidor, "Introduce la nueva IP \n con un formato "
                 + "decimal \n XXX.XXX.XXX.XXX \n "
                 + "Solo sirve antes de iniciar el cliente", 3);

           // si es escape retorna sin mensajeCliente
           if (texto.equals("null")) {
                  return;
           }

           // si esta en blanco error
           if (texto.equals("")) {
                  mensaje.errorDato(panelServidor, "No has introducido nada", 4);
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
                                              mensaje.errorDato(panelServidor, "Los octetos no pueden ser mayores de 255 o menores de 0", 4);
                                              return;
                                       }
                                       cont++;
                                } else {
                                       octeto[cont] += letra;
                                }
                         }
                         octeto[cont] += letra;

                         ip = texto;
                         mensaje.mensaje(panelServidor, "Tu ip actual es " + ip, Color.GREEN);
                  } else {
                         mensaje.errorDato(panelServidor, "No has puesto la IP en formato correcto", 4);
                  }
           } catch (PatternSyntaxException e) {
                  mensaje.errorDato(panelServidor, "Error en el formato regex", 4);
           }

    }//GEN-LAST:event_botonIP

       // Salir
       private void botonSalir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalir

              //creo una instancia de Thread con una clase interna anonima
                     Thread retardo = new Thread() {
                     @Override
                     public void run() {
                            mensaje.mensaje(ServidorMain.panelServidor, "Apagando el Servidor", Color.BLACK);
                            try {
                                   sleep(200);
                            } catch (InterruptedException ex) {
                                   mensaje.mensaje(ServidorMain.panelServidor, "Error : " + ex, Color.red);
                            }
                            System.exit(0);
                     }
              };
              retardo.start();
       }//GEN-LAST:event_botonSalir
       
       // Iniciar
       private void botonIniciar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciar
                    
            iniciarServidor(); // activo boton de encendido

            servidorInput = new ServidorInput(); // instancia de servidor input 
            
            servidorInput.start(); //activo el hilo
       
       }//GEN-LAST:event_botonIniciar
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       // MAIN
       public static void main(String args[]) {

              java.awt.EventQueue.invokeLater(new Runnable() {
                     @Override
                     public void run() {
                            // llama al constructor
                            new ServidorMain("192.168.1.45", 9999).setVisible(true);

                     }
              });

       }

       
       
       // ATRIBUTOS
       private boolean iniciarServidor; // el estado inicial del boton enceder
       
       private ServidorInput servidorInput; // para recibir objetos
       private ServidorObjetos servidorObjetos; // para clasificar objetos
       
       private int dorsal;
       private String nombre;
       
       private static String ip; // estaticas para leerlas con los getter
       private static int puerto; // idem
       
       private ServidorMensajes mensaje; // declaro mensaje para los mensajes en el textpan
       
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton botonIP;
     private javax.swing.JButton botonIniciar;
     private javax.swing.JButton botonPuerto;
     private javax.swing.JButton botonSalir;
     private javax.swing.JLabel jLabelServidor;
     private static javax.swing.JScrollPane jScrollPane2;
     public static javax.swing.JTextPane panelServidor;
     private servidor.ServidorOutput servidorOutput1;
     // End of variables declaration//GEN-END:variables
}
