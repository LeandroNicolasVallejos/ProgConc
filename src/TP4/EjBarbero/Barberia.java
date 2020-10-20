/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EjBarbero;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Nicolás
 */
public class Barberia {
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
    Semaphore semBarbero, semBarberia, semCliente, semEsperas;

    public Barberia() {
        semBarbero = new Semaphore(0);
        semBarberia = new Semaphore(0, true);
        semCliente = new Semaphore(1, true); //Para la silla donde el barbero corta el pelo 
        //¿por que un barbero corta el pelo?
        semEsperas = new Semaphore(5, true); //Para las sillas para esperar
    }

    public boolean entrarBarberia(String nombreCliente) {
        System.out.println(ANSI_CYAN + "Soy el cliente " + nombreCliente + " y quiero entrar a la barberia");
        return (semEsperas.tryAcquire(1));
    }

    private boolean barberoCortando() {
        return semCliente.availablePermits() == 0;
    }

    public void solicitoCorte(String nombreCliente) {
        System.out.println(ANSI_GREEN + "Soy el cliente " + nombreCliente + " y voy a ver si el Barbero ya puede atenderme");
        if (!barberoCortando()) {
            semBarbero.release();
            System.out.println(ANSI_RED + "Soy " + nombreCliente + ", y me están cortando el pelo!");
            try {
                semCliente.acquire();
                semEsperas.release(1);
            } catch (InterruptedException e) {
            }
        }
    }

    public void terminarCorte() {
        semCliente.release();
    }

    public void salir() {
        semBarberia.release();
    }

    public void esperarCliente() {
        try {
            semBarbero.acquire();
        } catch (InterruptedException e) {
        }
    }
}
