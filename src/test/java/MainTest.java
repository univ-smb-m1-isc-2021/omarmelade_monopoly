import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class MainTest extends TestCase {

    public MainTest(String name) {
        super(name);
    }

    @Test
    public void testRunning() {
        System.out.println("Running ...");
        assertTrue(true);
    }

}
