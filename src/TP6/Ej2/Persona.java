/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.Ej2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class Persona implements Runnable {

    private String nombre;
    private SalaMuseo museo;
    private boolean jubilado;

    public Persona(SalaMuseo mus, String nomb, int jub) {
        nombre = nomb;
        museo = mus;
        jubilado = false;
        if (jub == 1) {
            jubilado = true;
        }
    }

    public void run() {
        while (true) {
            if (jubilado) {
                try {
                    museo.entrarSalaJubilado(nombre);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    museo.entrarSala(nombre);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                Thread.sleep((int) (Math.random() * 9000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }

            museo.salirSala();
            System.out.println("     " + nombre + " SE VA DE LA SALA");
        }
    }
}
