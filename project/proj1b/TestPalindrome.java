import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    /** Test wordToDeque method. */
    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    /** Test isPalindrome method. */
    @Test
    public void testIsPalindrome1() {
        assertTrue(palindrome.isPalindrome("a"));
    }

    @Test
    public void testIsPalindrome2() {
        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testIsPalindrome3() {
        assertTrue(palindrome.isPalindrome("racecar"));
    }

    @Test
    public void testIsPalindrome4() {
        assertTrue(palindrome.isPalindrome("noon"));
    }

    @Test
    public void testIsPalindrome5() {
        assertFalse(palindrome.isPalindrome("horse"));
    }

    @Test
    public void testIsPalindrome6() {
        assertFalse(palindrome.isPalindrome("rancor"));
    }

    @Test
    public void testIsPalindrome7() {
        assertFalse(palindrome.isPalindrome("aaaaab"));
    }

    /** Test isPalindrome with CharacterComparator OffByOne. */
    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void testIsPalindromeOffByOne1() {
        assertTrue(palindrome.isPalindrome("flake", offByOne));
    }

    @Test
    public void testIsPalindromeOffByOne2() {
        assertTrue(palindrome.isPalindrome("a", offByOne));
    }

    @Test
    public void testIsPalindromeOffByOne3() {
        assertTrue(palindrome.isPalindrome("AaB", offByOne));
    }

    @Test
    public void testIsPalindromeOffByOne4() {
        assertTrue(palindrome.isPalindrome("&ab%", offByOne));
    }

    @Test
    public void testIsPalindromeOffByOne5() {
        assertTrue(palindrome.isPalindrome("ABAB", offByOne));
    }

    @Test
    public void testIsPalindromeOffByOne6() {
        assertFalse(palindrome.isPalindrome("fake", offByOne));
    }

    /** Test isPalindrome with CharacterComparator OffByN. */

}
