/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Ej4;

/**
 *
 * @author Nicolás
 */
public class Main {

    public static void main(String[] args) {
        Surtidor surti = new Surtidor();
        Auto[] col = new Auto[5];
        Thread[] colT = new Thread[5];
        for(int i = 0; i <5; i++){
            col[i] = new Auto("A3","Audi", "AAA"+i+i);
            col[i].setSurtidor(surti);
            colT[i] = new Thread(col[i], "AAA"+i+i);
        }
        for(int x = 0; x <5; x++){
            colT[x].start();
        }
    }
}
