public class LinkedListDeque<T> {
    private class ListNode {
        private ListNode pre;
        private ListNode next;
        private T item;

        private ListNode(ListNode p, T value, ListNode n) {
            pre = p;
            next = n;
            item = value;
        }
    }

    private int size;
    private ListNode sentinel;

    /** Create an empty linked list deque*/
    public LinkedListDeque() {
        sentinel = new ListNode(null, null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        sentinel.next = new ListNode(sentinel, item, sentinel.next);
        sentinel.next.next.pre = sentinel.next;
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        sentinel.pre = new ListNode(sentinel.pre, item, sentinel);
        sentinel.pre.pre.next = sentinel.pre;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return (size == 0);
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last,
     * separated by a space. */
    public void printDeque() {
        ListNode current = sentinel;
        while (current.next != sentinel) {
            current = current.next;
            System.out.print(current.item + " ");
        }
        System.out.print("\n");
    }

    /** Removes and returns the item at the front of the deque.
     *  If no such item exists, returns null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T returnItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.pre = sentinel;
        size -= 1;

        return returnItem;
    }

    /** Removes and returns the item
     * at the back of the deque.
     *  If no such item exists, returns null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T returnItem = sentinel.pre.item;
        sentinel.pre = sentinel.pre.pre;
        sentinel.pre.next = sentinel;
        size -= 1;

        return returnItem;
    }

    /** Gets the item at the given index,
     * where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists,
     * returns null.
     * Must not alter the deque! */
    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        ListNode current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.item;
    }

    /** Same as get function, but uses recursion. */
    public T getRecursive(int index) {
        if (index > size - 1) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    /** Helper function of getRecursive function. */
    private T getRecursiveHelper(ListNode node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }
}
