/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej13;

/**
 *
 * @author Nicolás
 */
public class Empleado implements Runnable {

    public static final String ANSI_BLUE = "\u001B[34m";

    private String nombre;
    private PollosHermanos tienda;

    public Empleado(String nom, PollosHermanos tie) {
        this.nombre = nom;
        this.tienda = tie;
    }

    private void irATienda() {
        System.out.println("Soy " + nombre + " y estoy yendo a Los Pollos Hermanos!");
        try {
            Thread.sleep((int) (Math.random() * 857));
        } catch (InterruptedException e) {
        }
    }

    public void run() {
        this.irATienda();
        if (tienda.entrarTienda(nombre)) {
            tienda.pidoAtencion(nombre);
            System.out.println(ANSI_BLUE + "          ----- Soy el empleado " + nombre + " y estoy comiendo");
            tienda.salirTienda(nombre);
        } else {
            System.out.println("Soy el empleado " + nombre + " y no pude entrar a la tienda a comer");
        }
    }
}
