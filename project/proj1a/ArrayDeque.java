public class ArrayDeque<T> {

    private int size;
    private T[] items;
    private int nextFirst = 7;
    private int nextLast = 0;

    /** Creates an empty array deque */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T value) {
        items[nextFirst] = value;
        nextFirst = (nextFirst - 1) & (items.length - 1);
        size += 1;
        if (size == items.length) {
            resize(items.length * 2);
        }
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T value) {
        items[nextLast] = value;
        nextLast = (nextLast + 1) % (items.length);
        size += 1;
        if (size == items.length) {
            resize(items.length * 2);
        }
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return (size == 0);
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        for (T value : items) {
            System.out.print(value + " ");
        }
        System.out.print("\n");
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = (nextFirst + 1) % (items.length);
        T returnItem =  items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        if (isShrink()) {
            resize(items.length / 2);
        }

        return returnItem;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = (nextLast - 1) & (items.length - 1);
        T returnItem = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        if (isShrink()) {
            resize(items.length / 2);
        }

        return returnItem;
    }

    /** Gets the item at the given index,
     * where 0 is the front,
     * 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * Must not alter the deque! */
    public T get(int index) {
        if (index > items.length - 1) {
            return null;
        }
        int trueIndex = (nextFirst + 1) % (items.length);
        for (int i = 0; i < index; i++) {
            trueIndex = (trueIndex + 1) % (items.length);
        }

        return items[trueIndex];
    }

    /** Check usage of array, return true if needs to shrink the size of array. */
    private boolean isShrink() {
        float usage = (float) size / items.length;
        return ((usage < 0.25) && (items.length > 16));
    }

    /** Resize the array. */
    private void resize(int capacity) {

        T[] newItems = (T[]) new Object[capacity];
        nextFirst = (nextFirst + 1) % (items.length);
        int newIndex = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[nextFirst] != null) {
                newItems[newIndex] = items[nextFirst];
                nextFirst = (nextFirst + 1) % (items.length);
                newIndex += 1;
            }
        }


//        int start = 0;
//        int end = 0;
//
//        if (isShrink()) {
//            for (int i = 0; i < items.length - 1; i++) {
//                if (items[i] == null && items[i + 1] != null) {
//                    start = i + 1;
//                }
//                if (items[i] != null && items[i + 1] == null) {
//                    end = i;
//                }
//                if ((start != 0) && (end != 0)) {
//                    break;
//                }
//            }
//
//            System.arraycopy(items, start, newItems, 1, end - start + 1);
//            nextFirst = 0;
//            nextLast = end - start + 2;
//        } else {
//            System.arraycopy(items, 0, newItems, 1, items.length);
//            nextFirst = 0;
//            nextLast = items.length + 1;
//        }

        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;

    }
}
