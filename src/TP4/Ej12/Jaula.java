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
public class Jaula {

    private ReentrantLock lockRuedita, lockHamaca, lockPlato;
    
    public void Jaula(){
        lockRuedita = new ReentrantLock();
        lockHamaca = new ReentrantLock();
        lockPlato = new ReentrantLock();
    }

    public void correrRuedita(String nombreHamster) {
        try {
            lockRuedita.lock();
            System.out.println("Soy " + nombreHamster + " y estoy usando la ruedita!");
            Thread.sleep((int) (Math.random() * 756));
        } catch (InterruptedException e) {
        }
        lockRuedita.unlock();
    }

    public void dormirHamaca(String nombreHamster) {
        try {
            lockHamaca.lock();
            System.out.println("Soy " + nombreHamster + " y estoy durmiendo en la hamaca!");
            Thread.sleep((int) (Math.random() * 689));
        } catch (InterruptedException e) {
        }lockHamaca.unlock();
    }

    public void comerPlato(String nombreHamster) {
        try {
            lockPlato.lock();
            System.out.println("Soy " + nombreHamster + " y estoy comiendo en el plato!");
            Thread.sleep((int) (Math.random() * 900));
        } catch (InterruptedException e) {
        }lockPlato.unlock();
    }
}
