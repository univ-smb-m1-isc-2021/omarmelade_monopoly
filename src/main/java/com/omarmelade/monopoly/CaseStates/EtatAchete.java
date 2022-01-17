package com.omarmelade.monopoly.CaseStates;
import com.omarmelade.monopoly.CaseTypes.CasePropriete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EtatAchete extends EtatCasePro {

    private static final Logger logger = LoggerFactory.getLogger(EtatAchete.class);

    private final CasePropriete caseproprio;

    public EtatAchete(CasePropriete caseproprio) {
        super(caseproprio);
        this.caseproprio = caseproprio;
    }

    @Override
    public void construireMaison(int nb){
       logger.debug("Impossible vous devez posseder le quartier");
    }

    @Override
    public String toString() {
        return "La case " + caseproprio.nom + " est Acheté";
    }

    public boolean verifQuartierConstructible() {
        return caseproprio.verifConstructible();
    }

}
