package com.omarmelade.monopoly;

public class EtatAchete extends EtatCasePro {

    public CasePropriete caseproprio;
    public EtatAchete(CasePropriete caseproprio) {
        this.caseproprio = caseproprio;
    }
    public String arriveJoueur(Joueur j) {
        if(j != caseproprio.proprio){
            return "Payer le loyer";
        }else{
            return "Ne rien faire";
        }
    }

    public boolean construireMaison(int nb){
        System.out.println("Impossible vous devez posseder le quartier");
        return false;
    }

    @Override
    public String toString() {
        return "La case " + caseproprio.nom + " est Acheté";
    }

    public boolean verifQuartierConstructible() {
        return caseproprio.verifConstructible();
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

}
