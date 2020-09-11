/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Ej1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class VerificarCuenta implements Runnable {

    private CuentaBanco cb = new CuentaBanco();

    private synchronized void HacerRetiro(int cantidad) throws InterruptedException { //sincronizado para evitar problemas de concurrencia
        if (cb.getBalance() >= cantidad) {
            System.out.println(Thread.currentThread().getName() + " está realizando un retiro de: " + cantidad + ".");
//            Thread.sleep(1000);
            cb.retiroBancario(cantidad);
            System.out.println(Thread.currentThread().getName() + ": Retiro realizado");
            System.out.println(Thread.currentThread().getName() + ": Los fondos son de: " + cb.getBalance());
        } else {
            System.out.println("No hay suficiente dinero en la cuenta para realizar el retiro Sr." + Thread.currentThread().getName());
            System.out.println("Su saldo actual es de: " + cb.getBalance());
//            Thread.sleep(1000);
        }
    } //de hacer retiro

    public void run() {
        for (int i = 0; i <= 3; i++) { //Luis y Manuel intentarán retirar 4 veces cada uno
            try {
                this.HacerRetiro(10);
                if (cb.getBalance() < 0) {
                    System.out.println("La cuenta está sobregirada.");
                }
                Thread.sleep(500); //Se realiza un retiro y se le da el lock a otro hilo mientras este duerme
            } catch (InterruptedException ex) {
                Logger.getLogger(VerificarCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
