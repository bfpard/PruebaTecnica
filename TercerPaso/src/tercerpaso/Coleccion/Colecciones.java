/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tercerpaso.Coleccion;

import java.util.Scanner;

/**
 * La clase Colecciones se encarga de: 1)- Crear una colección de entrada de manera
 * automática o manual, dependiendo de lo que el usuario desee.
 * 2)-Crear la colección de colsulta hecha por el usuario.
 * 3)-Buscar el numero de incidencias que hay en la colección de entrada sobre la
 * de consulta.
 * @author Brayan Felipe Pardo Cortes
 */
public class Colecciones {
    
    int NumeroMinDeColeccionDeEntrada = 2;
    int NumeroMaxDeColeccionDeEntrada = 5;
    int NumeroMaxDeLetras = 3;
    int NumeroMinDeLetras = 2;
    int NumeroMaxDeLetrasAbecedario = 25;
    int NumeroMinDeLetrasAbecedario = 0;
    String [] abecedario = {"a","b","c","d","e","f","g","h","i","j","k","l",
            "m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    String ColeccionDeEntrada [];
    String ColeccionDeConsulta [];
    int ColeccionDeSalida [];
    
    Scanner sc = new Scanner (System.in);
    
    /**
     * Constructor vacío
     */
    public Colecciones() {
    }
    
    /**
     * Con este método se redirecciona para crear una colección manual o
     * automáticamente.
     * @param ManualAutomatico Contiene el deseo del usuario por crear la colección
     * manual o automáticamente
     */
    public void inicio(int ManualAutomatico){
        
        if (ManualAutomatico == 1) {
            crearColeccionManual();
        }
        
        if(ManualAutomatico == 2){
            crearColeccionAutomatico();
        }
    }
    
    /**
     * Este método se encarga de: 1)- Pedirle al método crearColeccionEntradaManual
     * para que le cree la colección manualmente. 2)-Crear la colección de consulta
     * 3)- Mostrar la colección de salida con las datos requeridos.
     */
    public void crearColeccionManual() {
        var ColeccionEntrada = crearColeccionEntradaManual();
        int NumeroDeCoincidencias = 0;
        int tamañoDeLaColeccionDeConsulta = tryCatchInt(1);
        if (tamañoDeLaColeccionDeConsulta > 0) {
            ColeccionDeConsulta = new String[tamañoDeLaColeccionDeConsulta];
            ColeccionDeSalida = new int[tamañoDeLaColeccionDeConsulta];
            for (int i = 0; i < ColeccionDeConsulta.length; i++) {
                System.out.println("Ingrese el dato de la posicion " + (i + 1) + " de " + ColeccionDeConsulta.length);
                ColeccionDeConsulta[i] = sc.nextLine();

            }
            System.out.println("La coleccion de consulta es:");
            System.out.print("[");
            for (String ColeccionDeConsulta1 : ColeccionDeConsulta) {
                System.out.print(ColeccionDeConsulta1 + " ");
            }
            System.out.print("]");
            System.out.println("");

            for (int i = 0; i < ColeccionDeConsulta.length; i++) {
                for (int j =0; j < ColeccionEntrada.length;j++) {
                    if (ColeccionDeConsulta[i].equals(ColeccionEntrada[j])) {
                        NumeroDeCoincidencias += 1;
                    }
                }
                ColeccionDeSalida[i] = NumeroDeCoincidencias;
                NumeroDeCoincidencias = 0;
            }

            System.out.println("La Coleccion de salida:");
            System.out.print("[");
            for (int i = 0; i < ColeccionDeSalida.length; i++) {
                System.out.print(ColeccionDeSalida[i] + " ");
            }

            System.out.print("]");
            System.out.println("");

        } else {

            System.out.println("Por favor digite un numero mayor a 0");
        }

    }
    
    /**
     * Este método se encarga de: 1)-crear la colección manualmente
     * 2)-Retornar la colección al método principal.
     * @return Retorna la colección de entrada al método crearColeccionManual
     */
    public String [] crearColeccionEntradaManual(){
        
        int tamañoColeccion = tryCatchInt(3);
        ColeccionDeEntrada = new String [tamañoColeccion];
        for (int i =0; i < ColeccionDeEntrada.length ; i++){
            System.out.println("Ingrese el dato de la posición "+(i+1)+" de "+ColeccionDeEntrada.length);
            ColeccionDeEntrada[i] = contenidoManualParaColeccionDeEntrada();
        }
        
        System.out.println("La Coleccion de entrada generada manualmente es:\n");
        System.out.print("[ ");
        for (String ColeccionDeEntrada1 : ColeccionDeEntrada) {
            System.out.print(ColeccionDeEntrada1+" ");
        }
        System.out.print("]");
        System.out.println("");
        return ColeccionDeEntrada;
    }
    
    /**
     * Este método se encarga de: 1)- Pedir datos al usuario.
     * @return
     */
    public String contenidoManualParaColeccionDeEntrada(){
        String contenido = sc.nextLine();
        return contenido;
    }
    
    
    /**
     * Este método se encarga de: 1)- Pedirle al método crearColeccionDeEntradaAutomatica
     * para que le cree la colección automáticamente. 2)-Crear la colección de consulta
     * 3)- Mostrar la colección de salida con las datos requeridos.
     */
    public void crearColeccionAutomatico(){
        var ColeccionEntrada = crearColeccionDeEntradaAutomatica();
        int NumeroDeCoincidencias = 0;
        int tamañoDeLaColeccionDeConsulta = tryCatchInt(1);
        if (tamañoDeLaColeccionDeConsulta > 0) {
                    ColeccionDeConsulta = new String[tamañoDeLaColeccionDeConsulta];
                    ColeccionDeSalida = new int[tamañoDeLaColeccionDeConsulta];
                    for (int i = 0; i < ColeccionDeConsulta.length; i++) {
                        System.out.println("Ingrese el dato de la posicion " + (i + 1) + " de " + ColeccionDeConsulta.length);
                        ColeccionDeConsulta[i] = sc.nextLine();

                    }
                    System.out.println("La coleccion de consulta es:");
                    System.out.print("[");
                    for (String ColeccionDeConsulta1 : ColeccionDeConsulta) {
                        System.out.print(ColeccionDeConsulta1+" ");
                    }
                    System.out.print("]");
                    System.out.println("");

                    for (int i = 0; i < ColeccionDeConsulta.length; i++) {
                        for (String ColeccionEntrada1 : ColeccionEntrada) {
                            if (ColeccionEntrada1.equals(ColeccionDeConsulta[i])) {
                                NumeroDeCoincidencias += 1;
                            }
                        }
                        ColeccionDeSalida[i] = NumeroDeCoincidencias;
                        NumeroDeCoincidencias = 0;
                    }

                    System.out.println("La Coleccion de salida:");
                    System.out.print("[");
                    for (int i = 0; i < ColeccionDeSalida.length; i++) {
                        System.out.print(ColeccionDeSalida[i]+" ");
                    }
                    
                    System.out.print("]");
                    System.out.println("");
                    
                } else {
                    
                    System.out.println("Por favor digite un numero mayor a 0");
                }
    }
    
    /**
     * Este método se encarga de: 1)-crear la colección automáticamente
     * 2)-Retornar la colección al método principal.
     * @return Retorna la colección de entrada al método crearColeccionDeEntradaAutomatica
     */
    public String [] crearColeccionDeEntradaAutomatica(){
        
        int tamañoDeLaColeccion = tamañoDeLaColeccionDeEntrada();
        ColeccionDeEntrada = new String [tamañoDeLaColeccion];
        
        for (int i =0; i < ColeccionDeEntrada.length ; i++){
            ColeccionDeEntrada[i] = contenidoRandomParaColeccionDeEntrada();
        }
        System.out.println("La Coleccion de entrada generada automaticamente es:\n");
        System.out.print("[ ");
        for (String ColeccionDeEntrada1 : ColeccionDeEntrada) {
            System.out.print(ColeccionDeEntrada1+" ");
        }
        System.out.print("]");
        System.out.println("");
        return ColeccionDeEntrada;
        
    }

    /**
     * Este método se encarga de : 1)-Genera automáticamente el tamaño de la colección.
     * @return Retorna el tamaño generado automáticamente.
     */
    public int tamañoDeLaColeccionDeEntrada(){
        
        
        return (int)Math.floor(Math.random() * (NumeroMaxDeColeccionDeEntrada - NumeroMinDeColeccionDeEntrada + 1)) + NumeroMinDeColeccionDeEntrada;
               
    }
    
    /**
     * Este método se encarga de: 1)-llenar la colección automaticamente, haciendo uso
     * de la colección del abecedario.
     * @return Retorna los datos generados automáticamente.
     */
    public String contenidoRandomParaColeccionDeEntrada(){
        
        int numeroDeLetras = (int)Math.floor(Math.random() * (NumeroMaxDeLetras - NumeroMinDeLetras + 1)) + NumeroMinDeLetras;
        String letras = "";
        for (int i = 0; i < numeroDeLetras ; i++){
            letras += abecedario[(int)Math.floor(Math.random() * (NumeroMaxDeLetrasAbecedario - NumeroMinDeLetrasAbecedario + 1)) + NumeroMinDeLetrasAbecedario];
        }
        return letras;
    }
    
    /**
     * Este método se encargar de: 1)-Realizar el proceso try catch para pedir datos
     * enteros por consola, para evitar errores por ingresar datos no válidos
     * @param idProceso Contiene el numero del proceso del try catch deseado.
     * @return Retorna un dato entero sin errores.
     */
    public int tryCatchInt(int idProceso) {
        int tamañoDeLaColeccion = 0;
        switch (idProceso) {

            case 1:
                int controlwhile1 = 0;
                while (controlwhile1 == 0) {
                    try {
                        System.out.println("Ingrese el tamaño de la coleccion de consulta:(debe ser mayor que 3)\n>>>");
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
                        if(tamañoDeLaColeccion > 0){
                            controlWhile2 = 1;
                        }else{
                            controlWhile2 = 0;
                        }
                        
                    } catch (Exception e) {
                        System.out.println("Ingrese un dato numérico válido");
                        sc.nextLine();
                        controlWhile2 = 0;
                    }
                }
                break;
                
            case 3:
                int controlWhile3 = 0;
                while (controlWhile3 == 0) {
                    try {
                        System.out.println("Ingrese el tamaño de la colección de entrada (debe ser mayor a 0)");
                        tamañoDeLaColeccion = sc.nextInt();
                        sc.nextLine();
                        if(tamañoDeLaColeccion > 0){
                            controlWhile3 = 1;
                        }else{
                            controlWhile3 = 0;
                        }
                        
                    } catch (Exception e) {
                        System.out.println("Ingrese un dato numérico válido");
                        sc.nextLine();
                        controlWhile3 = 0;
                    }
                }
                break;
        }
        
        return tamañoDeLaColeccion;
    }
      
    
}
