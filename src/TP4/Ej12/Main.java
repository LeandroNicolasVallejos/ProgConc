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
public class Main {
    public static void main(String[] args) {
        Hamaca h = new Hamaca();
        Plato p = new Plato();
        Ruedita r = new Ruedita();
        Thread[] hiloHamsters = new Thread[3];

        for(int i = 0; i < 3; i++){
            Hamster ham = new Hamster("Hamster "+i, p, h, r);
            hiloHamsters[i] = new Thread(ham);
        }
        for(int x = 0; x < 3; x++){
            hiloHamsters[x].start();
        }
    }
}
