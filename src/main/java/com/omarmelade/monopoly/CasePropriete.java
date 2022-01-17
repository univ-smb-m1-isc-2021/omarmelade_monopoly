package com.omarmelade.monopoly;

import java.util.Objects;

public class CasePropriete extends Case {

    public int loyer;
    public int prixdachat;
    public Joueur proprio;
    public Joueur joueur;
    public EtatCasePro etatCasePro;
    public Quartier q;

    public CasePropriete(int num, String nom, int loyer, int prixdachat, Quartier q) {
        super(num, nom);
        this.loyer = loyer;
        this.prixdachat = prixdachat;
        this.proprio = null;
        this.joueur = null;
        this.etatCasePro = new EtatLibre(this);
        this.q = q;
    }

    public CasePropriete(int num, String nom, int loyer, int prixdachat) {
        super(num, nom);
        this.loyer = loyer;
        this.prixdachat = prixdachat;
        this.proprio = null;
        this.joueur = null;
        this.etatCasePro = new EtatLibre(this);
    }

    @Override
    public String arriveJoueur(Joueur j) {
        return etatCasePro.arriveJoueur(j);
    }

    public void setQ(Quartier q) {
        this.q = q;
    }

    public int getLoyer() {
        return loyer;
    }

    public int getPrixdachat() {
        return prixdachat;
    }


    public void setProprio(Joueur j) {
        proprio = j;
    }

    public Joueur getProprio() {
        return proprio;
    }

    public void setEtat(EtatCasePro etat) {
        etatCasePro = etat;
    }

    public EtatCasePro getEtat() { return etatCasePro;}

    public boolean verifConstructible() {
        boolean constructible = true;
        if(q != null){
            for ( CasePropriete cp : q.casePropriete) {
                if (!Objects.equals(cp.proprio, proprio)) {
                    constructible = false;
                    break;
                }
            }
            return constructible;
        }
        return false;
    }

    public int getNbCaseQuartier(){
        int nb = 0;
        if(q != null){
            for ( CasePropriete cp : q.casePropriete) {
                if(cp.q == q)
                    nb++;
            }
        }
        return nb;
    }

    public boolean payeLoyer(Joueur j) {
        return etatCasePro.payerLoyer(j);
    }

    public void construireMaison(int nb) {
        etatCasePro.construireMaison(nb);
    }

}
