/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.Ej4;

/**
 *
 * @author Nicolás
 */
public class TestSoldados {

    public static void main(String[] args) {
        Recinto recinto = new Recinto(7, 15, 5);
        Thread[] hiloSoldados = new Thread[50];
        for (int i = 0; i < 50; i++) {
            int num = (int) (Math.random() * 2) + 1;
            int num2 = (int) (Math.random() * 2) + 1;
            hiloSoldados[i] = new Thread(new Soldado(recinto, "Soldado " + i, num, num2));
        }
        
        for(int i = 0; i < 50; i++){
            hiloSoldados[i].start();
        }
    }
}
