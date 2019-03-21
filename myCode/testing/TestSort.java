import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the the Sort class. */
public class TestSort {
    /** Test the Sort.sort method. */
    String[] input = {"i", "have", "an", "egg"};
    String[] expected = {"an", "egg", "have", "i"};

    @Test
    public void testSort() {
        Sort.sort(input);

        assertArrayEquals(expected, input);
    }

    /** Test the Sort.findSmallest method. */
    @Test
    public void testFindSmallest() {
        int expected = 2;

        int actual = Sort.findSmallest(input, 0);
        assertEquals(expected, actual);
    }

    /** Test the Sort.swap method. */
    @Test
    public void testSwap() {
        int a = 0;
        int b = 2;
        String[] expected1 = {"an", "have", "i", "egg"};

        Sort.swap(input, a, b);
        assertArrayEquals(expected1, input);
    }
}
