/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.Ej2;

/**
 *
 * @author Nicolás
 */
public class SalaMuseo {

    private int cantPersonas, tempActual, tUmbral, capacidadActual;

    private int jubiladosEsperando;

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";

    private synchronized boolean lleno() {
        return (cantPersonas >= capacidadActual);
    }

    public SalaMuseo() {
        capacidadActual = 50;
        jubiladosEsperando = 0;
        cantPersonas = 0;
        tempActual = 0;
        tUmbral = 30;
    }

    public synchronized void entrarSala(String nombre) throws InterruptedException {
        while (lleno() || jubiladosEsperando > 0) {
            this.wait();
        }
        System.out.println(nombre + "entra!");

        cantPersonas++;
    }

    public synchronized void salirSala() {
        System.out.println("       Se va una persona, quedan " + cantPersonas);
        cantPersonas--;
        this.notifyAll();
    }

    public synchronized void entrarSalaJubilado(String nombre) throws InterruptedException {
        jubiladosEsperando++;
        while (lleno()) {

            this.wait();
        }
        System.out.println(ANSI_BLUE + "JUBILADO " + nombre + " entra!");
        jubiladosEsperando--;
        cantPersonas++;
    }

    private synchronized void bajarCapacidad() {
        capacidadActual = 35;
    }

    private synchronized void subirCapacidad() {
        capacidadActual = 50;
    }

    public int getUmbral() {
        return tUmbral;
    }

    public void reiniciarTemperatura() {
        System.out.println(ANSI_RED + "      SE REINICIA LA TEMP A 0, CAPACIDAD NORMAL");
        tempActual = 0;
        subirCapacidad();
    }

    public int pedirTemperatura() {
        int num = this.tempActual + (int) (Math.random() * 25);
        tempActual = num;
        System.out.println(ANSI_RED + "      TEMP ACTUAL: " + num + " grados");
        System.out.println(ANSI_RED + "      ACTUALMENTE HAY " + cantPersonas + " PERSONAS ADENTRO");
        System.out.println(ANSI_RED + "      ACTUALMENTE HAY " + jubiladosEsperando + " JUBILADOS ESPERANDO");
        return num;
    }

    public synchronized void notificarTemperatura(int temperatura) {
        if (temperatura >= tUmbral && capacidadActual == 50) {
            bajarCapacidad();
            System.out.println(ANSI_RED + "SE SUPERÓ LA TEMPERATURA UMBRAL, SE LIMITA A 35 PERSONAS");
        }
        this.notifyAll();
    }
}
