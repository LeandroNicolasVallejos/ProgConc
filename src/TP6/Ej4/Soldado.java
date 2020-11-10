/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.Ej4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class Soldado implements Runnable {

    public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_PURPLE = "\u001B[35m";
public static final String ANSI_CYAN = "\u001B[36m";
    private boolean quieroPostre;
    private boolean quieroGaseosa;
    private Recinto recinto;
    private String nombre;
    private boolean comi;

    public Soldado(Recinto r, String nom, int q1, int q2) {
        comi = false;
        recinto = r;
        nombre = nom;
        quieroPostre = false;
        quieroGaseosa = false;
        if (q1 == 2) {
            quieroPostre = true;
        }
        if (q2 == 2) {
            quieroGaseosa = true;
        }
    }

    public void run() {
        while (!comi) {
            try {
                recinto.tomarBandeja(nombre);
                System.out.println(ANSI_RED + nombre + " SACA UNA BANDEJA DEL MOSTRADOR!");
                Thread.sleep((int) (Math.random() * 5000));
                recinto.dejarMostrador();
                System.out.println(ANSI_BLUE + nombre + " DEJO EL MOSTRADOR");
                if (quieroGaseosa) {
                    recinto.tomarGaseosa(nombre);
                    System.out.println(ANSI_RED + nombre + " ABRE GASEOSA CON ABRIDOR!");
                    Thread.sleep((int) (Math.random() * 5000));
                    recinto.dejarAbridor();
                    System.out.println(ANSI_CYAN + nombre+ " DEJA EL ABRIDOR");
                } else {
                    System.out.println(nombre + " toma solo agua!");
                }
                if (quieroPostre) {
                    recinto.tomarPostre(nombre);
                    System.out.println(ANSI_RED + nombre + " SACA UN POSTRE DEL MOSTRADOR DE POSTRES!");
                    Thread.sleep((int) (Math.random() * 5000));
                    recinto.dejarMostradorPostre();
                    System.out.println(ANSI_PURPLE + nombre+ " DEJA EL MOSTRADOR DE POSTRES");
                } else {
                    System.out.println(nombre + " no quiere postre!");
                }
                comi = true;
            } catch (InterruptedException ex) {
                Logger.getLogger(Soldado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
