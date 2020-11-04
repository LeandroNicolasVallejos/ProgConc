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
public class Pasajero implements Runnable {

    private boolean tengoTicket, diVuelta;
    private String nombre;
    private Tren tren;

    public Pasajero(String nomb, Tren trencito) { //Constructor de pasajero. Por defecto no tiene ticket
        this.tren = trencito;
        this.nombre = nomb;
        this.tengoTicket = false;
        this.diVuelta = false;
    }

    private void comprarTicket() {
        System.out.println("Soy el pasajero " + nombre + " y voy a comprar un ticket!");
        tren.pedirTicket(nombre);
        tengoTicket = true;
    }

    private void caminarUnRato() { //Para cuando el pasajero no pudo subir, tambien para ir a la atraccion
        try {
            Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void run() {
        while (!diVuelta) {
            this.caminarUnRato();
            if (!tengoTicket) {
                this.comprarTicket();
            }
            try {
                if (tengoTicket && tren.puedoSubir()) { //Si el ticket ya fue comprado y el tren tiene asiento
                    tren.subirAlTren(nombre);
                    tengoTicket = false;
                    diVuelta = true;
                } else {
                    System.out.println(nombre + " NO puede subir al tren! Esta lleno!");
                    this.caminarUnRato(); //Para cuando no pudo subir porque el tren estaba lleno
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
