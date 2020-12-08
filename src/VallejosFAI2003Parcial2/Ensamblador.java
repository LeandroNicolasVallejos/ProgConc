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
public class Ensamblador implements Runnable {

    private String nombre;
    private Taller taller;

    public Ensamblador(Taller tal, String nomb) {
        nombre = nomb;
        taller = tal;
    }

    public void run() {
        while (true) {
            try {
                taller.ensamblar(nombre);
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
            }
        }
    }
}
