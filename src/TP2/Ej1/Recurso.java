/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2.Ej1;

/**
 *
 * @author Nicolás
 */
public class Recurso {

    static void uso() {
        Thread t = Thread.currentThread();
        System.out.println("en Recurso: Soy" + t.getName());
        System.out.println("sdadsdfgasgagag"+t.getName());
    }
}
