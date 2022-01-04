package com.omarmelade.monopoly.tests;

import com.omarmelade.monopoly.CasePropriete;
import com.omarmelade.monopoly.Joueur;
import com.omarmelade.monopoly.Monopoly;

import java.util.ArrayList;

public class MainIncr2_2 {

    public static void main(String[] args) {
        Joueur j1 = new Joueur("Luc");
        Joueur j2 = new Joueur("Paul");
        Joueur j3 = new Joueur("Théo");
        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        joueurs.add(j1);
        joueurs.add(j2);
        joueurs.add(j3);

        Monopoly m = new Monopoly(joueurs);
        // Luc possede 2 terrains bleu clairs
        ((CasePropriete)m.plateau.getCaseAt( 6)).setProprio(j1);
        ((CasePropriete)m.plateau.getCaseAt( 7)).setProprio(j1);

        int nb = m.lanceDe(4);
        m.avancer(nb);
        m.acheterCase(m.jCourant.getCurCase());
        m.finDeTour();

        m.jCourant.info();
        nb = m.lanceDe(4);
        m.avancer(nb);
        System.out.println("\n");
        m.payeLoyer(m.jCourant.getCurCase());
        System.out.println("\n");
        m.finDeTour();

    }
}
