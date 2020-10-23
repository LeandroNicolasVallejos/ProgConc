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
public class VendedorTicket implements Runnable {

    private String nomb;
    private Tren tren;

    public VendedorTicket(String nombre, Tren trencito) { //Constructor del vendedor de ticket
        this.nomb = nombre;
        tren = trencito;
    }

    private void venderTicket() { //La venta de tickets NO esta limitada a la capacidad del tren
        System.out.println("     Le estoy vendiendo un ticket a un pasajero!");
        try {
            Thread.sleep((int) (Math.random() * 500));
        } catch (InterruptedException e) {
        }
    }

    public void run() {
        System.out.println("Hola! Soy el vendedor de tickets " + nomb);
        while (true) {
            tren.esperarVenta();
            this.venderTicket();
            tren.terminarVenta();
        }
    }

}
