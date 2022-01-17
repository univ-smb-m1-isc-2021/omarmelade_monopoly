package com.omarmelade.monopoly.tests;

import com.omarmelade.monopoly.EtatConstructible;
import com.omarmelade.monopoly.Joueur;
import com.omarmelade.monopoly.Monopoly;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ArrayList<Joueur> joueurs = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        logger.debug("Bienvenue dans le Monopoly :");
        logger.debug("Entrez le nombre de Joueurs qui vont s'amuser : ");
        String nbJ = s.nextLine();
        int nbJint = Integer.parseInt(nbJ);

        for (int i = 0; i < nbJint; i++) {
            logger.debug("Entrez le nom de j" + (i + 1));
            String name = s.nextLine();
            joueurs.add(new Joueur(name));
        }

        logger.debug("La partie est en cours de chargement");
        Monopoly m = new Monopoly(joueurs);
        m.lancerPartie();
        logger.debug("Voici la liste des joueurs : " + m.joueurs);
        logger.debug(m.jCourant + " va commencer.");
    }
}
