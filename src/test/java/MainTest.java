import com.omarmelade.monopoly.CasePropriete;
import com.omarmelade.monopoly.Joueur;
import com.omarmelade.monopoly.Monopoly;
import com.omarmelade.monopoly.tests.MainIncr1;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {


    @Test
    public void testRunning() {
        System.out.println("Running ...");
        assertTrue(true);
    }

    // Monopoly Class
    @Test
    public void testMonop() {

        Joueur j1 = new Joueur("Paul");
        Joueur j2 = new Joueur("Luc");
        Joueur j3 = new Joueur("Théo");
        ArrayList<Joueur> joueurs = new ArrayList<>();
        joueurs.add(j1);
        joueurs.add(j2);
        joueurs.add(j3);

        Monopoly m = new Monopoly(joueurs);
        System.out.println("Verifying jCourant is not null");
        assertNotNull(m.jCourant);

        System.out.println("Verifying players are at case 0");
        m.joueurs.forEach(j -> assertEquals(j.curCase.num, 0));
    }

    @Test
    public void testMonopProprio(){

        Monopoly m = MainIncr1.initSecondCase();

        ((CasePropriete)m.plateau.getCaseAt( 6)).setProprio(m.joueurs.get(0));
        Joueur j = ((CasePropriete)m.plateau.getCaseAt( 6)).getProprio();
        assertNotNull(j);

        int nb = m.lanceDe(4);
        m.avancer(nb);
        m.payeLoyer(m.jCourant.getCurCase());
        System.out.println("\n");
        m.finDeTour();
    }

    @Test
    public void testDe(){
        Joueur j1 = new Joueur("Paul");
        Joueur j2 = new Joueur("Luc");
        Joueur j3 = new Joueur("Théo");
        ArrayList<Joueur> joueurs = new ArrayList<>();
        joueurs.add(j1);
        joueurs.add(j2);
        joueurs.add(j3);
        Monopoly m = new Monopoly(joueurs);

        ArrayList<Integer> tab = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
           tab.add(m.lanceDe(-1));
           assertTrue(tab.get(i) <= 12 && tab.get(i) >= 2);
        }
    }

}
