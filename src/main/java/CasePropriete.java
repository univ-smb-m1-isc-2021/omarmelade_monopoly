import java.util.ArrayList;
import java.util.List;

public class CasePropriete extends Case {
    public String etat;

    public int loyer;

    public String prixdachat;

    public Joueur proprio;

    public Joueur joueur;

    public List<EtatCasePro> etatCasePro = new ArrayList<EtatCasePro> ();

    public boolean estLibre() {
        return true;
    }

    public void acheteTerrain(Joueur J) {
    }

    public void soldeSuffisant(int soldeJ) {
    }

    public void setProprio(Joueur j) {
    }

    public Joueur getProprio() {
        // TODO
        return new Joueur();
    }

    public void setEtat(String etat) {
    }

    public String getEtat() {
        // TODO
        return new String("");
    }

    public Quartier getQuartier() {
        return new Quartier();
    }

    public void verifConstructible() {
    }

}
