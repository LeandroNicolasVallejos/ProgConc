/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Ej4;

/**
 *
 * @author Nicolás
 */
public class Surtidor {

    private boolean disponible = true;
    private boolean conNafta = true;
    private int cantidadTotal = 80;
    
    public int getRestanteNafta(){
        return this.cantidadTotal;
    }

    public boolean vacante() {
        if(!conNafta){
            System.out.println("EL SURTIDOR SE QUEDO SIN NAFTA");
        }
        return disponible && conNafta;
    }

    public synchronized void ocupar(int cant) {
        if (conNafta) {
            disponible = false;
            sacarNafta(cant);
        } else {
            System.out.println("EL SURTIDOR NO TIENE MAS NAFTA!");
        }
    }

    private synchronized void sacarNafta(int cant) {
        cantidadTotal -= cant;
        if(cantidadTotal <=0){
            conNafta = false;
        }
    }

    public void liberar() {
        disponible = true;
    }
}
