package com.omarmelade.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Quartier {

    public String couleur;

    public List<CasePropriete> casePropriete = new ArrayList<CasePropriete> ();

    public Quartier(String couleur, List<CasePropriete> casePropriete) {
        this.couleur = couleur;
        this.casePropriete = casePropriete;
    }
}
