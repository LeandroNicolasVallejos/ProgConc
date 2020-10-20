/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EjBarbero;

/**
 *
 * @author Nicolás
 */
public class Barbero implements Runnable {

    private Barberia miBarberia;
    private String miNombre;

    public Barbero(Barberia barb) {
        this.miBarberia = barb;
        this.miNombre = "Barbero";
    }

    @Override
    public void run() {
        int cuantos = 0;
        System.out.println("Bienvenidos a la barberia!!");
        while (true) {
            miBarberia.esperarCliente();
            this.cortarPelo();
            miBarberia.terminarCorte();
            cuantos++;
            System.out.println("Ya le corte el pelo a " + cuantos + " clientes");
        }
    }

    private void cortarPelo() {
        System.out.println(miNombre + ": Le estoy cortando el pelo a un cliente");
        try {
            Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            System.out.println("----- El corte fue interrumpido -----");
        }
    }
}
