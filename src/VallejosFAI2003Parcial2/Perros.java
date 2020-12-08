/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VallejosFAI2003Parcial2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class Perros implements Runnable {

    private String nombre;
    private LugarPlatos lugar;
    private boolean noComi = true;

    public Perros(LugarPlatos lug, String nomb) {
        nombre = nomb;
        lugar = lug;
    }

    public void run() {
        while (noComi) {
            try {
                if (lugar.comer(nombre)) { //El perro pudo comer
                    Thread.sleep((int) (Math.random() * 5000));
                    lugar.terminarDeComer(nombre);
                    noComi = false;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Perros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
