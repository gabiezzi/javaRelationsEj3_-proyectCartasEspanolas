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
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Gabi
 */
public class BarajaEspanolaImplementService implements BarajaEspanolaService {

    Scanner sc;

    CartaImplementService nuevoServicioCarta;

    public BarajaEspanolaImplementService() {

        sc = new Scanner(System.in);
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
    public BarajaEspanolaEntidad crearMonton() {

        LinkedHashSet<CartaEntidad> cartasMonton = new LinkedHashSet<>();

        return new BarajaEspanolaEntidad(cartasMonton);
    }

    @Override
    public String barajar(BarajaEspanolaEntidad nuevaBaraja) {

        ArrayList<CartaEntidad> cartaLista = new ArrayList();

        cartaLista.addAll(nuevaBaraja.getCartasEspanolas());

        Collections.shuffle(cartaLista);

        LinkedHashSet<CartaEntidad> nuevaBarajaOrdenada = new LinkedHashSet();
        nuevaBarajaOrdenada.addAll(cartaLista);

        nuevaBaraja.setCartasEspanolas(nuevaBarajaOrdenada);

        return mostrarCartas(nuevaBaraja.getCartasEspanolas());
    }

    public String cartasDisponibles(LinkedHashSet<CartaEntidad> cartasEspanolas) {

        String cantDisponible = "La cantidad disponible de cartas: \n";

        return cantDisponible + " " + cartasEspanolas.size();

    }

    @Override
    public String darCartas(int cartasPedidas, LinkedHashSet<CartaEntidad> cartasEspanolas, LinkedHashSet<CartaEntidad> cartasMonton) {

        int i = 0;

        String cartasDadas = "Las cartas dadas son : \n";

        Iterator<CartaEntidad> it = cartasEspanolas.iterator();

        while (it.hasNext()) {
            CartaEntidad next = it.next();
            if (i < cartasPedidas) {

                cartasMonton.add(next);
                cartasDadas += next + "\n";
                it.remove();
                
            }
            i++;
        }

        return cartasDadas;
    }

    @Override
    public String siguienteCarta(LinkedHashSet<CartaEntidad> cartasEspanolas, LinkedHashSet<CartaEntidad> cartasMonton) {

        String cartaSiguiente = "La siguiente carta es : ";

        for (CartaEntidad cartaUnitaria : cartasEspanolas) {
            cartaSiguiente += cartaUnitaria;
            cartasMonton.add(cartaUnitaria);
            cartasEspanolas.remove(cartaUnitaria);
            return cartaSiguiente;

        }

        return cartaSiguiente + "no hay mas cartas en el mazo!.";
    }

    @Override
    public String mostrarCartas(LinkedHashSet<CartaEntidad> cartasEspanolas) {

        String imprimirCartas = "La lista de cartas es la siguiente: \n";

        for (CartaEntidad unitarioCarta : cartasEspanolas) {

            imprimirCartas += unitarioCarta.toString() + "\n";

        }

        return imprimirCartas;
    }

    @Override
    public String cartasMonton(LinkedHashSet<CartaEntidad> cartasMonton) {

        String cartasDescartadas = "Las cartas del monton son : \n";

        Iterator<CartaEntidad> it = cartasMonton.iterator();

        while (it.hasNext()) {
            CartaEntidad next = it.next();

            cartasDescartadas += next + "\n";

        }

        if (cartasMonton.isEmpty()) {

            return cartasDescartadas += " No hay cartas en el monton!";

        }

        return cartasDescartadas;
    }

    @Override
    public void menu() {

        int opt = 0;

        BarajaEspanolaEntidad cartasMazo = crearBarajaEspanola();
        BarajaEspanolaEntidad cartasMonton = crearMonton();

        do {

            System.out.println("-----	Menu	-----\n"
                    + "\n"
                    + "1.	Barajar.\n"
                    + "2.	Siguiente carta.\n"
                    + "3.	Dar cartas.\n"
                    + "4.	Cartas disponibles (num).\n"
                    + "5.	Mostrar cartas mazo.\n"
                    + "6.	Mostrar cartas monton.\n"
                    + "7.	Salir");

            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.println(barajar(cartasMazo));
                    break;

                case 2:

                    System.out.println(siguienteCarta(cartasMazo.getCartasEspanolas(), cartasMonton.getCartasEspanolas()));

                    break;

                case 3:

                    System.out.println("cuantas cartas quiere retirar del mazo?");
                    int cartasPedidas = sc.nextInt();

                    System.out.println(darCartas(cartasPedidas, cartasMazo.getCartasEspanolas(), cartasMonton.getCartasEspanolas()));

                    break;

                case 4:
                    System.out.println(cartasDisponibles(cartasMazo.getCartasEspanolas()));

                    break;

                case 5:

                    System.out.println(mostrarCartas(cartasMazo.getCartasEspanolas()));

                    break;

                case 6:
                    System.out.println(cartasMonton(cartasMonton.getCartasEspanolas()));
                    break;

                case 7:
                    System.out.println("Desea salir?");
                    String optQuit = sc.next();
                    if (!optQuit.equalsIgnoreCase("y")) {
                        opt = 0;
                    }

                    break;

            }
        } while (opt != 7);

        System.out.println("Operacion finalizada");
    }

}
