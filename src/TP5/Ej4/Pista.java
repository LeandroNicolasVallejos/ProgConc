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
    private Semaphore semDespegar, semPista, semAterrizajes, semAterrizo;
    private ReentrantLock lock;
    private Lista aux = new Lista();
    private int i = 1;
    int priori = 1; // 1 para prioridad aterrizajes, 2 para prioridad despegue
    int contadorAterrizados = 10;

    public Pista(String n) {
        nombre = n;
        semDespegar = new Semaphore(0);
        semAterrizo = new Semaphore(1);
        semAterrizajes = new Semaphore(10); //Para cambiar la prioridad cuando ya se pidieron 10 aterrizajes
        semPista = new Semaphore(1);//es para controlar que solo un avion este en la pista.
        lock = new ReentrantLock();
    }

    public void comunicarmeConLaTorre(int n) throws InterruptedException {
        lock.lock();
        try {
            aux.insertar(n, i);//n es el numero que se genera random en avion, de esta manera luego podre buscar si hay alguno que quiera aterrizar, que es el 1.
            i++;
        } finally {
            lock.unlock();
        }
    }

    public boolean aterrizar() throws InterruptedException {
        boolean pude = false;
        if (contadorAterrizados > 0 || aux.localizar(2) == (-1)) { // TODAVIA HAY PRIORIDAD DE ATERRIZAJE, O no hay despegues pedidos
            semAterrizo.acquire();
            System.out.println("Estoy volando quiero aterrizar, soy " + Thread.currentThread().getName());
            semPista.acquire();
            System.out.println("Soy " + Thread.currentThread().getName() + " estoy aterrizando");
            Thread.sleep((int) (Math.random() * 1000));//simula el aterrizaje
            System.out.println("Soy " + Thread.currentThread().getName() + " ATERRICE");
            semAterrizajes.acquire(); //Toma uno de los 10 permisos de aterrizaje
            pude = true;
            lock.lock();
            try {
                contadorAterrizados--;
            } finally {
                lock.unlock();
            }
            aux.eliminar(aux.localizar(1));//elimino el 1 que corresponde al avion que aterrizo.

            // CON ESTE CHEQUEO CAMBIA LA PRIORIDAD SI ES NECESARIO 
            System.out.println(contadorAterrizados);
            if (aux.localizar(1) == (-1) || contadorAterrizados == 0) {//Si encuentro un -1 en la lista es xq no hay nadie mas que quiera aterrizar, por lo tanto ya pueden despegar los qiue estan en tierra
                semDespegar.release();
            } else {
                semAterrizo.release();
            }
            semPista.release();
        } else {
            System.out.println(Thread.currentThread().getName() + " dice: No tengo prioridad de aterrizaje");
        }
        return pude;
    }

    public boolean despegar() throws InterruptedException {
        boolean pude = false;
        System.out.println("Estoy es tierra y quiero despegar, espero autorizacion, soy " + Thread.currentThread().getName());
        if (semDespegar.availablePermits() < 0) {//Me fijo si hay alguno que quiere despegar, en caso de que el localizar me devuelva un 1 entonces alguien quere aterrizar
            System.out.println("Soy " + Thread.currentThread().getName() + " no puedo despegar, hay alguien que quiere aterrizar, debo esperar");
        } else {//este caso es para cuando nadie quiere aterrizar.
            semDespegar.acquire();
            semPista.acquire();
            pude = true;
            System.out.println("Soy " + Thread.currentThread().getName() + " estoy despegando");
            Thread.sleep((int) (Math.random() * 1000));//simula el despegue
            System.out.println("Soy " + Thread.currentThread().getName() + " PUDE DESPEGAR");
            semPista.release();
            lock.lock();
            try {
                semAterrizajes.release(10 - contadorAterrizados);
                contadorAterrizados = 10; //Se reinicia el contador de prioridad
            } finally {
                lock.unlock();
            }
            semAterrizo.release();
            semDespegar.release();
        }
        return pude;
    }

//    public boolean aterrizar() throws InterruptedException {
//        boolean pudo = false;
//        System.out.println("Estoy volando, quiero aterrizar, soy " + Thread.currentThread().getName());
//        if (priori == 1) {
//            semPista.acquire();
//            semAterrizajes.acquire(); //Para evaluar la prioridad
//            contadorAterrizados--;
//            if (contadorAterrizados == 0) {
//                priori = 2; //Se cambia la prioridad a 2, así es requerido un despegue
//            }
//            pudo = true;
//            System.out.println("Soy " + Thread.currentThread().getName() + " estoy aterrizando");
//            Thread.sleep((int) (Math.random() * 2500));
//            System.out.println("Soy " + Thread.currentThread().getName() + " ATERRICE");
//            semPista.release();
//        }
//        return pudo;
//    }
//    public boolean despegar() throws InterruptedException {
//        boolean pudo = false;
//        System.out.println("Estoy es tierra quiero despegar, soy " + Thread.currentThread().getName());
//        if (priori == 2) {
//            semPista.acquire();
//            System.out.println("Soy " + Thread.currentThread().getName() + " estoy despegando");
//            Thread.sleep((int) (Math.random() * 2500));
//            System.out.println("Soy " + Thread.currentThread().getName() + " DESPEGUE");
//            semPista.release();
//            lock.lock();
//            try {
//                priori = 1; //Se vuelve la prioridad a aterrizajes
//                semAterrizajes.release(10);
//                contadorAterrizados = 10;
//            } finally {
//                lock.unlock();
//            }
//            pudo = true;
//        }
//        return pudo;
//    }
}
