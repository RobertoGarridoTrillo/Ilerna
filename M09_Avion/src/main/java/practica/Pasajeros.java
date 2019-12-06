package practica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Pasajeros {

    // constructor
    public Pasajeros(int numeroPasajeros){
        
        // Creo la lista de pasajeros. Elijo un colection de la clase ArrayList porque permite desordenarlos y ordenarlos
        // Permite los elementos duplicados aunque para este ejercico no importa. Si fuera el caso usaria un HashSet

        // Creo la lista con el numero de pasajeros pasados por parametro
        listaPasajeros = new ArrayList<>();
        // esta funcion genera una lista de X pasajeros con sus nombres
        llenarListaPasajeros(numeroPasajeros);
        // elimino el espacio sin usar del array list
        listaPasajeros.trimToSize();
        // esta funcion desordena la lista de pasajeros.
        desordenar();
        // esta funcion borral la tarjeta de embarque del pasajero cero
        tarjetaPerdida();
        
    }
    
    

    // metodos
    private boolean tieneMasPasajeros(Iterator<Pasajero> it) {
        return it.hasNext();
    }
    
    
    private String siguientePasajero(Iterator<Pasajero> it) {
        return it.next().toString();
    }
    
    
    private boolean addPasajero(Pasajero pasajero) {
    try {
        listaPasajeros.add(pasajero);
    } catch (Exception e) {
        Main.mensaje("Hubo un error al añadir este pasajero");
        return false;
    }
    return true;
    } 

    
    private void llenarListaPasajeros(int numeroPasajeros) {
        
        Main.mensaje("Creando la lista de pasajeros");
        
        for (int i = 0; i < numeroPasajeros; i++) {
            String nombrePasajero = "Pasajero " + ((i<10) ? "0" : "");
            Pasajero pasajero = new Pasajero(nombrePasajero +String.valueOf(i), i, true);
            addPasajero(pasajero);
        } 
        // muestro la lista de pasajeros, para ello creo un iterator que recorrera la lista de pasajeros
        Iterator<Pasajero> it = listaPasajeros.iterator();
        String siguientePasajero;
        // compruebo si hay mas pasajeros 
        while (tieneMasPasajeros(it)) {
            siguientePasajero = siguientePasajero(it);
            Main.mensaje(siguientePasajero);
        }
        Main.mensaje("Correcto \n");
    }
        
    
    private void desordenar() {
        Main.mensaje("Desordenando lista de pasajeros");
        // Como es Collection.shuffle solo trabaja con List, pasa SetTree a un ArrayList, desordeno éste, 
        // luego vacio el SetTree y por ultimo añado el ArrayList desordenado al SetTree
        Collections.shuffle(listaPasajeros);
        Iterator<Pasajero> it = listaPasajeros.iterator();
            // muestro el pasajero
            while (it.hasNext()) {
                Main.mensaje(it.next().toString());
            }           
       Main.mensaje("Correcto \n");
    }
    
    // PIERDE LA TARJETA DE EMBARQUE DEL PRIMER PASAJERO
    private void tarjetaPerdida() {
        
        Main.mensaje("Perdiendo tarjeta embarque del pasajero cero");
        
        Pasajero pasajeroCero = listaPasajeros.get(0);
        pasajeroCero.setTarjetaEmbarque(false);
        listaPasajeros.set(0, pasajeroCero);
        
        Main.mensaje(listaPasajeros.get(0).toString());
        Main.mensaje("Correcto");
    }
    

    public ArrayList<Pasajero> getListaPasajeros(){
        return listaPasajeros;
    }
    
    
    // atributos
    private ArrayList<Pasajero> listaPasajeros;
}
