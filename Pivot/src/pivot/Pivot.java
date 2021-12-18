/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pivot;

import pivot.FindPivot.FindByPivot;

/**
 * Esta clase piviot se encarga de: 1)-Iniciar el proyecto.
 * 2)-Preguntar si se desea crear la colección de forma manual o automática.
 * 3)- Redirigir a la clase FindByPivot del paquete pivot.FindPivot solo si el
 * usuario ha ingresa 1 o 2 de lo contrario no le permitirá continuar.
 * @author Brayan Felipe Pardo Cortes
 */
public class Pivot {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Bienvenido:");
        System.out.println("Desea llenar la colección manualmente,"
                + "o desea crear una automaticamente:\n"
                + "Ingrese un numero: ( 1 o 2)\n"
                + "1. Manual\n"
                + "2. Automatico");
        FindByPivot inicio = new FindByPivot();
        int ManualAutomatico = inicio.tryCatchInt(2);
        while (ManualAutomatico != 1 && ManualAutomatico !=2){
            System.out.println("Ingrese unicamente 1 o 2");
            ManualAutomatico = inicio.tryCatchInt(2);
        }
        inicio.crearColeccionDeEntrada(ManualAutomatico);
    }

}
