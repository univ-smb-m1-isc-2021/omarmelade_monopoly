package com.omarmelade.monopoly.CaseTypes;

import com.omarmelade.monopoly.Joueur;

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
