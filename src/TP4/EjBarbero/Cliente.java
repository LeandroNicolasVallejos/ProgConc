/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EjBarbero;

/**
 *
 * @author Nicolás
 */
public class Cliente implements Runnable {

    public static final String ANSI_RED = "\u001B[31m";

    private String miNombre;
    private Barberia bar;

    public Cliente(Barberia barbe, String nomb) {
        this.bar = barbe;
        this.miNombre = nomb;
    }

    private void irBarberia() {
        System.out.println(ANSI_RED + "Soy " + miNombre + " y voy a la barberia");
        try {
            Thread.sleep((int) (Math.random() * 500));
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void run() {
        this.irBarberia();
        if (bar.entrarBarberia(miNombre)) {
            bar.solicitoCorte(miNombre);
            bar.salir();
            System.out.println(ANSI_RED + "Soy " + miNombre + ", y ya dejé la barberia!");
        } else {
            System.out.println(ANSI_RED + "Soy " + miNombre + ", la barberia no tiene mas sillas de espera. Me voy!");
        }
    }
}
