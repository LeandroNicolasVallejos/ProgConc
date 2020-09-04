/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2.Ej3;

/**
 *
 * @author Nicolás
 */
public class prueba {
    public static void main(String[] args){
        PingPong[] ping = new PingPong[4];
        for(int x = 0; x < 4; x++){
            ping[x] = new PingPong("x"+x, x*13);
        }
//        PingPong ping = new PingPong("PING", 33);
//        PingPong pong = new PingPong("PONG", 10);
//        PingPong pang = new PingPong("PANG", 20);
//        PingPong pung = new PingPong("PUNG", 25);
//        
        //Creacion de hilos
        Thread[] misHilos = new Thread[4];
        for(int i = 0; i < 4; i++){
            misHilos[i] = new Thread(ping[i]);
        }
//        Thread t1 = new Thread(ping);
//        Thread t2 = new Thread(pong);
//        Thread t3 = new Thread(pang);
//        Thread t4 = new Thread(pung);
        
        //Activacion de los hilos
        for(int i = 4; i < 4; i++){
            misHilos[i].start();
        }
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
        
        //Espera unos segundos
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            
        }
        
        for(int i = 0; i < 50; i++){
            System.out.println("Hola "+i);
            try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            
        }
        }
        //Finaliza la ejecucion de los threads
    }
}
