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

    public synchronized void entrarSala() throws InterruptedException {
        while (lleno() || jubiladosEsperando > 0) {
            this.wait();
        }
        cantPersonas++;
    }

    public synchronized void salirSala() {
        System.out.println("Se va una persona, quedan " + cantPersonas);
        cantPersonas--;
        this.notifyAll();
    }

    public synchronized void entrarSalaJubilado() throws InterruptedException {
        jubiladosEsperando++;
        while (lleno()) {
            
            this.wait();
        }
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
        System.out.println("      SE REINICIA LA TEMP A 0, CAPACIDAD NORMAL");
        tempActual = 0;
        subirCapacidad();
    }

    public int pedirTemperatura() {
        int num = this.tempActual + (int) (Math.random() * 25);
        tempActual = num;
        System.out.println("      TEMP ACTUAL: " + num + " grados");
        System.out.println("      ACTUALMENTE HAY " + cantPersonas + " PERSONAS ADENTRO");
        return num;
    }

    public synchronized void notificarTemperatura(int temperatura) {
        if (temperatura >= tUmbral && capacidadActual == 50) {
            bajarCapacidad();
            System.out.println("SE SUPERÓ LA TEMPERATURA UMBRAL, SE LIMITA A 35 PERSONAS");
        }
        this.notifyAll();
    }
}
