/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.EjProdCons1;

/**
 *
 * @author Nicolás
 */
public class Consumidor implements Runnable{
    
    private String nombre;
    private BufferIlimitado buf;
    
    public Consumidor(String nom, BufferIlimitado buffer){
        this.nombre = nom;
        this.buf = buffer;
    }
    
    private void consumir(){
        buf.quitar(nombre);
    }
    
    public void run(){
        System.out.println("Soy el consumidor "+nombre);
        while(true){
            this.consumir();
        }
    }
}
