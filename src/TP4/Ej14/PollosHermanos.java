/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej14;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private Semaphore semMozo, semSilla, semSilla2, semEmpleado, semCocinero;

    public PollosHermanos(int maximoSillas) {
        semMozo = new Semaphore(0, true);
        semCocinero = new Semaphore(0);
        semSilla = new Semaphore(1, true);
        semEmpleado = new Semaphore(0, true);

        semSilla2 = new Semaphore(1, true);
    }

    public void pedirComidaCocinero(String nombreEmpleado) { //Esto lo usa el Empleado ahora
        System.out.println(ANSI_RED + "   Soy el empleado " + nombreEmpleado + ", estoy avisandole al Cocinero mi comida!");
        semCocinero.release();
    }

    public void esperarPedidoComida(String nombreCocinero) {
        try {
            semCocinero.acquire();
        } catch (InterruptedException e) {
        }
    }

    public int entrarTienda(String nombreEmpleado) {
        int num = 0;
        System.out.println(ANSI_GREEN + "Hola! Soy el empleado " + nombreEmpleado + " y quiero entrar a comer");
        if (semSilla.tryAcquire()) { //Intenta ir a sentarse a la silla 1 primero.
            num = 1;
        } else {
            if (semSilla2.tryAcquire()) { //Si la silla 1 esta ocupada, prueba con la 2. Sino, el Empleado se va.
                num = 2;
            }
        }
        return (num);
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

    public void salirTienda(String nombreEmpleado, int sillaALiberar) {
        if (sillaALiberar == 1) //Depende de la silla donde estaba el cliente es el semaforo que libera
        {
            semSilla.release();
        } else {
            if (sillaALiberar == 2) {
                semSilla2.release();
            }
        }
        System.out.println(ANSI_BLUE + "          ----- Soy el empleado " + nombreEmpleado + " y ya sali de la tienda. La silla " + sillaALiberar + " quedo libre.");
    }

    public void esperarEmpleado(String nombreMozo) {
        try {
            semMozo.acquire();
        } catch (InterruptedException e) {
        }
    }
}
