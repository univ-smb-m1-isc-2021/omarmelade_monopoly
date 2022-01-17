package com.omarmelade.monopoly.MainRun;

import com.omarmelade.monopoly.CaseTypes.CasePropriete;
import com.omarmelade.monopoly.Joueur;
import com.omarmelade.monopoly.Monopoly;

import java.util.ArrayList;

public class MainIncr1 {

    public static void main(String[] args) {


        Monopoly m = new Monopoly(
                initThreePlayers()
        );
        int nb = m.lanceDe(6);
        m.avancer(nb);
        m.acheterCase(m.jCourant.getCurCase());
        m.construireMaison(m.jCourant.getCurCase());
        m.finDeTour();
    }

    static ArrayList<Joueur> initThreePlayers() {
        Joueur j1 = new Joueur("Paul");
        Joueur j2 = new Joueur("Luc");
        Joueur j3 = new Joueur("Théo");
        ArrayList<Joueur> joueurs = new ArrayList<>();
        joueurs.add(j1);
        joueurs.add(j2);
        joueurs.add(j3);
        return joueurs;
    }

    public static Monopoly initSecondCase(){
        Monopoly m = new Monopoly(MainIncr1.initThreePlayers());

        // Luc possede 2 terrains bleu clairs
        ((CasePropriete)m.plateau.getCaseAt( 6)).setProprio(m.joueurs.get(0));
        ((CasePropriete)m.plateau.getCaseAt( 7)).setProprio(m.joueurs.get(0));

        int nb = m.lanceDe(4);
        m.avancer(nb);
        m.acheterCase(m.jCourant.getCurCase());
        m.finDeTour();

        return m;
    }
}
