/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej8;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Nicolás
 */
public class Testigo {

    public Semaphore sem1, sem2, sem3;
    
    public Testigo() {
        sem1 = new Semaphore(0);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
    }
    
}
