/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.LinkedHashSet;

/**
 *
 * @author Gabi
 */
public class BarajaEspanolaEntidad {
    
    LinkedHashSet<CartaEntidad> cartasEspanolas;

    public BarajaEspanolaEntidad(LinkedHashSet<CartaEntidad> cartasEspanolas) {
        this.cartasEspanolas = cartasEspanolas;
    }

    public BarajaEspanolaEntidad() {
    }

    public LinkedHashSet<CartaEntidad> getCartasEspanolas() {
        return cartasEspanolas;
    }

    public void setCartasEspanolas(LinkedHashSet<CartaEntidad> cartasEspanolas) {
        this.cartasEspanolas = cartasEspanolas;
    }

    @Override
    public String toString() {
        return "BarajaEspanolaEntidad{" + "cartasEspanolas=" + cartasEspanolas + '}';
    }
    
    
    
    
    
}
