/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Ej4;

/**
 *
 * @author Nicolás
 */
public class Nodo {

    private Object elemento;
    private Nodo enlace;

    public Nodo(Object elem, Nodo enla) {
        this.elemento = elem;
        this.enlace = enla;
    }

    public Nodo(Object elem) {
        this.elemento = elem;
    }

    public Object getElemento() {
        return this.elemento;
    }

    public void setElem(Object elem) {
        this.elemento = elem;
    }

    public Nodo getEnlace() {
        return this.enlace;
    }

    public void setEnlace(Nodo enla) {
        this.enlace = enla;
    }

}
