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
public class MainDeEjercicio2 {

    public static void main(String[] args) {

        LugarPlatos lugar = new LugarPlatos(5);

        Thread[] hiloPerros = new Thread[20];
        Thread hiloEncargado = new Thread(new Encargado(lugar, "Encargado"));
        for (int i = 0; i < 19; i++) {
            hiloPerros[i] = new Thread(new Perros(lugar, "Perrito " + i));
        }
        hiloEncargado.start();
        for (int i = 0; i < 19; i++) {
            hiloPerros[i].start();
        }
    }
}
