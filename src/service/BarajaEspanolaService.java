/*
barajar(): cambia de posición todas las cartas aleatoriamente.
•
siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya
más o se haya llegado al final, se indica al usuario que no hay más cartas.
•
cartasDisponibles(): indica el número de cartas que aún se puede repartir.
•
darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número
de cartas. En caso de que haya menos cartas que las pedidas, no devolveremos
nada, pero debemos indicárselo al usuario.
•
cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
indicárselo al usuario
•
mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta
y luego se llama al método, este no mostrara esa primera carta.
 */
package service;

import entity.BarajaEspanolaEntidad;

/**
 *
 * @author Gabi
 */
public interface BarajaEspanolaService {

    public BarajaEspanolaEntidad crearBarajaEspanola();

    public String barajar(BarajaEspanolaEntidad nuevaBaraja);
    //    public String siguienteCarta();
    public String cartasDisponibles(BarajaEspanolaEntidad nuevaBaraja) ; 
//    public String darCartas();
    
    //    public String cartasMonton();


    public String mostrarCartas(BarajaEspanolaEntidad nuevaBaraja);

}
