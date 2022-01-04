package com.omarmelade.monopoly.tests;

import com.omarmelade.monopoly.Joueur;
import com.omarmelade.monopoly.Monopoly;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        ArrayList<Joueur> joueurs = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        System.out.println("Bienvenue dans le Monopoly :");
        System.out.println("Entrez le nombre de Joueurs qui vont s'amuser : ");
        String nbJ = s.nextLine();
        int nbJint = Integer.parseInt(nbJ);

        for (int i = 0; i < nbJint; i++) {
            System.out.println("Entrez le nom de j" + (i + 1));
            String name = s.nextLine();
            joueurs.add(new Joueur(name));
        }

        System.out.println("La partie est en cours de chargement");
        Monopoly m = new Monopoly(joueurs);
        m.lancerPartie();
        System.out.println("Voici la liste des joueurs : " + m.joueurs);
        System.out.println(m.jCourant + " va commencer.");
    }
}
