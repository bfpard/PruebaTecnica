/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tercerpaso;

import tercerpaso.Coleccion.Colecciones;

/**
 * Clase Main que se encarga de: 1)-Ejecutar el proyecto
 * 2)-Redirigir a la clase Colecciones del paquete tercerpaso.Coleccion.
 * 3)- Preguntar si se desea crear la colección de entrada manual o
 * automáticamente.
 * @author Brayan Felipe Pardo Cortes.
 */
public class TercerPaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Bienvenido:");
        System.out.println("Desea llenar la colección de entrada manualmente,"
                + "o desea crear una automaticamente:\n"
                + "Ingrese un numero: ( 1 o 2)\n"
                + "1. Manual\n"
                + "2. Automatico");
        Colecciones inicio = new Colecciones();
        int ManualAutomatico = inicio.tryCatchInt(2);
        while (ManualAutomatico != 1 && ManualAutomatico !=2){
            System.out.println("Ingrese unicamente 1 o 2");
            ManualAutomatico = inicio.tryCatchInt(2);
        }
        inicio.inicio(ManualAutomatico);
    }
    
}
