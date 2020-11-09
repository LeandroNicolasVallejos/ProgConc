/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.ProblemaSaludo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class Jefe implements Runnable{
    private Saludo saludo;
    public Jefe(Saludo sal){
        saludo = sal;
    }
    
    public void run(){
        try {
            saludo.saludoJefe();
        } catch (InterruptedException ex) {
            Logger.getLogger(Jefe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
