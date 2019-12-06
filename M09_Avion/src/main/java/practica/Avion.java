package practica;

import java.util.ArrayList;
import java.util.Iterator;

public class Avion {
    
	// CONSTRUCTOR
    public Avion(int numeroPlazas) {
        
        numeroPasajeros = numeroPlazas;
        
        embarque(-1);
    }
    
    // PROCESO DE EMBARQUE 
    public static int embarque(int contadorEmbarque) {
    	
    	// si es a primera vez que hago el embarque inicio esta parte 
    	if (contadorEmbarque == -1) {
    	
    		// Creo una instancia de Pasajeros y le paso el numero de pasajeros
            Pasajeros pasajeros =new Pasajeros(numeroPasajeros);
            
    		// Obtengo la lista de pasajeros
            listaPasajeros = pasajeros.getListaPasajeros();
            
    		// Creo un iterator
            it = listaPasajeros.iterator();

            // creo un array para saber si hay asientos libres e inicio en true
    		asiento = new boolean[numeroPasajeros];
    		for (int i = 0; i < numeroPasajeros; i++) asiento[i] = true;

            // DESACTIVO EL BOTON DE ENVIAR
    		Main.desactivarEnviar();
       
    		Main.mensaje("");
    		return contadorEmbarque++;
    	}
     	
        // EXTRAIGO LOS DATOS DEL PASAJERO del iterator
    	Pasajero pasajero = it.next();
    	
    	String nombreEmbarque = pasajero.getNombre();
        int asientoEmbarque = pasajero.getAsiento();
        boolean tarjetaEmbarque = pasajero.getTarjetaEmbarque();
            
        // MUESTRO LOS DATOS DEL PASAJERO
    	Main.mensaje("Embarcando el " + nombreEmbarque + " con asiento " + asientoEmbarque);
        // COMPRUEBO SI TIENE TARJETA DE EMBARQUE
        if (tarjetaEmbarque) { // si tiene tarjeta de embarque
        		
        	if (asiento[asientoEmbarque]) { // si el asiento está libre
        			
        		asientoEmbarqueAzar = asientoEmbarque; // no hace falta buscar un asiento al azar
        		asiento[asientoEmbarque] = false;
               	Main.mensaje("Tiene asiento libre, sigue con su asiento " + asientoEmbarqueAzar);

        		
        	} else { // si el asiento no está libre le busco una un asiento libre al azar
        		
        		asientoEmbarqueAzar= asientoEmbarqueAzar(numeroPasajeros);
        		Main.mensaje("No tiene asiento libre, se le asigna el asiento " + asientoEmbarqueAzar);
        	}
        		
            	
        	
        } else { // si no tiene tarjeta de embarque le busco uno libre al azar
        		
    		asientoEmbarqueAzar = asientoEmbarqueAzar(numeroPasajeros);
    	    Main.mensaje("No tiene tarjeta de embarque, se le asigna el asiento " + asientoEmbarqueAzar);
    	}
        	
       Main.mensaje("");
        	
        // ACTIVO EL PASAJERO
        Main.activarPasajero(asientoEmbarque, asientoEmbarqueAzar);
        	
        contadorEmbarque++;
        if (contadorEmbarque == numeroPasajeros) {
        	if (asientoEmbarque == asientoEmbarqueAzar) {
            	Main.mensaje("El último pasajero está sentado su sitio"); 
        	} else {
            	Main.mensaje("El último pasajero no está sentado su sitio"); 
        	}
        }
        
        return contadorEmbarque;
    	
    }
           
    
    
    // ASIGNA UN ASIENTO AL AZAR
    private static int asientoEmbarqueAzar(int numeroPasajeros) {
    	
    	do {
    	
    		asientoEmbarqueAzar = (int) (Math.random()*(numeroPasajeros-1));
    		
    	} while (asiento[asientoEmbarqueAzar] == false); 
    	
    	asiento[asientoEmbarqueAzar] = false;

    	return asientoEmbarqueAzar;
    }

      
    private static ArrayList<Pasajero> listaPasajeros;
    private static Iterator<Pasajero> it;
    private static int numeroPasajeros;    
    private static boolean asiento[];
    private static int asientoEmbarqueAzar;
}
