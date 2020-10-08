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
public class Hamaca {
    private ReentrantLock lockHamaca;
    
    public Hamaca(){
        this.lockHamaca = new ReentrantLock();
    }
    
    public void dormirHamaca(String nombreHam){
        lockHamaca.lock();
        try{
            System.out.println("Soy el hamster "+nombreHam+" y estoy descansando en la hamaca!" );
            Thread.sleep((int) (Math.random() * 676));
        }catch(InterruptedException e){
            
        }
        finally{lockHamaca.unlock();}
    }
}
