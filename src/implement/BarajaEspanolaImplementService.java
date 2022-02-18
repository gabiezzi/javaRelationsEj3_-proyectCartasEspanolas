/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.BarajaEspanolaEntidad;
import entity.CartaEntidad;
import java.util.Collections;
import java.util.LinkedHashSet;
import service.BarajaEspanolaService;
import java.util.ArrayList;

/**
 *
 * @author Gabi
 */
public class BarajaEspanolaImplementService implements BarajaEspanolaService {

    CartaImplementService nuevoServicioCarta;

    public BarajaEspanolaImplementService() {

        nuevoServicioCarta = new CartaImplementService();
    }

    @Override
    public BarajaEspanolaEntidad crearBarajaEspanola() {

        LinkedHashSet<CartaEntidad> cartasEspanolas = new LinkedHashSet<>();

        String[] palos = {"copa", "oro", "espada", "basto"};

        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 13; i++) {

                if (!(i == 8 || i == 9)) {

                    cartasEspanolas.add(nuevoServicioCarta.nuevaCarta(palos[j], i));

                }

            }
        }

        return new BarajaEspanolaEntidad(cartasEspanolas);
    }

    @Override
    public String mostrarCartas(BarajaEspanolaEntidad nuevaBaraja) {

        String imprimirCartas = "La lista de cartas es la siguiente: \n";

        for (CartaEntidad unitarioCarta : nuevaBaraja.getCartasEspanolas()) {

            imprimirCartas += unitarioCarta.toString() + "\n";

        }

        return imprimirCartas;
    }

    @Override
    public String barajar(BarajaEspanolaEntidad nuevaBaraja) {

        ArrayList<CartaEntidad> cartaLista = new ArrayList();

        cartaLista.addAll(nuevaBaraja.getCartasEspanolas());

        Collections.shuffle(cartaLista);

        LinkedHashSet<CartaEntidad> nuevaBarajaOrdenada = new LinkedHashSet();
        nuevaBarajaOrdenada.addAll(cartaLista);

        nuevaBaraja.setCartasEspanolas(nuevaBarajaOrdenada);

        return mostrarCartas(nuevaBaraja);
    }
    
    public String cartasDisponibles(BarajaEspanolaEntidad nuevaBaraja) {
        
        String cantDisponible = "La cantidad disponible de cartas: \n";
        
        return cantDisponible +" "+ nuevaBaraja.getCartasEspanolas().size() ;
        
    }
}

//    public String siguienteCarta();
//    public String cartasDisponibles();
//    public String darCartas();
//    public String cartasMonton();
//    public String mostrarCartas(BarajaEspanolaEntidad nuevaBaraja);
