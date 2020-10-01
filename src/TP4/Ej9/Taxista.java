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
public class Taxista implements Runnable {

    private Taxi miTaxi;
    private String miNombre;

    public Taxista(Taxi tax) {
        miTaxi = tax;
        miNombre = "Tachero";
    }

    @Override
    public void run() {
        int cuantos = 0;
        System.out.println("Hola! Soy el taxista");
        while (true) {
            miTaxi.esperarPasajero(miNombre);
            this.viajar();
            miTaxi.terminarViaje();
            cuantos++;
            System.out.println(" --------- Lleve a destino a " + cuantos + " pasajeros");
        }
    }

    private void viajar() {
        System.out.println("Estoy llevando a un pasajero!");
        try {
            Thread.sleep((int) (Math.random() * 450));
        } catch (InterruptedException e) {
            System.out.println("----- Mi viaje fue interrumpido -----");
        }
    }

}
