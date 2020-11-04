/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vallejos.FAI2003.Ejercicio1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Nicolás
 */
public class Tren { //Recurso compartido por todos los hilos

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private int cantTotal, cantSubidos;
    private Semaphore semVendedor, semPasajero, semVuelta, semAsientos;

    private boolean andando = false;

    private ReentrantLock cerrojo = new ReentrantLock(); //Para controlar el acceso a los asientos

    public Tren(int cantAsientos) {
        this.cantTotal = cantAsientos; //La capacidad maxima del tren se establece por parametro
        this.cantSubidos = 0;
        semVendedor = new Semaphore(0);
        semPasajero = new Semaphore(0);
        semAsientos = new Semaphore(cantAsientos, true); //Semaforo general
        semVuelta = new Semaphore(0); //Este es para avisarle al controlador que ya se puede dar la vuelta en el tren
    }

    //@@@@@@@@@ METODOS QUE USA EL VENDEDOR DE TICKETS  @@@@@@@@@
    public void esperarVenta() {
        try {
            semVendedor.acquire();
        } catch (InterruptedException e) {
        }
    }

    public void terminarVenta() {
        semPasajero.release();
    }
    //@@@@@@@@@FIN DE METODOS QUE USA EL VENDEDOR DE TICKETS @@@@@@@@@

    private void vuelta() { //Le avisa al controlador que ya estan todos los pasajeros para dar la vuelta
        semVuelta.release();
        andando = true;
    }

    //@@@@@@@@@ METODOS QUE USA EL PASAJERO @@@@@@@@@
    public void pedirTicket(String nombrePas) {
        System.out.println("--- Soy el pasajero " + nombrePas + " y le estoy diciendo al Vendedor que quiero un ticket");
        semVendedor.release();
        try {
            semPasajero.acquire(); //Cuando el Vendedor le dio su ticket ya puede irse. 
        } catch (InterruptedException e) {
        }
    }

    public void subirAlTren(String pasajero) {
        System.out.println("-------" + pasajero + " pudo subir al tren!");
    }

    public boolean trenAndando() {
        return andando;
    }

    public boolean puedoSubir() throws InterruptedException { //Gestiona si un pasajero se sube o no. Protegido con un lock.
        boolean sube = false;
        cerrojo.lock();
        try {
            if (cantSubidos < cantTotal) {
                cantSubidos++;
                semAsientos.acquire();
                sube = true;
                if (cantSubidos == cantTotal) {
                    System.out.println(ANSI_RED + " SE LLEGO A LA CAPACIDAD MAXIMA DEL TREN. SALIMOS!");
                    vuelta(); //Se llego al maximo de pasajeros asi que avisamos al controlador que estamos para salir
                }
            }
        } finally {
            cerrojo.unlock();
        }
        return sube;
    }

    //@@@@@@@@@ FIN DE METODOS QUE USA EL PASAJERO @@@@@@@@@
    //@@@@@@@@@ METODOS QUE USA EL CONTROLADOR DEL TREN @@@@@@@@@
    public void esperarVuelta() {
        try {
            semVuelta.acquire();
        } catch (InterruptedException e) {
        }
    }

    public void reinicioVuelta() { //Avisada por controlTren de que la vuelta del tren termino.
        cerrojo.lock();
        try {
            cantSubidos = 0; //Reinicia el contador de pasajeros subidos para comenzar una vuelta nueva.
            semAsientos.release(cantTotal);
        } finally {
            cerrojo.unlock();
        }
        System.out.println(ANSI_BLUE + "SE TERMINO LA VUELTA! ENTREN LOS NUEVOS PASAJEROS!");
    }
    //@@@@@@@@@ FIN DE METODOS QUE USA EL CONTROLADOR DEL TREN @@@@@@@@@
}
