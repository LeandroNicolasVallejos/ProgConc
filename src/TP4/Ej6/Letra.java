/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ej6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class Letra implements Runnable{
    private Turno turno;
    private String nombre;
    private int cantidadOcurrencias;
    public Letra(Turno t, int cant, String nom){
        this.turno=t;
        this.cantidadOcurrencias=cant;
        this.nombre=nom;
    }
   
   
    public void run(){
        while(true){
        turno.imprimir(nombre,cantidadOcurrencias);
        }
    }
}
