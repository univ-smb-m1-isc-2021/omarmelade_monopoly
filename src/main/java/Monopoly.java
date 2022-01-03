import java.util.ArrayList;
import java.util.List;

public class Monopoly {
    public Joueur jCourant;

    public List<Joueur> joueur = new ArrayList<Joueur> ();

    public List<De> de = new ArrayList<De> ();

    public List<Plateau> plateau = new ArrayList<Plateau> ();

    public boolean lancerPartie(Joueur liste) {
        return false;
    }

    public void setJCourant(Joueur j) {
    }

    public void finDeTour(Joueur p) {
    }

    public Joueur getJoueurSuivant(Joueur jCourant) {
        return new Joueur();
    }

    public Joueur getRandomOrder(Joueur liste) {
        return new Joueur();
    }

    public void jouerTour(Case c) {
    }

    public void avancer(int nbCase) {
    }

    public int lanceDe() {
        return 0;
    }

    public boolean acheterCase(Case c) {
        return false;
    }

    public void construireMaison(Case terrain) {
    }

}
