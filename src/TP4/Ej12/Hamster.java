/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej12;

/**
 *
 * @author Nicolás
 */
public class Hamster implements Runnable {

    private String nombre;
    private Plato plato;
    private Hamaca hamaca;
    private Ruedita rueda;
    
    public Hamster(String nomb, Plato plat, Hamaca hama, Ruedita rued) {
        this.nombre = nomb;
        this.plato = plat;
        this.hamaca = hama;
        this.rueda = rued;
    }
    
    public void run() {
        System.out.println("Soy el hamster " + nombre);
        plato.comerPlatito(nombre);
        rueda.correrRuedita(nombre);
        hamaca.dormirHamaca(nombre);
    }
}
