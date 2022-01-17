import com.omarmelade.monopoly.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlateauTest
{

    @Test
    public void testPlateau()
    {
        Joueur j1 = new Joueur("Theo");
        Plateau p = new Plateau();

        Rue c6  = new Rue(5,"Vaugirard", 100, 75);
        Rue c7  = new Rue(6,"Courcelles", 100, 75);
        Rue c8  = new Rue(7,"Républiques", 100, 75);

        List<CasePropriete> quartierBc = new ArrayList<>();
        quartierBc.add(c6);
        quartierBc.add(c7);
        quartierBc.add(c8);

        Quartier bleuclair = new Quartier("bleu clair" , quartierBc);

        c8.setQ(bleuclair);
        c7.setQ(bleuclair);
        c6.setQ(bleuclair);

        assertEquals(3, quartierBc.size());

        for (CasePropriete c: bleuclair.casePropriete) {
            c.setProprio(j1);
            assertNotNull(c.q);
            assertEquals(3, c.getNbCaseQuartier());
        }
    }
}
