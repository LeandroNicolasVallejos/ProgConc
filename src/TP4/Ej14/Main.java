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
public class Main {

    public static void main(String[] args) {
        PollosHermanos tienda = new PollosHermanos();
        Mozo mozo = new Mozo(tienda);
        Thread hiloMozo = new Thread(mozo);
        hiloMozo.start();

        Cocinero cocinero1 = new Cocinero("Cocinero 1", tienda);
        Thread hiloCocinero1 = new Thread(cocinero1);
        hiloCocinero1.start();

        Cocinero cocinero2 = new Cocinero("Cocinero 2", tienda);
        Thread hiloCocinero2 = new Thread(cocinero2);
        hiloCocinero2.start();

        Thread[] hiloEmpleados = new Thread[15];
        for (int i = 0; i < 14; i++) {
            Empleado emp = new Empleado("Empleado " + i, tienda);
            hiloEmpleados[i] = new Thread(emp);
        }

        for (int x = 0; x < 14; x++) {
            hiloEmpleados[x].start();
        }
    }
}
