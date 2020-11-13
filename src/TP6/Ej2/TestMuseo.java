/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.Ej2;

/**
 *
 * @author Nicolás
 */
public class TestMuseo {

    public static void main(String[] args) {
        SalaMuseo museo = new SalaMuseo();

        Thread[] hiloPersonas = new Thread[70];
        Thread hiloGestor = new Thread(new GestorSala(museo));

        for (int i = 0; i < 69; i++) { // NICE (͡°ʖ͡°)
            int num = (int) (Math.random() * 2) + 1;
            hiloPersonas[i] = new Thread(new Persona(museo, "Persona " + i, num));
        }
        hiloGestor.start();
        for (int i = 0; i < 69; i++) {  // NICE (͡°ʖ͡°)
            hiloPersonas[i].start();
        }
    }
}
