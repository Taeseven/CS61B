import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.

    @Test
    public void testEqualChars1() {
        assertTrue(offByOne.equalChars('a', 'b'));
    }

    @Test
    public void testEqualChars2() {
        assertTrue(offByOne.equalChars('r', 'q'));
    }

    @Test
    public void testEqualChars3() {
        assertFalse(offByOne.equalChars('a', 'z'));
    }

    @Test
    public void testEqualChars4() {
        assertFalse(offByOne.equalChars('a', 'e'));
    }

    @Test
    public void testEqualChars5() {
        assertFalse(offByOne.equalChars('a', 'a'));
    }

    @Test
    public void testEqualChars6() {
        assertTrue(offByOne.equalChars('&', '%'));
    }

    @Test
    public void testEqualChars7() {
        assertFalse(offByOne.equalChars('a', 'B'));
    }

}
