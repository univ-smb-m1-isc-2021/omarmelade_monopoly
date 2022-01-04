package com.omarmelade.monopoly;

public class Case {

    public int num;
    public String nom;

    public Case(int num, String nom) {
        this.num = num;
        this.nom = nom;
    }

    public String arriveJoueur(Joueur joueur) {
        return "Vous voila sur la case " + nom;
    }
}
