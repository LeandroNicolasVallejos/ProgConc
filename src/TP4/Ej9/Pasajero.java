/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej9;

/**
 *
 * @author Nicolás
 */
public class Pasajero implements Runnable {
    
        //COLORES
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static final String ANSI_RESET = "\u001B[0m";
    //COLORES

    private String miNombre;
    private Taxi taxi;

    public Pasajero(Taxi unTaxi, String nomb) {
        taxi = unTaxi;
        miNombre = nomb;
    }

    private void irAlTaxi() {
        System.out.println("Soy " + miNombre + ", y estoy yendo al taxi");
        try {
            Thread.sleep((int) (Math.random() * 490));
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void run() {
        this.irAlTaxi();
        if (taxi.entrarTaxi(miNombre)) {
            taxi.solicitoViaje(miNombre);
            System.out.println(ANSI_BLUE + "Soy " + miNombre + ", y me están llevando a mi destino!");
            taxi.salir();
            System.out.println(ANSI_BLUE + "Soy "+ miNombre+", y ya dejé el taxi!");
        }else{
            System.out.println(ANSI_RED + "Soy "+miNombre+", el taxi está ocupado");
        }
    }
}
