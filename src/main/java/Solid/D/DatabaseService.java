/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solid.D;

/**
 *
 * @author eduaralexis
 */
public class DatabaseService implements IConexion {
    
    private Dato dato;

    @Override
    public Dato getDatos() { 
        if(dato == null){
           dato = new Dato("Datos DatabaseService");
        }
        return dato;
    }
 
    @Override
    public void setDatos(Dato dato) {
        this.dato = dato;
    }
}
