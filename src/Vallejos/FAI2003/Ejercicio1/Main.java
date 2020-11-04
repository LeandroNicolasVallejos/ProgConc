/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vallejos.FAI2003.Ejercicio1;

/**
 *
 * @author Nicolás
 */
public class Main {

    public static void main(String[] args) {

        Tren tren = new Tren(10);

        VendedorTicket vend = new VendedorTicket("Roberto", tren);
        Thread hiloVendedor = new Thread(vend);
        hiloVendedor.start();

        ControlTren controlTren = new ControlTren(tren);
        Thread hiloControl = new Thread(controlTren);
        hiloControl.start();

        Thread[] hiloPasajero = new Thread[30];
        for (int i = 0; i <= 29; i++) {
            Pasajero pas = new Pasajero("Pasajero " + i, tren);
            hiloPasajero[i] = new Thread(pas);
        }

        for (int x = 0; x <= 29; x++) {
            hiloPasajero[x].start();
            try {
                Thread.sleep((int) (Math.random() * 500));
            } catch (InterruptedException e) {
            }
        }
    }
}
