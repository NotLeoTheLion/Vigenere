package org.example;

import java.security.Key;
import java.util.Scanner;

public class VignereSifravimas {
    public static void main(String[] args){

        System.out.println("VIGENRE SIFRAVIMAS/DESIFRAMVIMAS\n");
        Scanner in = new Scanner(System.in);

        System.out.println("1 - uzssifruoti zinute / 2 - desifruoti zinute ");
        int pasirinkimas = in.nextInt();

        if (pasirinkimas == 1){
            System.out.print("Iveskite rakta: ");
            String raktas = in.next().toUpperCase();
            System.out.print("Iveskite zinute kuria norite uzsifruoti: ");
            String Szinute = in.next();
            String uzsifruotiZinute = uzsifruoti(Szinute, raktas);
            System.out.println("Uzsifruota zinute yra: " + uzsifruotiZinute);
        }
        else if (pasirinkimas == 2) {
            System.out.print("Iveskite rakta: ");
            String raktas = in.next().toUpperCase();
            System.out.print("Iveskite zinute kuria norite desifruoti: ");
            String Dzinute = in.next();
            String desifruotaZinute = desifruoti(Dzinute, raktas);
            System.out.println("Desifruota zinute yra: " + desifruotaZinute);
        }
        else {
            System.out.println("Netinkamas pasirinkimas");
        }
        in.close();
    }

    public static String uzsifruoti (String Zinute, String Raktas){
        String Szinute = "";
        Zinute = Zinute.toUpperCase();
        for (int i = 0, j = 0; i < Zinute.length(); i++) {
            char raide = Zinute.charAt(i);
            Szinute += (char)(((raide) + (Raktas.charAt(j))) % 26 + 'A');
            j = ++j % Raktas.length();
        }
        return Szinute;
    }

    public static  String desifruoti (String Zinute, String Raktas){
        String Dzinute = "";
        Zinute = Zinute.toUpperCase();
        for (int i = 0, j = 0; i < Zinute.length(); i++){
            char letter = Zinute.charAt(i);
            Dzinute += (char)((letter - Raktas.charAt(j) + 26) % 26 + 'A');
            j = ++j % Raktas.length();
        }
        return Dzinute;
    }
}
