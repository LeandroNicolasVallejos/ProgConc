/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.ProblemaSaludo;

/**
 *
 * @author Nicolás
 */
public class TestSaludo {

    public static void main(String argv[]) throws InterruptedException {
        int numeroEmpleados = 5;
        Saludo hola = new Saludo(numeroEmpleados);
        Thread[] personal = new Thread[5];
        Thread hiloJefe = new Thread(new Jefe(hola));
        for (int i = 0; i < 5; i++) {
            personal[i] = new Thread(new Personal(hola, "Empleado " + i));
        }
        hiloJefe.start();
        for (int i = 0; i < 5; i++) {
            personal[i].start();
        }
        hiloJefe.join();
        System.out.println("LISTO, ahora que todos han saludado - a trabajar");
    }
}
