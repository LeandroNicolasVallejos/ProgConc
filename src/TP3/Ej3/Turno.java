/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Ej3;

/**
 *
 * @author Nicolás
 */
public class Turno {

    char memoria = ' ';
    String aux = "";
    boolean si;
//        public boolean autorizacion(String nom) {
//        if (nom.equals('a')) {
//            if (memoria == ' ' || memoria == 'c') {
//                aux = aux + "A";
//                memoria = 'a';
//            }
//        } else {
//            if (nom.equals('b')) {
//                if (memoria == 'a') {
//                    aux = aux + "BB";
//                    memoria = 'b';
//                }
//            } else { //nom == 'c'
//                if (memoria == 'b') {
//                    aux = aux + "CCC";
//                    memoria = 'c';
//                }
//            }
//        }
//        return si;
//    }
    public String autorizacion(String nom) {
        if (nom.equals("La")) {
            if (memoria == ' ' || memoria == 'c') {
                aux = aux + "A";
                memoria = 'a';
            }
        } else {
            if (nom.equals("Lb")) {
                if (memoria == 'a') {
                    aux = aux + "BB";
                    memoria = 'b';
                }
            } else { //nom == 'c'
                if (memoria == 'b') {
                    aux = aux + "CCC";
                    memoria = 'c';
                }
            }
        }
        return aux;
    }

}
