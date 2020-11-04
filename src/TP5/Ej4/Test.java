/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Ej4;

/**
 *
 * @author Nicolás
 */
public class Test {
    
    //  HECHO POR MAURO

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pista p = new Pista("Cordoba");
        Avion[] aviones = new Avion[25];
        Thread[] hilosAviones = new Thread[25];
        for (int i = 0; i < 25; i++) {
            aviones[i] = new Avion(p);
            hilosAviones[i] = new Thread(aviones[i], "Avion " + i);
        }
        for (int j = 0; j < 25; j++) {
            hilosAviones[j].start();
        }
    }

}
