import com.omarmelade.monopoly.CaseTypes.CasePropriete;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasePropieteTest {

    @Test
    public void testPrixLoyer(){

        int prix = 75;
        int loyer = 100;

        CasePropriete c = new CasePropriete(9,"Cie Électricité", loyer, prix);
        assertEquals(c.getLoyer(), loyer);
        assertEquals(c.getPrixdachat(), prix);
        assertNull(c.getProprio());
        assertFalse(c.verifConstructible());

    }
}
