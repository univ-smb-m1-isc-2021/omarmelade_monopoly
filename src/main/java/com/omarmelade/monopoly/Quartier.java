package com.omarmelade.monopoly;

import com.omarmelade.monopoly.CaseTypes.CasePropriete;

import java.util.List;

public class Quartier {

    public String couleur;

    public List<CasePropriete> casePropriete;

    public Quartier(String couleur, List<CasePropriete> casePropriete) {
        this.couleur = couleur;
        this.casePropriete = casePropriete;
    }
}
