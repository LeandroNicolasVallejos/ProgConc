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
public class Ruedita {
        private ReentrantLock lockRuedita;
    
    public Ruedita(){
        this.lockRuedita = new ReentrantLock();
    }
    
    public void correrRuedita(String nombreHam){
        lockRuedita.lock();
        try{
            System.out.println("Soy el hamster "+nombreHam+" y estoy corriendo en la ruedita!" );
            Thread.sleep((int) (Math.random() * 746));
        }catch(InterruptedException e){
            
        }
        finally{lockRuedita.unlock();}
    }
}
