/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VallejosFAI2003Parcial2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.*;

/**
 *
 * @author Nicolás
 */
public class LugarPlatos {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";


    private int platosConComida, maxPlatos, platosEnUso;
    private Semaphore semPlato, semEncargado;

    private Lock lock;

    private Semaphore semPerritoAvisador;

    public LugarPlatos(int maxPl) {
        
        platosEnUso = 0;
        lock = new ReentrantLock();
        maxPlatos = maxPl;
        platosConComida = maxPl; //AL principio los platos estan todos llenos

        semPlato = new Semaphore(maxPl); //cada plato es un permiso de semaforo
        semEncargado = new Semaphore(0); //binario, empieza sin permisos

        semPerritoAvisador = new Semaphore(0); //Binario, para avisar al perrito que ya repusieron platos
    }

    public void esperarAviso() { //Lo usa el encargado
        try {
            semEncargado.acquire();
        } catch (InterruptedException e) {
        }
    }

    public void avisarPerro() { //Lo usa el encargado
        semPerritoAvisador.release();
        platosConComida = maxPlatos;
        System.out.println(ANSI_RED + "    ENCARGADO DICE:      TODOS LOS PLATOS FUERON REPUESTOS! ");
    }

    public void avisarEncargado(String nombreAvisador) { //Lo usa el perro que ladra porque no hay platos con comida
        System.out.println(ANSI_BLUE + " --------- Soy el perro " + nombreAvisador + " y le aviso al encargado que reponga los platos");
        semEncargado.release();
        try {
            semPerritoAvisador.acquire();
        } catch (InterruptedException e) {
        }
    }

    public boolean comer(String nombrePerro) throws InterruptedException { // LO USA EL PERRITO
        boolean comi = false;
        lock.lock();
        try {
            if (platosConComida > 0 && (platosEnUso < maxPlatos)) {
                System.out.println("Soy el perro " + nombrePerro + " y estoy comiendo de un plato, lo voy a dejar vacio!");
                platosConComida--;
                platosEnUso++;
                semPlato.acquire();
                comi = true;
            } else {
                avisarEncargado(nombrePerro);
            }
        } finally {
            lock.unlock();
        }
        return comi;
    }

    public void terminarDeComer(String nombrePerro) { //LO USA EL PERRITO
        semPlato.release(); //DEJA EL PLATO PERO ESTA VACIO, entonces no cambia el contador de platos llenos
        platosEnUso--;
        System.out.println(ANSI_PURPLE + nombrePerro+ " dice: DEJE DE COMER! DEJE EL PLATO VACIO!");
    }
}
