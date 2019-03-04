import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator obo = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {

        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("f"));
        assertTrue(palindrome.isPalindrome(""));

        assertFalse(palindrome.isPalindrome("yeet"));

        //revision 1
        assertFalse(palindrome.isPalindrome("Racecar"));
    }

    @Test
    public void testIsPalindromeObo() {

        assertTrue(palindrome.isPalindrome("flake", obo));
        assertTrue(palindrome.isPalindrome("f", obo));
        assertTrue(palindrome.isPalindrome("", obo));
        assertTrue(palindrome.isPalindrome("ejnkd", obo));

        assertFalse(palindrome.isPalindrome("racecar", obo));
        assertFalse(palindrome.isPalindrome("yeet", obo));

        //rev 1
        //assertTrue(palindrome.isPalindrome("]n^"));

        assertFalse(palindrome.isPalindrome("Flake", obo));
        assertFalse(palindrome.isPalindrome("^.^", obo));
        assertFalse(palindrome.isPalindrome(":-(", obo));

        //rev 2
        assertTrue(palindrome.isPalindrome("]n^", obo));

    }

}
