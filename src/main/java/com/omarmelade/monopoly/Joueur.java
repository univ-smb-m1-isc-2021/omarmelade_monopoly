package com.omarmelade.monopoly;

import com.omarmelade.monopoly.CaseTypes.Case;
import com.omarmelade.monopoly.CaseTypes.CasePropriete;

import java.util.ArrayList;
import java.util.List;

public class Joueur {

    public String name;
    public int solde;

    public Case curCase;
    public List<Case> list = new ArrayList<>();

    public Joueur(String name, int solde, Case curCase, List<Case> list) {
        this.name = name;
        this.solde = 500;
        this.curCase = curCase;
        this.list = list;
    }

    public Joueur(String name) {
        this.name = name;
        this.solde = 500;
    }

    public Case getCurCase() {
        return curCase;
    }
    public void setCurCase(Case c) {
        curCase = c;
    }

    public void goCase(Case newCase) {
        System.out.println(this.name + " va a la case " + newCase.nom);
        String posibilites;
        setCurCase(newCase);
        posibilites = newCase.arriveJoueur(this);
        System.out.println(this.name + " peut : ");
        System.out.println(" - " + posibilites);
    }

    public int getSolde() {
        return solde;
    }

    public void debit(int c) {
        solde -= c;
    }

    public void credit(int c) {
        solde += c;
    }

    @Override
    public String toString() {
        return name;
    }

    public void info(){
        System.out.println(name + " a " + solde +"€ ");
    }
}
