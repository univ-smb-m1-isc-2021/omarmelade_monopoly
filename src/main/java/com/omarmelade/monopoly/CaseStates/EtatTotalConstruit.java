package com.omarmelade.monopoly.CaseStates;

import com.omarmelade.monopoly.CaseTypes.CasePropriete;
import com.omarmelade.monopoly.Joueur;

public class EtatTotalConstruit extends EtatCasePro {


    private final CasePropriete caseproprio;

    public EtatTotalConstruit(CasePropriete caseproprio) {
        super(caseproprio);
        this.caseproprio = caseproprio;
    }

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
