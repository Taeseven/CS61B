import org.junit.Test;
import static org.junit.Assert.*;

/** Dummy test cases. */
public class ArrayDequeTest {

    @Test
    public void isEmptyTest1() {

        System.out.println("Perform IsEmptyTest1");

        ArrayDeque<Integer> array = new ArrayDeque();

        // Test isEmpty()
        assertEquals(array.isEmpty(), true);

    }


    @Test
    public void isEmptyTest2() {

        System.out.println("Perform IsEmptyTest2");

        ArrayDeque<Integer> array = new ArrayDeque();

        array.addFirst(1);
        array.addLast(2);

        // Test isEmpty()
        assertEquals(array.isEmpty(), false);
    }


    @Test
    public void printDequeTest() {

        System.out.println("Perform printDequeTest1");

        ArrayDeque<Integer> array = new ArrayDeque();

        array.addFirst(1);
        array.addFirst(2);
        array.addFirst(3);
        array.addFirst(4);
        array.addFirst(5);
        array.addFirst(6);
        array.addFirst(7);
        array.addFirst(8);

        array.printDeque();
        System.out.println(array.removeFirst());
    }

    @Test
    public void addFirstLastTest1() {

        System.out.println("Perform addFirstLastTest1");

        ArrayDeque<Integer> array = new ArrayDeque();

        array.addFirst(1);
        array.addLast(2);
        array.addFirst(3);
        array.addLast(4);

        array.printDeque();

        array.addFirst(5);
        array.addLast(6);
        array.addFirst(7);
        array.addLast(8);

        array.printDeque();

        array.addFirst(9);
        array.addLast(10);
        array.addFirst(11);
        array.addLast(12);

        array.printDeque();
    }


    @Test
    public void addFirstLastTest2() {

        System.out.println("Perform addFirstLastTest2");

        ArrayDeque<Integer> array = new ArrayDeque();
        for (int i = 1; i <= 24; i++) {
            if (i % 2 != 0) {
                array.addFirst(i);
            } else {
                array.addLast(i);
            }
        }

        array.printDeque();
//        array.addFirst(9);
//        array.addFirst(10);
//        array.printDeque();
    }


    @Test
    public void removeFirstLast1() {
        System.out.println("Perform removeFirstLast1");

        ArrayDeque<Integer> array = new ArrayDeque();

        array.addFirst(1);
        array.addLast(2);
        array.addFirst(3);
        array.addLast(4);

        array.printDeque();

        array.removeFirst();
        array.printDeque();
    }


    @Test
    public void removeFirstLast2() {
        System.out.println("Perform removeFirstLast2");

        ArrayDeque<Integer> array = new ArrayDeque();

        for (int i = 0; i <= 7; i++) {
            if (i % 2 == 0) {
                array.addFirst(i);
            } else {
                array.addLast(i);
            }
        }

        array.printDeque();

        array.removeFirst();
        array.printDeque();

        array.removeLast();
        array.printDeque();
    }


    @Test
    public void removeFirstLast3() {
        System.out.println("Perform removeFirstLast3");

        ArrayDeque<Integer> array = new ArrayDeque();

        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) {
                array.addFirst(i);
            } else {
                array.addLast(i);
            }

        }

        array.printDeque();

        array.removeFirst();
//        array.removeLast();
        array.printDeque();
//        int x;
//        for (int i = 0; i < 10; i++) {
//            if (i % 2 == 0) {
//                x = array.removeFirst();
//            } else {
//                x = array.removeLast();
//            }
//            array.printDeque();
//
//            if ((i + 1) % 8 == 0) {
//                array.printDeque();
//            }

            // System.out.println("nextFirst: " + array.nextFirst);
            // System.out.println("nextLast: " + array.nextLast);

//        }

    }


    @Test
    public void removeFirstLast4() {
        System.out.println("Perform removeFirstLast4");

        ArrayDeque<Integer> array = new ArrayDeque();

        for (int i = 0; i <= 16; i++) {
            if (i % 2 == 0) {
                array.addFirst(i);
            } else {
                array.addLast(i);
            }

        }

        array.printDeque();
        int x;
        for (int i = 0; i < 12; i++) {
            if (i % 2 == 0) {
                x = array.removeFirst();
            } else {
                x = array.removeLast();
            }

            if ((i + 1) % 8 == 0) {
                System.out.println("ha!");
                array.printDeque();
            }

            // System.out.println("nextFirst: " + array.nextFirst);
            // System.out.println("nextLast: " + array.nextLast);

        }

    }


    @Test
    public void getTest() {
        System.out.println("Perform getTest");

        ArrayDeque<Integer> array = new ArrayDeque();

        array.addFirst(1);
        array.addFirst(2);

        System.out.println(array.get(0));
    }
}
