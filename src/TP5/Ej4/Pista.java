/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Ej4;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Nicolás
 */
public class Pista {

    private String nombre;
    private Semaphore semDespegar, semPista, semAterrizajes;
    private ReentrantLock lock;
    private Lista aux = new Lista();
    private int i = 1;
    int priori = 1; // 1 para prioridad aterrizajes, 2 para prioridad despegue
    int contadorAterrizados = 10;

    public Pista(String n) {
        nombre = n;
        semDespegar = new Semaphore(0);
        semAterrizajes = new Semaphore(10); //Para cambiar la prioridad cuando ya se pidieron 10 aterrizajes
        semPista = new Semaphore(1);//es para controlar que solo un avion este en la pista.
        lock = new ReentrantLock();
    }

    public void comunicarmeConLaTorre(int n) throws InterruptedException {
        System.out.println("Me comunique con la central para pedir autorizacion, soy: " + Thread.currentThread().getName());
    }

    public boolean aterrizar() throws InterruptedException {
        boolean pudo = false;
        System.out.println("Estoy volando, quiero aterrizar, soy " + Thread.currentThread().getName());
        if (priori == 1) {
            semPista.acquire();
            semAterrizajes.acquire(); //Para evaluar la prioridad
            contadorAterrizados--;
            if (contadorAterrizados == 0) {
                priori = 2; //Se cambia la prioridad a 2, así es requerido un despegue
            }
            pudo = true;
            System.out.println("Soy " + Thread.currentThread().getName() + " estoy aterrizando");
            Thread.sleep((int) (Math.random() * 2500));
            System.out.println("Soy " + Thread.currentThread().getName() + " ATERRICE");
            semPista.release();
        }
        return pudo;

    }

    public boolean despegar() throws InterruptedException {
        boolean pudo = false;
        System.out.println("Estoy es tierra quiero despegar, soy " + Thread.currentThread().getName());
        if (priori == 2) {
            semPista.acquire();
            System.out.println("Soy " + Thread.currentThread().getName() + " estoy despegando");
            Thread.sleep((int) (Math.random() * 2500));
            System.out.println("Soy " + Thread.currentThread().getName() + " DESPEGUE");
            semPista.release();
            lock.lock();
            try {
                priori = 1; //Se vuelve la prioridad a aterrizajes
                semAterrizajes.release(10);
                contadorAterrizados = 10;
            } finally {
                lock.unlock();
            }
            pudo = true;
        }
        return pudo;
    }
}
