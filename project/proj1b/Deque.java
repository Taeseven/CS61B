public interface Deque<Item> {
//    All method in interface must be public.
//    Without 'public' still work.

    /** Add one item to the front of the queue. */
    public void addFirst(Item i);

    /** Add one item to the back of the queue.  */
    public void addLast(Item i);

    /** Return a boolean to tell if a queue is empty. */
    public boolean isEmpty();

    /** Return number of items of a queue. */
    public int size();

    /** Print every elements in a queue, separated by a space. */
    public void printDeque();

    /** Removes and returns the item at the front of the deque.*/
    public Item removeFirst();

    /** Removes and returns the item at the back of the deque. */
    public Item removeLast();

    /** Gets the item at the given index. */
    public Item get(int index);
}
