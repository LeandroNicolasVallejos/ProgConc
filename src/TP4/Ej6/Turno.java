/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Nicolás
 */
public class Turno {

    private Semaphore mutex;
    private int numTurno;

    public Turno() {
        numTurno = 1;
        mutex = new Semaphore(1); //Semaforo de un solo permiso
    }

    public int getNum() {
        return this.numTurno;
    }

    public void incrementaTurno() throws InterruptedException {
        mutex.acquire();
        if (numTurno == 1 || numTurno == 2) {
            numTurno++;
        } else { //Para cuando se imprimió el turno 3, volvemos al 1
            numTurno = 1;
        }
        mutex.release();
    }
}
