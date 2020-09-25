/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej8;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Nicolás
 */
public class Testigo {

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
    private Semaphore semA, semB, semC;
    int numeroAleatorio;

    public Testigo() {
        semA = new Semaphore(0);
        semB = new Semaphore(0);
        semC = new Semaphore(0);
    }

    public void correrAt1() throws InterruptedException {
        System.out.println(ANSI_RED + "Atleta 1" + ANSI_RESET + " empieza a correr!");
        numeroAleatorio = (int) (Math.random() * 3 + 1) + 8;
        Thread.sleep(numeroAleatorio * 1000);
        System.out.println(ANSI_RED + "Atleta 1" + ANSI_RESET + " corrio " + numeroAleatorio + " segundos!");
        semA.release();
    }

    public void correrAt2() throws InterruptedException {
        semA.acquire();
        System.out.println(ANSI_GREEN + "Atleta 2" + ANSI_RESET + " empieza a correr!");
        numeroAleatorio = (int) (Math.random() * 3 + 1) + 8;
        Thread.sleep(numeroAleatorio * 1000);
        System.out.println(ANSI_GREEN + "Atleta 2" + ANSI_RESET + " corrio " + numeroAleatorio + " segundos!");
        semB.release();
    }

    public void correrAt3() throws InterruptedException {
        semB.acquire();
        System.out.println(ANSI_BLUE + "Atleta 3" + ANSI_RESET + " empieza a correr!");
        numeroAleatorio = (int) (Math.random() * 3 + 1) + 8;
        Thread.sleep(numeroAleatorio * 1000);
        System.out.println(ANSI_BLUE + "Atleta 3" + ANSI_RESET + " corrio " + numeroAleatorio + " segundos!");
        semC.release();
    }

    public void correrAt4() throws InterruptedException {
        semC.acquire();
        System.out.println(ANSI_PURPLE + "Atleta 4" + ANSI_RESET + " empieza a correr!");
        numeroAleatorio = (int) (Math.random() * 3 + 1) + 8;
        Thread.sleep(numeroAleatorio * 1000);
        System.out.println(ANSI_PURPLE + "Atleta 4" + ANSI_RESET + " corrio " + numeroAleatorio + " segundos!");
    }
}
