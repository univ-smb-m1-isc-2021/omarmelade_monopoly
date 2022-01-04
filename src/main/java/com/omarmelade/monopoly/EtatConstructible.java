package com.omarmelade.monopoly;

public class EtatConstructible extends EtatCasePro {


    public CasePropriete caseproprio;

    public EtatConstructible(CasePropriete caseproprio) {
        this.caseproprio = caseproprio;
    }

    public String arriveJoueur(Joueur j) {
        if(j != caseproprio.proprio){
            return "Payer le loyer";
        }else{
            return "Construire une maison";
        }
    }


    public int getPrixLoyer() {
        return caseproprio.getLoyer();
    }

    public boolean payerLoyer(Joueur j) {
        if(j != caseproprio.proprio){
            j.debit(calculeLoyer());
            caseproprio.proprio.credit(calculeLoyer());
            return true;
        }
        return false;
    }

    public int calculeLoyer() {
        return caseproprio.getNbCaseQuartier() * getPrixLoyer();
    }

    public boolean construireMaison(int nb) {
        if(caseproprio.proprio.solde < 100 * nb){
            System.out.println("Impossible de construire par manque d'argent");
            return false;
        }else{
            System.out.println( nb + "maisons ont été construites sur " + caseproprio.nom);
            caseproprio.proprio.debit(100 * nb);
            return true;
        }
    }

    @Override
    public String toString() {
        return "La case " + caseproprio.nom + " est Constructible";
    }

}
