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
public class Cocinero implements Runnable {

    public static final String ANSI_CYAN = "\u001B[36m";

    private String nombre;
    private PollosHermanos tienda;

    public Cocinero(String nom, PollosHermanos tiend) {
        this.nombre = nom;
        this.tienda = tiend;
    }

    public void cocinar() {
        System.out.println(ANSI_CYAN + "            Soy " + nombre + " y estoy preparando una comida para darle al Cliente!");
        try {
            Thread.sleep((int) (Math.random() * 400));
        } catch (InterruptedException e) {
        }
    }

    public void run() {
        System.out.println("Hola! Soy el cocinero " + nombre);
        while (true) {
            tienda.esperarPedidoComida(nombre);
            this.cocinar();
        }
    }
}
