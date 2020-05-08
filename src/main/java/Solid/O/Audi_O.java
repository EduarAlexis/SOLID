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
public class Audi_O extends AbsAutomovil_O {  

    public Audi_O() {
        super("Audi");
    }

    @Override
    public int precioMedioAutomovil() { return 8500000; }
    
    public int numAsientos() {
        return 4;
    }
}