/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Gabi
 */
public class CartaEntidad {
    
    private String palo;
    private int numero;

    public CartaEntidad(String palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public CartaEntidad() {
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Carta [" + numero + " , " + palo + ']';
    }
    
    
    
}
