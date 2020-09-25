/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej6;

/**
 *
 * @author Nicolás
 */
public class Main {

    public static void main(String[] args) {
        Turno unTurno = new Turno();
        Letra la = new Letra(unTurno);
        Letra lb = new Letra(unTurno);
        Letra lc = new Letra(unTurno);

        Thread A = new Thread(la, "La");
        Thread B = new Thread(lb, "Lb");
        Thread C = new Thread(lc, "Lc");

        A.start();
        B.start();
        C.start();
    }
}
