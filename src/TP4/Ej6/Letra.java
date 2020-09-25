/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class Letra implements Runnable {

    private final Turno turno;
    int numero;

    public Letra(Turno unTurno) {
        turno = unTurno;
    }

    public void imprimir() throws InterruptedException {
        if (Thread.currentThread().getName().equals("La") && turno.getNum() == 1) {
            System.out.print("A");
            turno.incrementaTurno();
        } else {
            if (Thread.currentThread().getName().equals("Lb") && turno.getNum() == 2) {
                System.out.print("BB");
                turno.incrementaTurno();
            } else {
                if (Thread.currentThread().getName().equals("Lc") && turno.getNum() == 3) {
                    {
                        System.out.print("CCC");
                        turno.incrementaTurno();
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                this.imprimir();
            } catch (InterruptedException ex) {
                Logger.getLogger(Letra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
