/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Ej2;

/**
 *
 * @author Nicolás
 */
public class Jueguito implements Runnable {

    private Vida vid = new Vida();

    private synchronized void golpear() {
        if (vid.getSalud() > 0) { //Tengo salud todavia
            System.out.println("El ORCO golpea! Salud antes del golpe: " + vid.getSalud());
            vid.perderVida(3);
            System.out.println("Perdiste 3 puntos de salud! Salud actual: " + vid.getSalud());
        } else {
            System.out.println("Ya no tienes salud! Te re moriciste *Sonido de Dark Souls* ");
            System.out.println("Tu vida es de: " + vid.getSalud());
        }
    }

    private synchronized void curar() {
        if (vid.getSalud() > 0) { //Tengo salud todavia, puedo ser curado
            System.out.println("El CURANDERO cura! Salud antes de la curacion: " + vid.getSalud());
            vid.aumentarVida(3);
            System.out.println("Tu salud aumento en 3 puntos! Salud actual: " + vid.getSalud());
        } else {
            System.out.println("Ya no tienes salud! Te re moriciste *Sonido de Dark Souls* ");
            System.out.println("Tu vida es de: " + vid.getSalud());
        }
    }

    public void run() {
//        for (int i = 0; i < 4; i++) {
            try {
                if (Thread.currentThread().getName().equalsIgnoreCase("orco")) {
                    this.golpear();
                } else {
                    this.curar();
                }
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
//        }
    }
}
