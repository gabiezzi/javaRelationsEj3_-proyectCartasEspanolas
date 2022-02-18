package main;

import entity.BarajaEspanolaEntidad;
import implement.BarajaEspanolaImplementService;

public class mainCartasEspanolas {
public static void main(String[] args) {


    BarajaEspanolaImplementService nuevoServiceBaraja = new BarajaEspanolaImplementService();

    
    BarajaEspanolaEntidad nuevaBaraja = nuevoServiceBaraja.crearBarajaEspanola();
    
    System.out.println(nuevoServiceBaraja.mostrarCartas(nuevaBaraja));
    
    nuevoServiceBaraja.barajar(nuevaBaraja);
    
    System.out.println(nuevoServiceBaraja.mostrarCartas(nuevaBaraja));
    
    
    


    }
    
}
