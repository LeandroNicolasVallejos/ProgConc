/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VallejosFAI2003Parcial2;

import java.util.concurrent.locks.*;

/**
 *
 * @author Nicolás
 */
public class Taller {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";

    private int maxMangas, maxCuerpos, mangasActual, cuerposActual;
    private Lock cestoManga, cestoCuerpo, lockCaja;
    private Condition accesoCesto1, accesoCesto2, accesoCaja; // Cesto1 mangas, Cesto2 cuerpos;
    private int cantCajasLlenas, suetersActual;

    public Taller(int numMaxMangas, int numMaxCuerpos) {
        maxMangas = numMaxMangas;
        maxCuerpos = numMaxCuerpos;
        mangasActual = 0;
        cuerposActual = 0;

        cantCajasLlenas = 0;
        suetersActual = 0;

        cestoManga = new ReentrantLock();
        cestoCuerpo = new ReentrantLock();
        lockCaja = new ReentrantLock();

        accesoCesto1 = cestoManga.newCondition();
        accesoCesto2 = cestoCuerpo.newCondition();

        accesoCaja = lockCaja.newCondition();
    }

    private void avisar() { // USADO POR COSTURERA Y EL QUE HACE CUERPOS, AVISA CUANDO SE CUMPLE UNO DE LOS DOS REQUERIMIENTOS DEl ENSAMBLADOR
        lockCaja.lock();
        try {
            accesoCaja.signalAll();
        } finally {
            lockCaja.unlock();
        }
    }

    public void hacerMangas(String nombreEmpleado) throws InterruptedException {
        cestoManga.lock();
        try {
            while (mangasActual >= maxMangas) { //Cesta de mangas llena
                System.out.println("Soy la COSTURERA de MANGAS " + nombreEmpleado + " y la cesta esta LLENA, debo ESPERAR que quiten mangas de la cesta");
                accesoCesto1.await();
            }
            System.out.println("Soy la COSTURERA de MANGAS " + nombreEmpleado + " y dejo una manga mas en la cesta");
            mangasActual++;
            System.out.println(ANSI_BLUE + "              COSTURERA:     ---- HAY " + mangasActual + " MANGAS HECHAS");
            if (mangasActual >= 2) {
                avisar();
            }
            accesoCesto1.signalAll();
        } finally {
            cestoManga.unlock();
        }
    }

    public void hacerCuerpos(String nombreEmpleado) throws InterruptedException {
        cestoCuerpo.lock();
        try {
            while (cuerposActual >= maxCuerpos) { //Cesta de cuerpos llena
                System.out.println("Soy el trabajador de los CUERPOS " + nombreEmpleado + " y la cesta esta LLENA, debo esperar que quiten cuerpos de la cesta");
                accesoCesto2.await();
            }
            System.out.println("Soy el trabajador de los CUERPOS " + nombreEmpleado + " y dejo un cuerpo mas en la cesta");
            cuerposActual++;
            System.out.println(ANSI_BLUE + "              CUERPOS:     ---- HAY " + cuerposActual + " CUERPOS HECHOS");
            if (cuerposActual >= 2) {
                avisar();
            }
            accesoCesto2.signalAll();
        } finally {
            cestoCuerpo.unlock();
        }
    }

    private void avisar2() { // Lo usa el ensamblador
        cestoManga.lock();
        try {
            accesoCesto1.signalAll();
        } finally {
            cestoManga.unlock();
        }
    }

    private void avisar3() { // Lo usa el ensamblador
        cestoCuerpo.lock();
        try {
            accesoCesto2.signalAll();
        } finally {
            cestoCuerpo.unlock();
        }
    }

    public void ensamblar(String nombreEmpleado) throws InterruptedException {
        lockCaja.lock();
        try {
            while ((cuerposActual < 1) || (mangasActual < 2)) { //No hay suficiente material para ensamblar
                System.out.println("Soy el ENSAMBLADOR " + nombreEmpleado + " y NO PUEDO ensamblar, faltan materiales");
                accesoCaja.await();
            }
            suetersActual++;
            mangasActual = mangasActual - 2;
            cuerposActual--;
            System.out.println(ANSI_BLUE + "      Soy el ENSAMBLADOR " + nombreEmpleado + " y ENSAMBLE CORRECTAMENTE otro sueter, llevo " + suetersActual + " para esta caja");
            if (suetersActual == 10) {
                cantCajasLlenas++; //Se agrega una caja llena al contador
                suetersActual = 0; //Se reinicia contador de sueters para una caja nueva
                System.out.println(ANSI_RED + "     ---> SE LLENO OTRA CAJA. CAJAS LLENAS: " + cantCajasLlenas);
            }
            avisar2(); //AVISA QUE YA PUEDEN HACERSE MAS MANGAS
            avisar3(); //AVISA QUE YA PUEDEN HACERSE MAS CUERPOS
        } finally {
            lockCaja.unlock();
        }
    }
}
