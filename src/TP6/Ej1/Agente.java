/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.Ej1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class Agente implements Runnable {

    private SalaFumadores sala;
    private Random r;

    public Agente(SalaFumadores sala) {
        this.sala = sala;
        r = new Random();
    }

    public void run() {
        while (true) {
            try {
                int num = r.nextInt(3) + 1;
                int num2;
                if (num == 3) {
                    num2 = 1;
                } else {
                    num2 = num + 1;
                }
                sala.colocar(num, num2);
            } catch (InterruptedException ex) {
                Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//while
    }// run
}//clase

