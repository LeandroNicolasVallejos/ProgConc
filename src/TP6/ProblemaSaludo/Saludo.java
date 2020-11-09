/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.ProblemaSaludo;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Nicolás
 */
public class Saludo {

    private final int numEmp;
    private int llegaron;
    private int saludosHechos = 0;
    private boolean saludar;
    public Saludo(int numE) {
        numEmp = numE;
        saludar = false;
        llegaron = 0;
    }

    synchronized void esperarJefe(String empleado) {
        while (!saludar) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
        System.out.println(empleado + "> Buenos dias jefe!");
        saludosHechos++;
        if(saludosHechos == numEmp){
            this.notifyAll();
        }
    }
    
    synchronized void avisar(String nomb){
        System.out.println(nomb + " llego a la empresa!");
        llegaron++;
        if(llegaron == numEmp){
            this.notifyAll();
        }
    }

    synchronized void saludoJefe() throws InterruptedException {
        System.out.println("JEFE llego a la empresa!");
        while (llegaron < numEmp) {
            System.out.println("JEFE tiene que esperar!");
            this.wait();
        }
        System.out.println("JEFE> Buenos dias!");
        saludar = true;
        this.notifyAll();
        
        while(saludosHechos < numEmp){
            this.wait();
        }
        System.out.println("JEFE dice: Ya me saludaron todos!");
    }

}
