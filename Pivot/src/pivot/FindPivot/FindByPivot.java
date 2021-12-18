/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pivot.FindPivot;

import java.util.Scanner;

/**
 * La clase FindByPivot se encarga de: 1)-Crear una colección manualmente si el
 * usuario lo desea.
 * 2)- Crear una colección automaticamente si el usuario lo desea.
 * 3)- Encontrar el pivot correspondiente a la colección creada.
 * @author Brayan Felipe Pardo Cortes
 */
public class FindByPivot {

    Scanner sc = new Scanner(System.in);

    int[] ColeccionEntrada;

    /**
     * Constructor vacío
     */
    public FindByPivot() {
    }

    /**
     * Este método se encarga de: 1)- Decidir si tiene que crear la colección de
     * manera manual o automatica.
     * @param ManualAutomatico Esta Variable contiene el numero para poder decidir
     * si crear la colección de manera manual o automaticamente.
     */
    public void crearColeccionDeEntrada(int ManualAutomatico) {

        if (ManualAutomatico == 1) {
            crearColeccionManual();
        }
        if(ManualAutomatico == 2){
            crearColeccionAutomatico();
        }
    }

    /**
     * Este método se encarga de: 1)- Realizar todos los try-catch utilizados para
     * poder pedir al usuario datos de tipo int de manera satisfactoria y sin errores.
     * Dichos errores de tal caso si el usuario ingresa datos no numéricos.
     * @param idProceso
     * @return
     */
    public int tryCatchInt(int idProceso) {
        int tamañoDeLaColeccion = 0;
        switch (idProceso) {

            case 1:
                int controlwhile1 = 0;
                while (controlwhile1 == 0) {
                    try {
                        System.out.println("Ingrese el tamaño de la colección deseada (Tiene que ser mayor que 3)");
                        tamañoDeLaColeccion = sc.nextInt();
                        
                        sc.nextLine();
                        if (tamañoDeLaColeccion > 3) {
                            controlwhile1 = 1;
                        } else {
                            controlwhile1 = 0;
                        }

                    } catch (Exception e) {
                        System.out.println("Ingrese un dato numérico válido");
                        sc.nextLine();
                    }
                }
                break;
            case 2:
                int controlWhile2 = 0;
                while (controlWhile2 == 0) {
                    try {
                        System.out.println(">>> ");
                        tamañoDeLaColeccion = sc.nextInt();
                        sc.nextLine();
                        controlWhile2 = 1;
                    } catch (Exception e) {
                        System.out.println("Ingrese un dato numérico válido");
                        sc.nextLine();
                        controlWhile2 = 0;
                    }
                }
                break;
        }
        
        return tamañoDeLaColeccion;
    }
    
    /**
     * Este método se encarga de: 1)-Crear la colección de manera automática
     * 2)-Enviar la colección al método buscarPivot para encontrar el pivot
     * correspondiente.
     */
    public void crearColeccionAutomatico(){
        int tamañoDeLaColeccion = (int)Math.floor(Math.random() * (8 - 4 + 1)) + 4;
        ColeccionEntrada = new int[tamañoDeLaColeccion];
        for (int i = 0; i < ColeccionEntrada.length; i++) {
            ColeccionEntrada[i]= (int)Math.floor(Math.random() * (9 - 1 + 1)) + 1;
        }
        System.out.println("La coleccion es: ");
        System.out.print("[ ");
        for (int i = 0; i < ColeccionEntrada.length; i++) {
            System.out.print(ColeccionEntrada[i]+" ");
        }
        System.out.print("]");
        System.out.println("");
        buscarPivot(ColeccionEntrada);
    }

    /**
     * Este método se encarga de: 1)-Crear la colección de manera manual.
     * 2)-Enviar la colección al método buscarPivot para encontrar el pivot
     * correspondiente.
     */
    public void crearColeccionManual() {
        int tamañoColeccion = tryCatchInt(1);
        ColeccionEntrada = new int[tamañoColeccion];
        for (int i = 0; i < ColeccionEntrada.length; i++) {
            System.out.println("Ingrese el dato de la posicion " + (i + 1) + " de " + ColeccionEntrada.length);
            ColeccionEntrada[i] = tryCatchInt(2);
        }
        
        System.out.println("La coleccion es: ");
        System.out.print("[ ");
        for (int i = 0; i < ColeccionEntrada.length; i++) {
            System.out.print(ColeccionEntrada[i]+" ");
        }
        System.out.print("]");
        System.out.println("");
        buscarPivot(ColeccionEntrada);

    }
    
    /**
     * Este método se encarga de: 1)-Buscar el pivot correspondiente a la colección
     * dada.
     * @param ColeccionFinal Contiene la colección creada de manera manual o 
     * automática.
     */
    public void buscarPivot(int []ColeccionFinal){
        int sumatoriaIzquierda = 0;
        int sumatoriaDerecha = ColeccionFinal[ColeccionFinal.length-1];
        int controlPivot = 0;
        int posiblePivot = 0;
        int posicionFinal = ColeccionFinal.length-1;
        for (int i = 0; i < ColeccionFinal.length; i++) {
            if(controlPivot == 1){
                break;
            }
            sumatoriaIzquierda += ColeccionFinal[i];
            posiblePivot = i+1;
            if(sumatoriaIzquierda == sumatoriaDerecha){
                System.out.println("El pivot esta en la posición: "+posiblePivot);
                controlPivot = 1;
                break;
            }else{
                if(sumatoriaIzquierda > sumatoriaDerecha){
                    
                    for (int j = posicionFinal; j > 0; j--){
                        sumatoriaDerecha += ColeccionFinal[j-1];
                        if(sumatoriaDerecha == sumatoriaIzquierda){
                            System.out.println("El pivot esta en la posición "+posiblePivot);
                            controlPivot = 1;
                        }else{
                            if(sumatoriaDerecha > sumatoriaIzquierda){
                                posicionFinal -= 1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if( controlPivot == 0){
            System.out.println("No se encontro el pivot");
        }
    }

    

}
