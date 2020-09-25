/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class Atleta implements Runnable {

    //COLORES
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_RESET = "\u001B[0m";

    //COLORES
    private Testigo testigo;
    int numeroAleatorio;

    public Atleta(Testigo test) {
        testigo = test;
    }

    public void correrAt1() throws InterruptedException {
        System.out.println(ANSI_RED + "Atleta 1" + ANSI_RESET + " empieza a correr!");
        numeroAleatorio = (int) (Math.random() * 3 + 1) + 8;
        Thread.sleep(numeroAleatorio * 1000);
        System.out.println(ANSI_RED + "Atleta 1" + ANSI_RESET + " corrio " + numeroAleatorio + " segundos!");
        testigo.sem1.release();
    }

    private void correrAt2() throws InterruptedException {
        testigo.sem1.acquire();
        System.out.println(ANSI_GREEN + "Atleta 2" + ANSI_RESET + " empieza a correr!");
        numeroAleatorio = (int) (Math.random() * 3 + 1) + 8;
        Thread.sleep(numeroAleatorio * 1000);
        System.out.println(ANSI_GREEN + "Atleta 2" + ANSI_RESET + " corrio " + numeroAleatorio + " segundos!");
        testigo.sem2.release();
    }

    private void correrAt3() throws InterruptedException {
        testigo.sem2.acquire();
        System.out.println(ANSI_BLUE + "Atleta 3" + ANSI_RESET + " empieza a correr!");
        numeroAleatorio = (int) (Math.random() * 3 + 1) + 8;
        Thread.sleep(numeroAleatorio * 1000);
        System.out.println(ANSI_BLUE + "Atleta 3" + ANSI_RESET + " corrio " + numeroAleatorio + " segundos!");
        testigo.sem3.release();
    }

    private void correrAt4() throws InterruptedException {
        testigo.sem3.acquire();
        System.out.println(ANSI_PURPLE + "Atleta 4" + ANSI_RESET + " empieza a correr!");
        numeroAleatorio = (int) (Math.random() * 3 + 1) + 8;
        Thread.sleep(numeroAleatorio * 1000);
        System.out.println(ANSI_PURPLE + "Atleta 4" + ANSI_RESET + " corrio " + numeroAleatorio + " segundos!");
    }

    @Override
    public void run() {

        try {
            switch (Thread.currentThread().getName()) {
                case "Atleta 1":
                    correrAt1();
                    break;
                case "Atleta 2":
                    correrAt2();
                    break;
                case "Atleta 3":
                    correrAt3();
                    break;
                case "Atleta 4":
                    correrAt4();
                    break;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
