package com.omarmelade.monopoly;

public class EtatTotalConstruit extends EtatCasePro {


    public CasePropriete caseproprio;

    public String arriveJoueur(Joueur j) {
        return "";
    }

    @Override
    public String toString() {
        return "La case " + caseproprio.nom + " est Totalement construite";
    }

    public int getPrixLoyer() {
        return 0;
    }

    public void payerLoyer() {
    }
}
