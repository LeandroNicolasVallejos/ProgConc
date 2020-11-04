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
public class Lista {

    private Nodo cabecera;
    private int longitud;

    public Lista() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public boolean insertar(Object nuevoElem, int pos) {
        boolean exito = false;
        if (pos > 0 && pos <= longitud + 1) {

            if (pos == 1) {
                this.cabecera = new Nodo(nuevoElem, this.cabecera);
            } else {
                int i = 1;
                Nodo aux = this.cabecera;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevoNodo = new Nodo(nuevoElem);
                nuevoNodo.setEnlace(aux.getEnlace());
                aux.setEnlace(nuevoNodo);
            }
            this.longitud += 1;
            exito = true;
        }
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito = false;
        if (pos > 0 && pos <= this.longitud && !(this.esVacia())) {
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            this.longitud -= 1;
            exito = true;
        }
        return exito;
    }

    public Object recuperar(int pos) {
        Object elemento = null;
        if (!(esVacia()) && pos > 0 && pos <= longitud()) {
            if (pos == 1) {
                elemento = this.cabecera.getElemento();
            } else {
                int i = 0;
                Nodo aux = this.cabecera;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                elemento = aux.getElemento();
            }
        }
        return elemento;
    }

    public int localizar(Object elem) {
        int pos;
        if (esVacia()) {
            pos = -1;
        } else {
            pos = 1;
            Nodo aux = this.cabecera;
            boolean encontrado = false;
            while (!encontrado && pos <= this.longitud) {
                if (aux.getElemento().equals(elem)) {
                    encontrado = true;
                } else {
                    aux = aux.getEnlace();
                    pos++;
                }
            }
            if (!encontrado) {
                pos = -1;
            }
        }
        return pos;
    }

    public int longitud() {
        return this.longitud;
    }

    public boolean esVacia() {
        boolean vacia = false;
        if (this.cabecera == null) {
            vacia = true;
        }
        return vacia;
    }

    public void vaciar() {
        this.cabecera = null;
    }

    public String toString() {
        String cadena = "";
        if (this.cabecera == null) {
            cadena = "Lista vacia";
        } else {
            cadena = "[";
            Nodo aux = this.cabecera;
            while (aux != null) {
                cadena += aux.getElemento();
                aux = aux.getEnlace();
                if (aux != null) {
                    cadena += ",";
                }
            }
            cadena += "]";
        }
        return cadena;
    }

    public Nodo cloneNodos(Nodo nodo) {
        Nodo nuevoNodo;
        if (nodo.getEnlace() == null) {
            nuevoNodo = new Nodo(nodo.getElemento());
        } else {
            nuevoNodo = new Nodo(nodo.getElemento(), cloneNodos(nodo.getEnlace()));
        }
        return nuevoNodo;
    }

    public Lista clone() {
        Lista listaClon = new Lista();
        listaClon.cabecera = cloneNodos(this.cabecera);
        listaClon.longitud = this.longitud;
        return listaClon;
    }

}
