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
public class Productor implements Runnable {
    
    private String nombre;
    private BufferIlimitado buf;
    
    public Productor(String unNombre, BufferIlimitado buff){
        this.nombre = unNombre;
        this.buf = buff;
    }
    
    private void reponer(){
        buf.agregar();
        buf.avisarAlConsumidor();
    }
    
    public void run(){
        System.out.println("Soy el productor "+nombre);
        while(true){
            this.reponer();
        }
    }
}
