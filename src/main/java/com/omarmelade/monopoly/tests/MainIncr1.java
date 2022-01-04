package com.omarmelade.monopoly.tests;

import com.omarmelade.monopoly.Joueur;
import com.omarmelade.monopoly.Monopoly;
import com.omarmelade.monopoly.Plateau;

import java.util.ArrayList;

public class MainIncr1 {

    public static void main(String[] args) {
        Joueur j1 = new Joueur("Paul");
        Joueur j2 = new Joueur("Luc");
        Joueur j3 = new Joueur("Théo");
        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        joueurs.add(j1);
        joueurs.add(j2);
        joueurs.add(j3);

        Monopoly m = new Monopoly(joueurs);
        int nb = m.lanceDe(6);
        m.avancer(nb);
        m.acheterCase(m.jCourant.getCurCase());
        m.construireMaison(m.jCourant.getCurCase());
        m.finDeTour();
    }
}
