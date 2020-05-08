/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solid.O;

/**
 *
 * @author eduaralexis
 */
public abstract class AbsAutomovil_O {

    private String marca;

    public AbsAutomovil_O(String marca) {
        this.marca = marca;
    }

    public String getMarcaAutomovil() {
        return marca;
    }

    public abstract int precioMedioAutomovil();
}
