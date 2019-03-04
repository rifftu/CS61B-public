import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offBy5 = new OffByN(5);
    static CharacterComparator offBy1 = new OffByN(1);
    static CharacterComparator offBy0 = new OffByN(0);

    // Your tests go here.

    @Test
    public void testob5() {
        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('v', 'q'));
        assertTrue(offBy5.equalChars('E', 'J'));

        assertFalse(offBy5.equalChars('a', 'e'));
        assertFalse(offBy5.equalChars('z', 'a'));
        assertFalse(offBy5.equalChars('a', 'a'));
    }

    @Test
    public void testob1() {
        assertTrue(offBy1.equalChars('a', 'b'));
        assertTrue(offBy1.equalChars('r', 'q'));
        assertTrue(offBy1.equalChars('Z', '['));

        assertFalse(offBy1.equalChars('a', 'e'));
        assertFalse(offBy1.equalChars('z', 'a'));
        assertFalse(offBy1.equalChars('a', 'a'));
    }

    @Test
    public void testob0() {
        assertTrue(offBy0.equalChars('a', 'a'));
        assertTrue(offBy0.equalChars('%', '%'));
        assertTrue(offBy0.equalChars('T', 'T'));

        assertFalse(offBy0.equalChars('a', 't'));
        assertFalse(offBy0.equalChars('a', 'A'));
        assertFalse(offBy0.equalChars('a', '7'));
    }

}
