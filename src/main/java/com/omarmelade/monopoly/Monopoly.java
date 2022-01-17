package com.omarmelade.monopoly;

import com.omarmelade.monopoly.CaseTypes.Case;
import com.omarmelade.monopoly.CaseTypes.CasePropriete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monopoly {

    private static final Logger logger = LoggerFactory.getLogger(Monopoly.class);

    public Joueur jCourant;
    public List<Joueur> joueurs;
    public Plateau plateau;

    public Monopoly(List<Joueur> joueurs) {
        this.joueurs = joueurs;
        this.plateau = new Plateau();
        lancerPartie();
    }

    public void lancerPartie() {
        Joueur j1 = getRandomOrder(joueurs);
        setJCourant(j1);
        initPlaceJoueurs();
    }

    private void initPlaceJoueurs() {
        for (Joueur j : joueurs) {
            j.curCase = plateau.getCaseAt(0);
        }
    }

    public void setJCourant(Joueur j) {
        jCourant = j;
    }

    public void finDeTour() {
        jCourant.info();
        logger.debug("Fin de tour pour " + jCourant.name + "\n\n");

        setJCourant(getJoueurSuivant(jCourant));
        logger.debug("C'est a " + jCourant.name + " de jouer");
    }

    public Joueur getJoueurSuivant(Joueur jCourant) {
        Joueur jSuiv;
        int index = joueurs.indexOf(jCourant);
        if(index == joueurs.size() - 1 )
        {
            jSuiv = joueurs.get(0);
        }else{
            jSuiv = joueurs.get(index+1);
        }
        return jSuiv;
    }

    // Retourne le premier joueur à jouer
    public Joueur getRandomOrder(List<Joueur> liste) {
        Collections.shuffle(liste);
        return liste.get(0);
    }

    public void avancer(int nbCase) {
        Case courante = jCourant.getCurCase();
        Case suiv = plateau.getCaseFrom(courante, nbCase);
        jCourant.goCase(suiv);
    }

    public int lanceDe(int nb) {

        if( nb < 0){
            SecureRandom random = new SecureRandom();
            int min = 2;
            int max = 12;
            return random.nextInt(max-min) + min;
        }
        return nb;
    }

    public boolean acheterCase(Case c) {
        boolean achete;
        if (c instanceof CasePropriete) {
            achete = plateau.acheteCase(c, jCourant.solde, jCourant);
            if(achete) logger.debug("Terrain " + c.nom + " acheté par " + jCourant);
            if(!achete) logger.debug("Votre solde est trop bas");
        }else {
            achete = false;
        }
        return achete;
    }

    public void construireMaison(Case terrain) {
        ((CasePropriete)terrain).construireMaison(1);
    }

    public void payeLoyer(Case c) {
        logger.debug("Paul va payer le loyer");
        boolean paye = ((CasePropriete)c).payeLoyer(jCourant);
        if(paye){
            jCourant.info();
            ((CasePropriete) c).proprio.info();
        }else {
            logger.debug("Paul n'as pas pu payer le loyer");
        }
    }

}
