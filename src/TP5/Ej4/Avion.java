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
public class Avion implements Runnable {

    private Pista pista;
    private int r;//random para aterrizar o despegar

    public Avion(Pista p) {
        pista = p;
        r = (int) (Math.random() * 2) + 1;
    }

    private void pedirAterrizar() throws InterruptedException {
        boolean pudeAterrizar = false;
        while (!pudeAterrizar) {
            pudeAterrizar = pista.aterrizar();
            if (!pudeAterrizar) {
                Thread.sleep((int) (Math.random() * 5000));
            }
        }
    }

    private void pedirDespegar() throws InterruptedException {
        boolean pudeDespegar = false;
        while (!pudeDespegar) {
            pudeDespegar = pista.despegar();
            if (!pudeDespegar) {
                Thread.sleep((int) (Math.random() * 5000));
            }
        }
    }

    public void run() {
        try {
            switch (r) {
                case 1:
                    //System.out.println("Estoy volando quiero aterrizar, soy " + Thread.currentThread().getName());
                    pista.comunicarmeConLaTorre(r);
                    this.pedirAterrizar();
                    break;
                case 2:
                    //System.out.println("Estoy es tierra quiero despegar, soy " + Thread.currentThread().getName());
                    pista.comunicarmeConLaTorre(r);
                    this.pedirDespegar();
                    break;
            }
        } catch (InterruptedException e) {
        }
    }
}
