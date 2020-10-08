/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Nicolás
 */
public class Turno {
    private Semaphore semA, semB,semC;
    public Turno(){
       semA= new Semaphore(1);
       semB= new Semaphore(0);
       semC= new Semaphore(0);
    }
    public void imprimir(String n,int cant){
        if(n.equalsIgnoreCase("A") && semA.tryAcquire()){
            for(int i=0;i<cant;i++){
                System.out.print("A");
            }
            semB.release();
        }else{
            if(n.equalsIgnoreCase("B") && semB.tryAcquire()){
            for(int i=0;i<cant;i++){
                System.out.print("B");
            }
            semC.release();
            }else{
                if(n.equalsIgnoreCase("C") && semC.tryAcquire()){
                    for(int i=0;i<cant;i++){
                        System.out.print("C");
                    }
                    semA.release();
                }
            }
        }
   }
}
