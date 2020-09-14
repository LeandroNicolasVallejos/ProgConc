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

    Letra La = new Letra();
    Letra Lb = new Letra();
    Letra Lc = new Letra();
    
    Thread A = new Thread(La, "La");
    Thread B = new Thread(Lb, "Lb");
    Thread C = new Thread(Lc, "Lc");
    
    A.start();
    B.start();
    C.start();
}
}