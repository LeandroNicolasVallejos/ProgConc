/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej12;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Nicolás
 */
public class Plato {
            private ReentrantLock lockPlatito;
    
    public Plato(){
        this.lockPlatito = new ReentrantLock();
    }
    
    public void comerPlatito(String nombreHam){
        lockPlatito.lock();
        try{
            System.out.println("Soy el hamster "+nombreHam+" y estoy comiendo en el platito" );
            Thread.sleep((int) (Math.random() * 906));
        }catch(InterruptedException e){
            
        }
        finally{lockPlatito.unlock();}
    }
}
