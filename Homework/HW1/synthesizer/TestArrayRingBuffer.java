package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(10);
    }

    @Test
    public void isEmptyTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(4);
        assertTrue(arb.isEmpty());
    }

    @Test
    public void isFullTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(4);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        assertTrue(arb.isFull());
    }

    @Test
    public void enqueueTese() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(4);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        for (int i = 1; i < 5; i++) {
            assertEquals(i, (int) arb.dequeue());
        }
    }

    @Test
    public void peekTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(4);
        arb.enqueue(1);
        int num = arb.peek();
        assertEquals(num, 1);
        assertEquals(1, (int) arb.dequeue());
    }

    @Test
    public void throwExceptionTest() {
        boolean enqueueFlag = false;
        boolean dequeueFlag = false;
        boolean peekFlag = false;
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(4);
        try {
            arb.dequeue();
        } catch (Exception e) {
            dequeueFlag = true;
        }
        assertTrue(dequeueFlag);
        try {
            arb.peek();
        } catch (Exception e) {
            peekFlag = true;
        }
        assertTrue(peekFlag);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        try {
            arb.enqueue(5);
        } catch (Exception e) {
            enqueueFlag = true;
        }
        assertTrue(enqueueFlag);
    }

    @Test
    public void flagTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(3);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.dequeue();
        arb.enqueue(3);
        arb.enqueue(4);
        assertEquals(2, (int) arb.dequeue());
        assertEquals(3, (int) arb.dequeue());
        assertEquals(4, (int) arb.dequeue());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
