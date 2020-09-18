/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Ej4;

/**
 *
 * @author Nicolás
 */
public class Auto extends Vehiculo implements Runnable {

    Surtidor surti;

    private String modelo, marca, patente;
    private int kmFaltantesService = 200;
    private int combustible = 25;

    public Auto(String mod, String mar, String pat) {
        this.modelo = mod;
        this.marca = mar;
        this.patente = pat;
    }

    public boolean faltanteService(int km) {
        boolean sigue = true;
        this.kmFaltantesService--;
        if (this.kmFaltantesService <= 0) {
            this.kmFaltantesService = 0;
            sigue = false;
        }
        return sigue;
    }

    public synchronized void cargarNafta() {
        if (surti.vacante()) {
            System.out.println(Thread.currentThread().getName() + " carga nafta!");
            surti.ocupar(20);
            combustible = 25;
            System.out.println("Ahora al surtidor le quedan " + surti.getRestanteNafta());
        } else {
            System.out.println("El surtidor no está vacante aún " + Thread.currentThread().getName());
        }
    }

    public void andar() {
        ((Vehiculo) this).conducir(10);
        faltanteService(10);
        combustible -= 10;
        if (combustible <= 5) {
            System.out.println(Thread.currentThread().getName() + " se quedó sin nafta, necesita cargar!");
            cargarNafta();
        }
    }

    public void setSurtidor(Surtidor sur) {
        this.surti = sur;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            andar();
            if (surti.getRestanteNafta() <= 0) {
                i = i + 500; //PARA QUE ESTE AUTO YA NO ANDE MAS
            }
        }
    }
}
