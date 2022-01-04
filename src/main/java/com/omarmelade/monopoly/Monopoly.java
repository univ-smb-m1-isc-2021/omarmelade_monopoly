package com.omarmelade.monopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monopoly {
    public Joueur jCourant;
    public List<Joueur> joueurs;
    public List<De> de = new ArrayList<>();
    public Plateau plateau;

    public Monopoly(List<Joueur> joueurs) {
        this.joueurs = joueurs;
        this.plateau = new Plateau();
        lancerPartie();
    }

    public boolean lancerPartie() {
        boolean ok = true;
        //Joueur j1 = getRandomOrder(joueurs);
        Joueur j1 = joueurs.get(0);
        setJCourant(j1);
        initPlaceJoueurs();
        if(j1 == null || joueurs.isEmpty()){
            ok = false;
        }
        return ok;
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
        System.out.println("Fin de tour pour " + jCourant.name + "\n\n");

        setJCourant(getJoueurSuivant(jCourant));
        System.out.println("C'est a " + jCourant.name + " de jouer");
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

    public void jouerTour(Case c) {
    }

    public void avancer(int nbCase) {
        Case courante = jCourant.getCurCase();
        Case suiv = plateau.getCaseFrom(courante, nbCase);
        jCourant.goCase(suiv);
    }

    public int lanceDe(int nb) {
        if( nb < 0){
            int min = 2;
            int max = 12;
            return (int) Math.floor(Math.random()*(max-min+1)+min);
        }
        return nb;
    }

    public boolean acheterCase(Case c) {
        boolean achete;
        if (c instanceof CasePropriete) {
            achete = plateau.acheteCase(c, jCourant.solde, jCourant);
            if(achete) System.out.println("Terrain " + c.nom + " acheté par " + jCourant);
            if(!achete) System.out.println("Votre solde est trop bas");
        }else {
            achete = false;
        }
        return achete;
    }

    public void construireMaison(Case terrain) {
        ((CasePropriete)terrain).construireMaison(1);
    }

    public void payeLoyer(Case c) {
        System.out.println("Paul va payer le loyer");
        boolean paye = ((CasePropriete)c).payeLoyer(jCourant);
        if(paye){
            jCourant.info();
            ((CasePropriete) c).proprio.info();
        }else {
            System.out.println("Paul n'as pas pu payer le loyer");
        }
    }

}
