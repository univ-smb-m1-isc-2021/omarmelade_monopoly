package com.omarmelade.monopoly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EtatConstructible extends EtatCasePro {

    private static final Logger logger = LoggerFactory.getLogger(EtatConstructible.class);

    private final CasePropriete caseproprio;
    public EtatConstructible(CasePropriete caseproprio) {
        this.caseproprio = caseproprio;
    }

    @Override
    public String arriveJoueur(Joueur j) {
        if(j != caseproprio.proprio){
            return "Payer le loyer";
        }else{
            return "Construire une maison";
        }
    }


    @Override
    public boolean construireMaison(int nb) {
        if(caseproprio.proprio.solde < 100 * nb){
            logger.debug("Impossible de construire par manque d'argent");
            return false;
        }else{
            logger.debug( nb + "maisons ont été construites sur " + caseproprio.nom);
            caseproprio.proprio.debit(100 * nb);
            return true;
        }
    }

    @Override
    public String toString() {
        return "La case " + caseproprio.nom + " est Constructible";
    }

}
