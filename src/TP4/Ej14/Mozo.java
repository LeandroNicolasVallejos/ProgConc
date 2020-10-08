/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej14;

/**
 *
 * @author Nicolás
 */
public class Mozo implements Runnable {

    private String nombre;
    private PollosHermanos tienda;

    public Mozo(PollosHermanos tiend) {
        this.nombre = "Gustavo Fring";
        this.tienda = tiend;
    }

    public void run() {
        System.out.println("Hola! Soy " + nombre + ". Bienvenido a Los Pollos Hermanos!");
        while (true) {
            tienda.esperarEmpleado(nombre);
            this.atender();
            tienda.terminarAtencion();
        }
    }

    private void atender() {
        System.out.println("         Mozo dice: Estoy atendiendo a un Empleado!");
        try {
            Thread.sleep((int) (Math.random() * 856));
        } catch (InterruptedException e) {
        }
    }
}
