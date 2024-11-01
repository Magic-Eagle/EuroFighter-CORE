package org.magicEagle.TestPackage;

public class Main {
    public static void main(String[] args) {
        String frase1 = "frase1";
        String frase2 = "frase1";

        System.out.println(frase1.equals(frase2));

        String DNI = "1923414T";

        System.out.println("DNI NUMERO: "+DNI.substring(0,DNI.length()-1));
        System.out.println("DNI LETRA: "+DNI.charAt(DNI.length()-1));
    }
}
