/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Ej3;

/**
 *
 * @author Nicolás
 */
public class Main {

    public static void main(String[] args) {

        Letra la = new Letra();

        Thread A = new Thread(la, "La");
        Thread B = new Thread(la, "Lb");
        Thread C = new Thread(la, "Lc");

        A.start();
        B.start();
        C.start();
        
        
    }
}
