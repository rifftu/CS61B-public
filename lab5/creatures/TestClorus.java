package creatures;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;

/** Tests the clorus class
 *  @authr FIXME
 */

public class TestClorus {

    @Test
    public void testBasics() {
 
    }

    @Test
    public void testReplicate() {
        // TODO
        Clorus p = new Clorus(2);
        Clorus q = p.replicate();
        assertEquals(1, p.energy(), 0.01);
        assertEquals(1, q.energy(), 0.01);
        assertFalse(p == q);
    }

    @Test
    public void testChoose() {

        


        // We don't have Cloruses yet, so we can't test behavior for when they are nearby right now.
    }
}
