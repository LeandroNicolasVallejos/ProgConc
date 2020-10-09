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
public class Empleado implements Runnable {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    private String nombre;
    private PollosHermanos tienda;
    int numSilla;
    
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
        numSilla = tienda.entrarTienda(nombre);
        if (numSilla == 1 || numSilla == 2) {
            tienda.pidoAtencion(nombre);
            tienda.pedirComidaCocinero(nombre);
            System.out.println(ANSI_BLUE + "          ----- Soy el empleado " + nombre + " y estoy comiendo en la silla " + numSilla);
            tienda.salirTienda(nombre, numSilla);
        } else {
            System.out.println(ANSI_PURPLE + "Soy el empleado " + nombre + " y ambas sillas estan ocupadas. Renuncio y me voy.");
        }
    }
}
