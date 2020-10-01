/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej9;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Nicolás
 */
public class Taxi {

    //COLORES
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_RESET = "\u001B[0m";
    //COLORES
    Semaphore semTaxi, semTaxista, semPasajero;

    public Taxi() {
        semTaxi = new Semaphore(1);
        semTaxista = new Semaphore(0);
        semPasajero = new Semaphore(0);
    }

    public boolean entrarTaxi(String nombrePasajero) {
        System.out.println(ANSI_GREEN + "Soy el cliente " + nombrePasajero + ", quiero entrar al Taxi!");
        return (semTaxi.tryAcquire());
    }

    public void solicitoViaje(String nombrePasajero) {
        System.out.println(ANSI_CYAN + "Soy el cliente " + nombrePasajero + ", estoy despertando al taxista así me lleva!");
        semTaxista.release();
        try {
            semPasajero.acquire();
        } catch (InterruptedException e) {
        }
    }
    
    public void terminarViaje(){
        semPasajero.release();
    }
    
    public void salir(){
        semTaxi.release();
        System.out.println(ANSI_RED+"     El taxi quedo libre");
    }

    public void esperarPasajero(String nombreTaxista) {
        try {
            semTaxista.acquire();
        } catch (InterruptedException e) {
        }
    }
}
