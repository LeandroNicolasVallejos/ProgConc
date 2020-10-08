/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej9;

/**
 *
 * @author Nicolás
 */
public class Main {

    public static void main(String[] args) {
        Taxi unTaxi = new Taxi();
        Taxista unTaxista = new Taxista(unTaxi);

        Thread hiloTaxista = new Thread(unTaxista);
        hiloTaxista.start();
        Thread[] hiloPasajeros = new Thread[15];

        for (int i = 0; i < 14; i++) {
            Pasajero unPasajero = new Pasajero(unTaxi, "Pasajero " + i);
            hiloPasajeros[i] = new Thread(unPasajero);
        }
        for (int x = 0; x < 14; x++) {
            hiloPasajeros[x].start();
            try {
                Thread.sleep((int) (Math.random() * 440));
            } catch (InterruptedException e) {
            }
        }
    }
}
