/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class Atleta implements Runnable {

    private Testigo testigo;
    int numeroAleatorio;

    public Atleta(Testigo test) {
        testigo = test;
    }

    @Override
    public void run() {
        try {
            switch (Thread.currentThread().getName()) {
                case "Atleta 1":
                    testigo.correrAt1();
                    break;
                case "Atleta 2":
                    testigo.correrAt2();
                    break;
                case "Atleta 3":
                    testigo.correrAt3();
                    break;
                case "Atleta 4":
                    testigo.correrAt4();
                    break;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
