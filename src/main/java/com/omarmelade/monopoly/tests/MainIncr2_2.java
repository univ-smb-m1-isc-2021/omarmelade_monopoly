package com.omarmelade.monopoly.tests;

import com.omarmelade.monopoly.CasePropriete;
import com.omarmelade.monopoly.Joueur;
import com.omarmelade.monopoly.Monopoly;

import java.util.ArrayList;

public class MainIncr2_2 {

    public static void main(String[] args) {
        Monopoly m = MainIncr1.initSecondCase();
        int nb;

        m.jCourant.info();
        nb = m.lanceDe(4);
        m.avancer(nb);
        System.out.println("\n");
        m.payeLoyer(m.jCourant.getCurCase());
        System.out.println("\n");
        m.finDeTour();

    }
}
