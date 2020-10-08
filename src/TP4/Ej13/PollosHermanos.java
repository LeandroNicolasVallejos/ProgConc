/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej13;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Nicolás
 */
public class PollosHermanos {
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
    private Semaphore semMozo, semSilla, semEmpleado, semCocinero;

    public PollosHermanos() {
        semMozo = new Semaphore(0);
        semCocinero = new Semaphore(0);
        semSilla = new Semaphore(1);
        semEmpleado = new Semaphore(0);
    }

    public void pedirComidaCocinero() { //Esto lo usa el mozo
        semCocinero.release();
    }

    public void darComidaMozo(String nombreCocinero) { //Puede no imprimirse en orden porque no intervienen semaforos aqui
        System.out.println("             --> El cocinero " + nombreCocinero + " le dio la comida al mozo!");
    }

    public void esperarPedidoComida(String nombreCocinero) {
        try {
            semCocinero.acquire();
//            System.out.println("Soy el cocinero "+nombreCocinero+" y estoy esperando que el mozo me pida otra comida!");
        } catch (InterruptedException e) {
        }
    }

    public boolean entrarTienda(String nombreEmpleado) {
        System.out.println(ANSI_GREEN + "Hola! Soy el empleado " + nombreEmpleado + " y quiero entrar a comer");
        return (semSilla.tryAcquire());
    }

    public void pidoAtencion(String nombreEmpleado) {
        System.out.println(ANSI_RED + "   Soy el empleado " + nombreEmpleado + ", estoy avisandole al Mozo que me atienda!");
        semMozo.release();
        try {
            semEmpleado.acquire();
        } catch (InterruptedException e) {
        }
    }

    public void terminarAtencion() {
        semEmpleado.release();
    }

    public void salirTienda(String nombreEmpleado) {
        semSilla.release();
        System.out.println(ANSI_BLUE + "          ----- Soy el empleado " + nombreEmpleado + " y ya sali de la tienda. La tienda quedo libre.");
    }

    public void esperarEmpleado(String nombreMozo) {
        try {
            semMozo.acquire();
//            System.out.println(ANSI_PURPLE + "     Soy el mozo "+nombreMozo+" y estoy esperando a que otro empleado venga a comer");
        } catch (InterruptedException e) {
        }
    }
}
