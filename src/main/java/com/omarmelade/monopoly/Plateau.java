package com.omarmelade.monopoly;

import com.omarmelade.monopoly.CaseTypes.Case;
import com.omarmelade.monopoly.CaseTypes.CasePropriete;
import com.omarmelade.monopoly.CaseTypes.Rue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Plateau {

    public List<String> casesStr = Arrays.asList("Case Départ", "Belleville", "Lecourbe", "Impôts", "Gare Montparnasse", "Vaugirard",
            "Courcelles", "Républiques", "La Villette", "Cie Électricité", "Neuilly", "Paradis","Gare de Lyon",
            "Mozart", "Saint-Michel", "Pigalle", "Matignon", "Malesherbes", "Henri-Martin",
            "Gare du Nord", "Saint-Honoré", "La Bourse", "Cie des Eaux", "La Fayette", "Breteuil", "Foch", "Capucines",
            "Gare Saint-Lazare", "Champs-Élysées", "Taxe de Luxe", "La Paix");

    public List<Case> cases = new ArrayList<>();

    public void initPlateau(){

        Case c1  = new Case(0,"Case Départ");
        Rue c2  = new Rue(1,"Belleville", 100, 75);
        Rue c3  = new Rue(2,"Lecourbe", 100, 75);
        CasePropriete c4  = new CasePropriete(3,"Impôts", 100, 75);
        CasePropriete c5  = new CasePropriete(4,"Gare Montparnasse", 100, 75);
        Rue c6  = new Rue(5,"Vaugirard", 100, 75);
        Rue c7  = new Rue(6,"Courcelles", 100, 75);
        Rue c8  = new Rue(7,"Républiques", 100, 75);
        Rue c9  = new Rue(8,"La Villette", 100, 75);
        CasePropriete c10 = new CasePropriete(9,"Cie Électricité", 100, 75);

        List<CasePropriete> quartierBc = new ArrayList<>();
        quartierBc.add(c6);
        quartierBc.add(c7);
        quartierBc.add(c8);

        Quartier bleuclair = new Quartier("bleu clair" , quartierBc);

        c8.setQ(bleuclair);
        c7.setQ(bleuclair);
        c6.setQ(bleuclair);

        cases.add(c1);
        cases.add(c2);
        cases.add(c3);
        cases.add(c4);
        cases.add(c5);
        cases.add(c6);
        cases.add(c7);
        cases.add(c8);
        cases.add(c9);
        cases.add(c10);

    }


    public Plateau() {
        initPlateau();
    }

    public List<Case> getCases() {
        return cases;
    }

    public Case getCaseAt( int nb ){
        return cases.get(nb);
    }

    public Case getCaseFrom(Case depart, int nbCase) {
        int index = cases.indexOf(depart) + 1;
        return cases.get(index+nbCase);
    }

    public boolean acheteCase(Case c, int soldeJ, Joueur J) {
        return ((CasePropriete)c).etatCasePro.acheteTerrain(J);
    }
}
