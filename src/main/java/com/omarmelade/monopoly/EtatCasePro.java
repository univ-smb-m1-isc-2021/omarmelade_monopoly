package com.omarmelade.monopoly;

public class EtatCasePro {
    public CasePropriete caseproprio;

    public boolean construireMaison(int nb){
        System.out.println("Impossible vous devez posseder la proprieté");
        return false;
    }

    public String arriveJoueur(Joueur j) {
        return "etat indefini";
    }

    public boolean acheteTerrain(Joueur j) {
        return false;
    }

    public boolean payerLoyer(Joueur j) {
        return false;
    }
}
