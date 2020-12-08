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
public class MainDeEjercicio1 {

    public static void main(String[] args) {
        int maxMangas = 15;
        int maxCuerpos = 5;

        Taller taller = new Taller(maxMangas, maxCuerpos);

        Thread[] trabajadores = new Thread[3];
        trabajadores[0] = new Thread(new Costurera(taller, "COSTURERA"));
        trabajadores[1] = new Thread(new ArmadorCuerpos(taller, "ARMADOR CUERPOS"));
        trabajadores[2] = new Thread(new Ensamblador(taller, "ENSAMBLADOR"));

        for (int x = 0; x < 3; x++) {
            trabajadores[x].start();
        }
    }
}
