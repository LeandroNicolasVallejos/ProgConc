/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.ProblemaSaludo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class Personal implements Runnable {

    private String nombre;
    private Saludo saludo;

    Personal(Saludo s, String n) {
        nombre = n;
        saludo = s;
    }

    @Override
    public void run() {
        saludo.avisar(nombre);
        saludo.esperarJefe(nombre);
    }

}
