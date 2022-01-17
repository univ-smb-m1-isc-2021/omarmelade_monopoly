package com.omarmelade.monopoly.CaseStates;

import com.omarmelade.monopoly.CaseTypes.CasePropriete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EtatConstructible extends EtatCasePro {

    private static final Logger logger = LoggerFactory.getLogger(EtatConstructible.class);

    private final CasePropriete caseproprio;

    public EtatConstructible(CasePropriete caseproprio) {
        super(caseproprio);
        this.caseproprio = caseproprio;
    }



    @Override
    public void construireMaison(int nb) {
        if(caseproprio.proprio.solde < 100 * nb){
            logger.debug("Impossible de construire par manque d'argent");
        }else{
            logger.debug( nb + "maisons ont été construites sur " + caseproprio.nom);
            caseproprio.proprio.debit(100 * nb);
        }
    }

    @Override
    public String toString() {
        return "La case " + caseproprio.nom + " est Constructible";
    }

}
