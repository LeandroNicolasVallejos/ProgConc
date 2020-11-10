/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.Ej4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Nicolás
 */
public class Recinto {

    private int mostradorLibre, abridorLibre, postreLibre;
    private Semaphore mostradores, abridores, mostradorPostre;

    public Recinto(int cantMost, int cantAbr, int cantPost) {
        mostradores = new Semaphore(cantMost);
        abridores = new Semaphore(cantAbr);
        mostradorPostre = new Semaphore(cantPost);

        mostradorLibre = cantMost;
        postreLibre = cantPost;
        abridorLibre = cantAbr;

    }

    public synchronized void tomarBandeja(String nombreSold) throws InterruptedException {
        while (mostradorLibre <= 0) {
            System.out.println(nombreSold + " dice: NO hay mostrador libre! A esperar!");
            this.wait();
        }
        mostradores.acquire();
        mostradorLibre--;
    }

    public synchronized void dejarMostrador() {
        mostradores.release();
        mostradorLibre++;
        this.notify();
    }

    public synchronized void tomarGaseosa(String nombreSold) throws InterruptedException {
        while (abridorLibre <= 0) {
            System.out.println(nombreSold + " dice: NO hay abridores libres para la gaseosa! A esperar!");
            this.wait();
        }
        abridores.acquire();
        abridorLibre--;
    }

    public synchronized void dejarAbridor() {
        abridores.release();
        abridorLibre++;
        this.notify();
    }
    
    public synchronized void tomarPostre(String nombreSold)throws InterruptedException{
        while(postreLibre <= 0){
            System.out.println(nombreSold+" dice: NO hay mostrador de POSTRE libre! A esperar!");
            this.wait();
        }
        mostradorPostre.acquire();
        postreLibre--;
    }
    
    public synchronized void dejarMostradorPostre(){
        mostradorPostre.release();
        postreLibre++;
        this.notify();
    }
}
