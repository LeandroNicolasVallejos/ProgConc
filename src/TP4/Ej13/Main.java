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
public class Main {

    public static void main(String[] args) {
        PollosHermanos tienda = new PollosHermanos();
        Mozo mozo = new Mozo(tienda);
        Thread hiloMozo = new Thread(mozo);
        hiloMozo.start();
        Cocinero cocinero = new Cocinero("Cocinero 1", tienda);
        Thread hiloCocinero = new Thread(cocinero);
        hiloCocinero.start();
        Thread[] hiloEmpleados = new Thread[15];
        for (int i = 0; i < 14; i++) {
            Empleado emp = new Empleado("Empleado " + i, tienda);
            hiloEmpleados[i] = new Thread(emp);
        }

        for (int x = 0; x < 14; x++) {
            hiloEmpleados[x].start();
            try {
                Thread.sleep((int) (Math.random() * 500));
            } catch (InterruptedException e) {
            }
        }
    }
}
