/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VallejosFAI2003Parcial2;

/**
 *
 * @author Nicolás
 */
public class Encargado implements Runnable {

    private String nombre;
    private LugarPlatos lugar;

    public Encargado(LugarPlatos lug, String nomb) {
        nombre = nomb;
        lugar = lug;
    }

    public void run() {
        while (true) {
            try {
                lugar.esperarAviso();
                Thread.sleep((int) (Math.random() * 6000));
                lugar.avisarPerro();
            } catch (InterruptedException e) {
            }
        }
    }
}
