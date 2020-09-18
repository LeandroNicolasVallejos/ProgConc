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
public class Turno {

//    private char memoria = ' ';
    private String aux = "";
//    private boolean si = false;
    private int turno = 1;
    
    public synchronized void setString(String st){
        aux = aux + st;
    }
    
    public String getString(){
        return this.aux;
    }
    
    public int getNum(){
        return this.turno;
    }
    public synchronized void incrementaTurno(){
        if(turno == 1 || turno == 2){
            turno++;
        }
        else{ //Para cuando se imprimió el turno 3, volvemos al 1
            turno = 1;
        }
    }
//    public synchronized boolean tengoTurno(String nombreThread) {
//        if (nombreThread.equals("La") && (memoria == ' ' || memoria == 'c')) {
//            si = true;
//        } else {
//            if (nombreThread.equals("Lb") && (memoria == 'a')) {
//                si = true;
//            } else {
//                if (nombreThread.equals("Lc") && (memoria == 'b')) {
//                    si = true;
//                }
//            }
//        }
//        return si;
//    }
}
