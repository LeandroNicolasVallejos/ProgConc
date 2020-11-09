/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.Ej2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class GestorSala implements Runnable{
    private SalaMuseo museo;
    
    public GestorSala(SalaMuseo mus){
        museo = mus;
    }
    
    
    public void run(){
        while(true){
            int temp = museo.pedirTemperatura();
            museo.notificarTemperatura(temp);
            if(temp >= museo.getUmbral()){
                try {
                    Thread.sleep(10000);
                    museo.reiniciarTemperatura();
                } catch (InterruptedException ex) {
                    Logger.getLogger(GestorSala.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GestorSala.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
