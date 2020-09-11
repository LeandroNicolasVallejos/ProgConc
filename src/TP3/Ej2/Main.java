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
public class Main {
        public static void main(String[] args) {
        Jueguito jue = new Jueguito();
        Thread Orco = new Thread(jue, "Orco");
        Thread Curandero = new Thread(jue, "Curandero");
        Orco.start();
        Curandero.start();
    }
}
