package com.omarmelade.monopoly;

public class EtatLibre extends EtatCasePro {

    private final CasePropriete caseproprio;

    public EtatLibre(CasePropriete caseproprio) {
        super(caseproprio);
        this.caseproprio = caseproprio;
    }

    public boolean acheteTerrain(Joueur j){
        int solde = j.getSolde();
        if(soldeSuffisant(solde))
        {
            caseproprio.setProprio(j);
            j.debit(caseproprio.prixdachat);
            EtatAchete etatAchete = new EtatAchete(caseproprio);
            caseproprio.setEtat(etatAchete);
            System.out.println(caseproprio.etatCasePro);
            if(etatAchete.verifQuartierConstructible())
            {
                caseproprio.setEtat(new EtatConstructible(caseproprio));
            }
            System.out.println(caseproprio.etatCasePro);
            return true;
        }else{
            return false;
        }
    }

    public String arriveJoueur(Joueur j) {
        System.out.println(caseproprio.etatCasePro);
        return "Acheter " + caseproprio.nom + " pour : " + caseproprio.getPrixdachat();
    }

    @Override
    public String toString() {
        return "La case " + caseproprio.nom + " est Libre";
    }

    public boolean soldeSuffisant(int solde){
        return solde >= caseproprio.prixdachat;
    }
}
