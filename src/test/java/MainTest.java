import com.omarmelade.monopoly.Joueur;
import com.omarmelade.monopoly.Monopoly;
import com.omarmelade.monopoly.tests.Main;
import org.junit.jupiter.api.Test;

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
        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
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
    public void testDe(){
        Joueur j1 = new Joueur("Paul");
        Joueur j2 = new Joueur("Luc");
        Joueur j3 = new Joueur("Théo");
        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        joueurs.add(j1);
        joueurs.add(j2);
        joueurs.add(j3);
        Monopoly m = new Monopoly(joueurs);

        ArrayList<Integer> tab = new ArrayList<Integer>();
        for (int i = 0; i < 200000; i++) {
           tab.add(m.lanceDe(-1));
           assertTrue(tab.get(i) <= 12 && tab.get(i) >= 2);
        }
    }

}
