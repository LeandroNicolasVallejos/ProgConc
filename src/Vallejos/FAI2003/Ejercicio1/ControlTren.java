/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vallejos.FAI2003.Ejercicio1;


/**
 *
 * @author Nicolás
 */
public class ControlTren implements Runnable {

    private Tren tren;
    int tiempoVuelta;

    public ControlTren(Tren trencito) {
        tren = trencito;
    }

    private void darVuelta() { //Da la vuelta con el tren
        try {
            tiempoVuelta = (int) (Math.random() * 9000);
            Thread.sleep(tiempoVuelta);
        } catch (InterruptedException e) {
        }
    }

    public void run() {
        while (true) {
            tren.esperarVuelta();
            this.darVuelta();
            tren.reinicioVuelta();
        }
    }
}
