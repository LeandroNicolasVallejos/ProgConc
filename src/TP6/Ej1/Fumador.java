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
public class Fumador implements Runnable {

    private int id;
    private SalaFumadores sala;
    private String ingrediente;

    public static final String ANSI_RED = "\u001B[31m";

    public Fumador(int id, SalaFumadores sala) {
        this.id = id;
        switch (id) {
            case 1:
                ingrediente = "tabaco";
            case 2:
                ingrediente = "papel";
            case 3:
                ingrediente = "fosforos";
        }
        this.sala = sala;
    }//constructor

    public void run() {
        while (true) {
            // ...
            try {
                sala.entrafumar(id);
                System.out.println(ANSI_RED + "----> FUMADOR " + id + " está fumando");
                Thread.sleep(1000);
                sala.terminafumar(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }//catch
        }//while
    }//run
}// clase
