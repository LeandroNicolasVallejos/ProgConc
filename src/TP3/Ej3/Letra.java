/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Ej3;

/**
 *
 * @author Nicolás
 */
public class Letra implements Runnable {

    private Turno turno = new Turno();
    String h = "";
    public Letra() {
    }
    
    boolean aux;
    
    
    public synchronized void pedirTurno(){
        h = turno.autorizacion(Thread.currentThread().getName());
        System.out.println(h);
//        if(aux){
//            System.out.println("ASDASDASD");
//            //que se imprima la letra correspondiente
//        }
    }
    

    public void run() {
//        for(int i = 0; i < 15; i++)
        pedirTurno();
        
       
    }
}
