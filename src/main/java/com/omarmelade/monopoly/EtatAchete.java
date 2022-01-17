package com.omarmelade.monopoly;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EtatAchete extends EtatCasePro {

    private static final Logger logger = LoggerFactory.getLogger(EtatAchete.class);

    private final CasePropriete caseproprio;
    public EtatAchete(CasePropriete caseproprio) {
        this.caseproprio = caseproprio;
    }

    @Override
    public String arriveJoueur(Joueur j) {
        if(j != caseproprio.proprio){
            return "Payer le loyer";
        }else{
            return "Ne rien faire";
        }
    }
    @Override
    public boolean construireMaison(int nb){
       logger.debug("Impossible vous devez posseder le quartier");
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

    @Override
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
