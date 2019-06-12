import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testGold() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<>();
        String message = "";

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad.addLast(i);
                sol.addLast(i);
                message += "addLast(" + i + ")\n";
//                assertEquals(message, (Object) i, input.get(input.size() - 1));

            } else {
                sad.addFirst(i);
                sol.addFirst(i);
//                assertEquals(message + "addFirst()\n", (Object) i, input.get(0));
                message += "addFirst(" + i + ")\n";
            }
        }
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                message += "removeFirst()\n";
                assertEquals(message, sol.removeFirst(), sad.removeFirst());

            } else {
                message += "removeLast()\n";
                assertEquals(message, sol.removeLast(), sad.removeLast());
            }
        }
    }
}