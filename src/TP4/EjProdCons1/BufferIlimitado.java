/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EjProdCons1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Nicolás
 */
public class BufferIlimitado {

    private Semaphore buffer = new Semaphore(0);
    private Semaphore semProd = new Semaphore(1);
    private Semaphore semCons = new Semaphore(0);

    public void agregar() {
        try {
            semProd.acquire();
            buffer.release(1);
            semProd.release();
            System.out.println(buffer.availablePermits() + " productos en buffer");
            Thread.sleep((int) (Math.random() * 800));
        } catch (InterruptedException e) {
        }
    }

    public void avisarAlConsumidor() {
        if (semCons.availablePermits() == 0) {
            semCons.release();
        }
        System.out.println("SEM CONSUMIDOR " + semCons.availablePermits());
    }

    public void quitar(String nombreConsumidor) {
//        if (semCons.tryAcquire()) {
            try {
            semCons.acquire();
                System.out.println("----- " + nombreConsumidor + " saca un producto!");
                buffer.acquire(1);
                Thread.sleep((int) (Math.random() * 400));
            } catch (InterruptedException e) {
            }
        
    }


public void avisarAlProductor() {
        semProd.release();
    }
}
