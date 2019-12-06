package practica;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;


public class Main extends javax.swing.JFrame {

 
    public Main() {
        // iniciamos los componentes graficos
        initComponents();
        // INICIAMOS VARIABLES
        contadorEmbarcar = 0;
    }

    
    private void initComponents() {


        jPanel2 = new javax.swing.JPanel();
        
        jLabelAvion = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelCabecera = new javax.swing.JLabel();
        jLabelPasajeros = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMain = new javax.swing.JTextArea();
        jTextFieldPlazas = new javax.swing.JTextField();
        jButtonCrearAvion = new javax.swing.JButton();
        jButtonEmbarcar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(1045, 738));
        setPreferredSize(new java.awt.Dimension(0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(1045, 738));
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        // inicion los arrays de botones
        jBAsiento = new JButton[60];
        int x = 640;;
        int cont = 0;
        for (int y = 20; y <= 440; y +=30){
            for (int i = 0; i < 4; i++){
                switch(i) { case 0: x=640;break;case 1: x=680;break; case 2: x=770;break; case 3: x=810;break; }

                
                // antes he declarado el array de botones, ahora declaro lo que hay dentro de cada uno, osea, botones
            	jBAsiento[cont] = new JButton();
            	// coloco cada asiento con las caracteristicas apropiadas
            	jBAsiento[cont].setBounds(x, y, 30, 21);
            	String texto = String.valueOf((cont<10) ? "0"+cont  : cont);
    			jBAsiento[cont].setText(texto);
    			jBAsiento[cont].setToolTipText("");
    			jBAsiento[cont].setMargin(new java.awt.Insets(1, 1, 1, 1));
    	        jBAsiento[cont].setMaximumSize(new java.awt.Dimension(19, 21));
    	        jBAsiento[cont].setMinimumSize(new java.awt.Dimension(19, 21));
    			jBAsiento[cont].setEnabled(false);
    	        jPanel2.add(jBAsiento[cont]);
    			jBAsiento[cont].setMargin(new java.awt.Insets(1, 1, 1, 1));
                cont++;
            }
        }
                
       
        // inicio el diseño del frame

        jLabelAvion.setBackground(new java.awt.Color(102, 255, 153));
        jLabelAvion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAvion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica/avion.png"))); // NOI18N
        jLabelAvion.setLabelFor(this);
        jLabelAvion.setToolTipText("");
        jLabelAvion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabelAvion);
        jLabelAvion.setBounds(470, 0, 530, 480);

        jTextAreaMain.setColumns(20);
        jTextAreaMain.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextAreaMain.setLineWrap(true);
        jTextAreaMain.setRows(5);
        jTextAreaMain.setName("jTextAreaMain"); // NOI18N
        jScrollPane1.setViewportView(jTextAreaMain);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 140, 440, 328);

        jButtonEmbarcar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEmbarcar.setText("Embarcar");
        jButtonEmbarcar.setEnabled(false);
        jButtonEmbarcar.setMaximumSize(new java.awt.Dimension(122, 41));
        jButtonEmbarcar.setMinimumSize(new java.awt.Dimension(122, 41));
        jButtonEmbarcar.setPreferredSize(new java.awt.Dimension(122, 41));
        jButtonEmbarcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jButtonEmbarcarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEmbarcar);
        jButtonEmbarcar.setBounds(20, 60, 180, 50);

        jButtonCrearAvion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCrearAvion.setText("Enviar");
        jButtonCrearAvion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCrearAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearAvionActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCrearAvion);
        jButtonCrearAvion.setBounds(270, 60, 190, 50);

        jTextFieldPlazas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPlazas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextFieldPlazas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPlazasFocusGained(evt);
            }
        });
        jTextFieldPlazas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPlazasKeyPressed(evt);
            }
        });
        jPanel2.add(jTextFieldPlazas);
        jTextFieldPlazas.setBounds(270, 20, 190, 30);

        jLabelPasajeros.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelPasajeros.setText("Numero de pasajeros");
        jLabelPasajeros.setPreferredSize(new java.awt.Dimension(141, 20));
        jPanel2.add(jLabelPasajeros);
        jLabelPasajeros.setBounds(21, 20, 180, 20);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 210, 1000, 478);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelCabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica/CabeceraAvion.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCabecera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 11, 1005, 184);

        pack();
        setLocationRelativeTo(null);
    } 
    	
   
    // COMPRUEBA LOS DATOS DE ENTRADA E INSTANCIA EL AVION
    // METODO PARA COMPROBAR QUE LOS DATOS SON CORRECTOS Y CREAR EL AVION
    private void crearAvion() {
        // LEO EL VALOR DEL JTEXTFIELDPLAZAS, SI ESTA EN BLANCO O NO ES UN NUMERO MANDO 
        // O ES MENOR DE 1 O MAYOR DE 100 MOSTRAR UN ERROR POR JLABELERROR

        String texto = jTextFieldPlazas.getText();

        if (texto.equals("")) {
            mensaje("No has introducido ningun número");
        }   else {
            try {
                numeroPlazas = Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                mensaje("No es un numero");
                return;
            }
            if ((numeroPlazas<2) || (numeroPlazas>60)) {
                mensaje("Plazas entre 2 y 60");
                return;    
            }
            // SI HA LLEGADO HASTA AQUI CREO UNA INSTANCIA DE AVION
            jTextAreaMain.setText("");
            avion = new Avion(numeroPlazas);
        }
    }
    
    
    
    // ESCRIBE UN MENSAJE POR LA CONSOLA GRAFICA
       // METODO ESTATICO QUE MUESTRA EN EL JTEXTAREA EL STRING PASADO POR PARAMETRO
    public static void mensaje (String texto) {
            
        String textoMain = jTextAreaMain.getText();
        jTextFieldPlazas.setText("");
        jTextAreaMain.setText(textoMain + texto + "\n");
    }   

    
    // ACTIVA EL BOTON DE EMBARQUE Y LIMPIA EL RESTO
    // ACTIVA EL BOTON DE EMBARQUE
    public static void desactivarEnviar(){
        jButtonCrearAvion.setEnabled(false);
        jButtonEmbarcar.setEnabled(true);
    }
    
    
    // ACTIVA EL BOTON DE ENVIAR Y LIMPIA EL RESTO
    // DESACTIVA EL BOTON DE EMBARQUE
    public static void activarEnviar(){
        jButtonCrearAvion.setEnabled(true);
        jButtonEmbarcar.setEnabled(false);

    }
    
    
    
    // ACTIVA EL BOTON QUE SIMULAN LOS PASAJEROS Y LE PONE UN TEXTO
    // ACTIVA CADA PASAJERO INDIVIDUALMENTE PARA ENVIARLO
    public static void activarPasajero(int asientoEmbarque, int asientoEmbarqueAzar) {
    	
    	jBAsiento[asientoEmbarqueAzar].setText((String.valueOf(asientoEmbarque)));
    	jBAsiento[asientoEmbarqueAzar].setBorder(BorderFactory.createLoweredBevelBorder());
    	
    	if (asientoEmbarque == asientoEmbarqueAzar) {
    		jBAsiento[asientoEmbarqueAzar].setBackground(Color.green);
    	} else {
    		jBAsiento[asientoEmbarqueAzar].setBackground(Color.red);
    	}
    }
    
    
    // MANEJADOR DE EVENTOS DEL JBUTTONCREARAVION
    private void jButtonCrearAvionActionPerformed(java.awt.event.ActionEvent evt) {
       
    	// Ha crear avion se puede llegar tanto pulsado el boton como pulsando enter
        crearAvion();
    }
  
    
    // MANEJADOR DE EVENTOS DEL JBUTTONEMBARCAR
    private void jButtonEmbarcarActionPerformed(java.awt.event.ActionEvent evt) {

    	if (contadorEmbarcar < numeroPlazas)
    		contadorEmbarcar = Avion.embarque(contadorEmbarcar);
    	
    }
    
	
	// MANEJADOR DE EVENTOS DEL JTEXTFIELDPLAZAS CUANDO GANA EL FOCO
    private void jTextFieldPlazasFocusGained(java.awt.event.FocusEvent evt) {
        
        // CUANDO EL JTEXTFIELD GANA EL FOCO LIMPIA SU CONTENIDO Y EL DE JLABELERROR
        jTextFieldPlazas.setText("");
        jTextAreaMain.setText("");
        // desactivo y limpio el embarque
        activarEnviar();
        contadorEmbarcar = 0;
        for (int i = 0; i <=59; i++) {
			jBAsiento[i].setBackground(new Color(240,240,240,255));
		}
     
    }

    
	// MANEJADOR DE EVENTOS DEL JTEXTFIELDPLAZAS CUANDO SE PRESIONA UNA TECLA
    private void jTextFieldPlazasKeyPressed(java.awt.event.KeyEvent evt) {
    	if (jButtonCrearAvion.isEnabled()) {
    		if(evt.getKeyCode()==KeyEvent.VK_ENTER){
    			crearAvion();
    		} else if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
    			System.exit(0);
    		} else {
                // DESACTIVO EL BOTON DE EMBARQUE Y ACTIVO EL DE ENVIAR
                activarEnviar();
    		}
    	}
    }
    
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    
    // ATRIBUTOS

    private int numeroPlazas;
    private Avion avion;
    private int contadorEmbarcar;
    
    private static JButton jBAsiento[];
    
    
    private static javax.swing.JButton jButtonCrearAvion;
    private static javax.swing.JButton jButtonEmbarcar;
    
    private javax.swing.JLabel jLabelAvion;
    private javax.swing.JLabel jLabelCabecera;
    private javax.swing.JLabel jLabelPasajeros;
    
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextAreaMain;
    private static javax.swing.JTextField jTextFieldPlazas;

}
