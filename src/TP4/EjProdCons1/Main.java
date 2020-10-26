/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EjProdCons1;

/**
 *
 * @author Nicolás
 */
public class Main {
        public static void main(String[] args) {
            
            BufferIlimitado buffer = new BufferIlimitado();
            Thread[] hiloProductores = new Thread[6];
            Thread[] hiloConsumidores = new Thread[8];
            
            for(int x = 0; x < 5; x++){
                Productor prod = new Productor("Prod "+x, buffer);
                hiloProductores[x] = new Thread(prod);
            }
            for(int i = 0; i < 5; i++){
                hiloProductores[i].start();
            }
            for(int a = 0; a < 7; a++){
                Consumidor cons = new Consumidor("Cons "+a, buffer);
                hiloConsumidores[a] = new Thread(cons);
            }
            for(int b = 0; b < 7; b++){
                hiloConsumidores[b].start();
            }
        }
}
