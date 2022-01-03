package com.omarmelade.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    public int solde;

    public Case curCase;

    public List<Case> list = new ArrayList<Case>();

    public Case getCurCase() {
        return new Case();
    }

    public void setCurCase(Case c) {
    }

    public String goCase(Case newCase) {
        return "";
    }

    public int getSolde() {
        return 0;
    }

    public void setSoldeJ(int solde) {
    }

    public void acheteCase() {
    }

}
