/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Ej3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class Letra implements Runnable {

    private final Turno turno = new Turno();
    String h = "";

    public Letra() {
    }

    public synchronized void imprimir() {

            if (Thread.currentThread().getName().equals("La") && turno.getNum() == 1) {
                h = "A";
                turno.incrementaTurno();
            } else {
                if (Thread.currentThread().getName().equals("Lb") && turno.getNum() == 2) {
                    h = h + "BB";
                    turno.incrementaTurno();
                } else {
                    if (Thread.currentThread().getName().equals("Lc") && turno.getNum() == 3) {
                        {
                            h = h + "CCC";
                            turno.incrementaTurno();
                            System.out.println(h); //Cuando llega acá, se completó una tanda de ABBCCC, es impresa
                        }
                        
                    }
                }
            }
        }
    

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            this.imprimir();
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Letra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
