package com.omarmelade.monopoly;

public class EtatCasePro {

    private final CasePropriete caseproprio;

    public EtatCasePro(CasePropriete caseproprio) {
        this.caseproprio = caseproprio;
    }


    public void construireMaison(int nb){
        System.out.println("Impossible vous devez posseder la proprieté");
    }

    public String arriveJoueur(Joueur j) {
        if(j != caseproprio.proprio){
            return "Payer le loyer";
        }else{
            return "Construire une maison";
        }
    }

    public boolean acheteTerrain(Joueur j) {
        return false;
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

    public int getPrixLoyer() {
        return caseproprio.getLoyer();
    }

    @Override
    public String toString() {
        return "EtatCasePro";
    }
}
