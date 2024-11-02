package org.magicEagle.TestPackage;

import org.magicEagle.plane.Armamento.Bomb;
import org.magicEagle.plane.Armamento.Misile;
import org.magicEagle.plane.Armamento.bahiaArmas.PilonCentral;
import org.magicEagle.plane.Armamento.bahiaArmas.PilonDerecho;
import org.magicEagle.plane.Armamento.bahiaArmas.PilonIzquierdo;

public class Main {
    public static void main(String[] args) {
//        String frase1 = "frase1";
//        String frase2 = "frase1";
//
//        System.out.println(frase1.equals(frase2));
//
//        String DNI = "1923414T";
//
//        System.out.println("DNI NUMERO: "+DNI.substring(0,DNI.length()-1));
//        System.out.println("DNI LETRA: "+DNI.charAt(DNI.length()-1));
//
//        int num1 = 10;
//        int num2 = 20;
//
//        System.out.println(
//                num2 - num1
//        );

        Bomb bomb = new Bomb("AGM-65B","Bomb", 1000, "Laser", 1000, 10, 100, 100, 100);
        Misile misile = new Misile("AIM-9B FGW.2", "Misile", 75,"Laser" , "Rear Aspect", 50000,10000, 10000, 9,25,7, null);
        PilonIzquierdo pilonIzquierdo = new PilonIzquierdo();
        PilonCentral pilonCentral = new PilonCentral();
        PilonDerecho pilonDerecho = new PilonDerecho();
        Misile misile2 = new Misile("AIM-9B FGW.2", "Misile", 75,"Laser" , "Rear Aspect", 50000,10000, 10000, 9,25,7, null);

        pilonIzquierdo.loadGun(misile);
        pilonCentral.loadGun(bomb);
        pilonDerecho.loadGun(misile2);
        pilonIzquierdo.loadGun(misile2);

        System.out.println("PILON IZQUIERDO: "+pilonIzquierdo.showLodout());
        System.out.println("PILON CENTRAL: "+pilonCentral.showLodout());
        System.out.println("PILON DERECHO: "+pilonDerecho.showLodout());
    }
}
