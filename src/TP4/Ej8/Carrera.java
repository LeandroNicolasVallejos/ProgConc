/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej8;

/**
 *
 * @author Nicolás
 */
public class Carrera {

    public static void main(String[] args) {
        Testigo testigo = new Testigo();
        Atleta[] atletas = new Atleta[4];
        Thread[] hilos = new Thread[4];
        for (int i = 0; i < 4; i++) {
            atletas[i] = new Atleta(testigo);
            hilos[i] = new Thread(atletas[i], "Atleta " + (i + 1));
        }
        for (int x = 0; x < 4; x++) {
            hilos[x].start();
        }
    }
}
