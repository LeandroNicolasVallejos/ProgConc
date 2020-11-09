/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.Ej1;

/**
 *
 * @author Nicolás
 */
public class SalaFumadores {

    private int ing1, ing2;
    private boolean hayIngredientes;
    public static final String ANSI_BLUE = "\u001B[34m";

    public SalaFumadores() {

        hayIngredientes = false;
    }

    public synchronized void colocar(int col, int col2) throws InterruptedException {
        while (hayIngredientes) {
            System.out.println("Hay alguien fumando, el agente tiene que esperar");
            this.wait();
        }
        ing1 = col;
        ing2 = col2;
        System.out.println(ANSI_BLUE + "---->  AGENTE colocó " + ing1 + " y " + ing2 + " sobre la mesa!");
        hayIngredientes = true;
        this.notifyAll();
    }

    public synchronized void entrafumar(int id) throws InterruptedException {
        while (((id == ing1) || (id == ing2)) || !hayIngredientes) {
            System.out.println("FUMADOR " + id + " debe esperar, no están los ingredientes que le faltan");
            this.wait();
        }
    }

    public synchronized void terminafumar(int id) {
        System.out.println("      FUMADOR " + id + " dejó de fumar");
        hayIngredientes = false;
        this.notifyAll();
    }
}
