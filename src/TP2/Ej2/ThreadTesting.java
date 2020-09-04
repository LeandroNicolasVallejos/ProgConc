/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2.Ej2;

/**
 *
 * @author Nicolás
 */
class ThreadTesting {

    public static void main(String[] args) {
        MiEjecucion miHilo = new MiEjecucion();
        Thread miHiloThread = new Thread(miHilo);
        miHiloThread.start();
        System.out.println("En el main");
    }
}
