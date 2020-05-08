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
public class Ford_O extends AbsAutomovil_O {

    public Ford_O() {
        super("Ford");
    }

    @Override
    public int precioMedioAutomovil() {
        return 10000000;
    }

    public int numAsientos() {
        return 5;
    }
}
