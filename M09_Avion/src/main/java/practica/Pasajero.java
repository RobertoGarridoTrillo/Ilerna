
package practica;

import java.util.Objects;

// IMPLEMENTO COMPARABLE Y SOBREESCRIBO COMPARTETO PARA PODER USAR EL METODO SORT().
public class Pasajero implements Comparable<Pasajero>{
    public Pasajero(String nombre, int asiento, boolean tarjetaEmbarque){
        this.nombre = nombre;
        this.asiento = asiento;
        this.tarjetaEmbarque = tarjetaEmbarque;
    }
    
     
    
// getters y setters
public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
        this.nombre = nombre;
}

public int getAsiento() {
    return asiento;
}

public void setAsiento(int asiento) {
    this.asiento = asiento;
}

public boolean getTarjetaEmbarque() {
    return tarjetaEmbarque;
}

public void setTarjetaEmbarque(boolean perdidaTarjeta) {
    this.tarjetaEmbarque = perdidaTarjeta;
}



// sobreescribo el metodo toString para que me devuelva las varibles de campo en forma de cadena
@Override
public String toString() {
    String salida = "Nombre= " + nombre + ", asiento= " + asiento + ", tarjeta de embarque= " + tarjetaEmbarque;
    return salida;
}

// sobreescribo el metodo equals y hashcode para que no repita objetos basado
// en el nombre y el numero de asiento

@Override
public int hashCode() {
    int hash = 7;
    hash = 59 * hash + Objects.hashCode(this.nombre);
    return hash;
}

@Override
public boolean equals(Object obj) {
    if (this == obj) {
    return true;
    }
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final Pasajero other = (Pasajero) obj;
    if (!Objects.equals(this.nombre, other.nombre)) {
        return false;
    }
    return true;
}
    
// sobreescribo el metodo compareTo de la interfece Comparable para que lo use sort para desordenar
@Override
public int compareTo(Pasajero o) {
    return (this.nombre.compareTo(o.nombre));
}


   
// atributos
private String nombre;
private int asiento;
private boolean tarjetaEmbarque;

 


    
}