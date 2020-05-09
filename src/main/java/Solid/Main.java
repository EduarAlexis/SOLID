/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solid;

import Solid.D.APIService;
import Solid.D.AccesoADatos;
import Solid.D.DatabaseService;
import Solid.D.IConexion;
import Solid.I.IAveNadadora;
import Solid.I.IAveVoladora;
import Solid.I.Loro;
import Solid.I.Pinguino;
import Solid.I.Tucan;
import Solid.L.AbsAutomovil_L;
import Solid.L.Audi_L;
import Solid.L.Ford_L;
import Solid.L.Mercedes_L;
import Solid.L.Renault_L;
import Solid.O.AbsAutomovil_O;
import Solid.O.Audi_O;
import Solid.O.Ford_O;
import Solid.O.Mercedes_O;
import Solid.O.Renault_O;
import Solid.S.Automovil;
import Solid.S.AutomovilDB;

/**
 *
 * @author eduaralexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("****************************");
        System.out.println("Principio de responsabilidad unica");
        System.out.println("****************************");
        Automovil[] arrayAutomoviles_S = {
            new Automovil("Renault"),
            new Automovil("Audi")
        };

        System.out.println("Funcionalidad mostrar Automoviles");
        imprimirPrecioMedioAutomovil_SRP(arrayAutomoviles_S);

        System.out.println("Funcionalidad persistencia Automoviles");

        AutomovilDB automovilDB = new AutomovilDB();
        automovilDB.guardarAutomovilDB(arrayAutomoviles_S[0]);
        automovilDB.eliminarAutomovilDB(arrayAutomoviles_S[1]);
        System.out.println();
        
        System.out.println("****************************");
        System.out.println("Principio de abierto cerrado");
        System.out.println("****************************");
        AbsAutomovil_O[] arrayAutomoviles_O = {
            new Renault_O(),
            new Audi_O(),
            new Mercedes_O(),
            new Ford_O()
        };
        
        System.out.println("Principio de abierto cerrado no se ccumple");
        imprimirPrecioMedioAutomovil(arrayAutomoviles_O);
        
        System.out.println("Principio de abierto cerrado se cumple");
        imprimirPrecioMedioAutomovil_OCP(arrayAutomoviles_O);
        
        System.out.println("****************************");
        System.out.println("Principio de Liskov");
        System.out.println("****************************");

        imprimirNumAsientos(arrayAutomoviles_O);
        System.out.println();
        AbsAutomovil_L[] arrayAutomoviles_L = {
            new Renault_L(),
            new Audi_L(),
            new Mercedes_L(),
            new Ford_L()
        };
        imprimirNumAsientos_LSP(arrayAutomoviles_L);

        System.out.println("****************************");
        System.out.println("Principio de segregacion de interfaz");
        System.out.println("****************************");

        IAveNadadora aveNadadora = new Pinguino();
        aveNadadora.nadar();

        IAveVoladora aveVoladora = new Loro();
        aveVoladora.volar();

        aveVoladora = new Tucan();
        aveVoladora.volar();
        System.out.println();

        System.out.println("****************************");
        System.out.println("Principio de Inversión de dependencias");
        System.out.println("****************************");
        //cada servicio que quiera utilizar el AccesoADatos deberá implementar la interfaz Conexión
        IConexion conexionApi = new APIService();
        AccesoADatos accesoDatosApi = new AccesoADatos(conexionApi);
        System.out.println(accesoDatosApi.getDatos().getCadenaConexion());

        IConexion conexionDataBase = new DatabaseService();
        AccesoADatos accesoDatosDB = new AccesoADatos(conexionDataBase);
        System.out.println(accesoDatosDB.getDatos().getCadenaConexion());
        System.out.println();
    }

    public static void imprimirPrecioMedioAutomovil_SRP(Automovil[] arrayAutomoviles) {
        for (Automovil automovil : arrayAutomoviles) {
            if (automovil.getMarcaAutomovil().equals("Renault")) {
                System.out.println(automovil.getMarcaAutomovil() + " tiene costo de $7800000");
            }
            if (automovil.getMarcaAutomovil().equals("Audi")) {
                System.out.println(automovil.getMarcaAutomovil() + " tiene costo de $8500000");
            }
        }
        System.out.println();
    }

    public static void imprimirPrecioMedioAutomovil(AbsAutomovil_O[] arrayAutomoviles) {
        for (AbsAutomovil_O automovil : arrayAutomoviles) {
            if (automovil.getMarcaAutomovil().equals("Renault")) {
                System.out.println(automovil.getMarcaAutomovil() + " tiene costo de $7800000");
            }
            if (automovil.getMarcaAutomovil().equals("Audi")) {
                System.out.println(automovil.getMarcaAutomovil() + " tiene costo de $8500000");
            }
            if (automovil.getMarcaAutomovil().equals("Ford")) {
                System.out.println(automovil.getMarcaAutomovil() + " tiene costo de $10000000");
            }
        }
        System.out.println();
    }
    
    public static void imprimirPrecioMedioAutomovil_OCP(AbsAutomovil_O[] arrayAutomoviles) {
        for (AbsAutomovil_O automovil : arrayAutomoviles) {
            System.out.println(automovil.getMarcaAutomovil() + " tiene un precio medio de $" + automovil.precioMedioAutomovil());
        }
        System.out.println();
    }

    //Forma de imprimir errada principio Liskov
    public static void imprimirNumAsientos(AbsAutomovil_O[] arrayAutomoviles) {
        System.out.println("Imprimiendo por Automovil sin principio Liskov");
        for (AbsAutomovil_O automovil : arrayAutomoviles) {
            if (automovil instanceof Renault_O) {
                System.out.println(automovil.getMarcaAutomovil() + " tiene " + numAsientosRenault((Renault_O) automovil) + " asientos y su precio medio es $" + automovil.precioMedioAutomovil());

            }
            if (automovil instanceof Audi_O) {
                System.out.println(automovil.getMarcaAutomovil() + " tiene " + numAsientosAudi((Audi_O) automovil) + " asientos y su precio medio es $" + automovil.precioMedioAutomovil());

            }
            if (automovil instanceof Mercedes_O) {
                System.out.println(automovil.getMarcaAutomovil() + " tiene " + numAsientosMercedes((Mercedes_O) automovil) + " asientos y su precio medio es $" + automovil.precioMedioAutomovil());

            }
            if(automovil instanceof Ford_O){
                System.out.println(automovil.getMarcaAutomovil() + " tiene " + numAsientosFord((Ford_O) automovil) + " asientos y su precio medio es $" + automovil.precioMedioAutomovil());
            }
        }
        System.out.println();
    }

    static int numAsientosRenault(Renault_O automovil) {
        return automovil.numAsientos();
    }

    static int numAsientosAudi(Audi_O automovil) {
        return automovil.numAsientos();
    }

    static int numAsientosMercedes(Mercedes_O automovil) {
        return automovil.numAsientos();
    }

    static int numAsientosFord(Ford_O automovil) {
        return automovil.numAsientos();
    }

    //Impremiendo de manera correcta
    public static void imprimirNumAsientos_LSP(AbsAutomovil_L[] arrayAutomoviles) {
        System.out.println("Imprimiendo por Automovil con principio Liskov");
        for (AbsAutomovil_L automovil : arrayAutomoviles) {
            System.out.println(automovil.getMarcaAutomovil() + " tiene " + automovil.numAsientos() + " asientos y su precio medio es $" + automovil.precioMedioAutomovil());
        }
        System.out.println();
    }
}
