/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Ej2;

/**
 *
 * @author Nicolás
 */
public class Vida {

    private int salud = 10;

    public Vida() {
    }

    public int getSalud() {
        return this.salud;
    }

    public void aumentarVida(int aum) {
        salud = salud + aum;
    }

    public void perderVida(int per) {
        salud = salud - per;
    }
}
