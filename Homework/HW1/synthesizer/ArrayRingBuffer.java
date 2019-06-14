// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;

import java.util.Iterator;

// TODO: Make sure to make this class and all of its methods public
// TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T>  extends  AbstractBoundedQueue<T> {

    private int first; // index for the next dequeue or peek

    private int last; // index for the next enqueue

    private T[] rb; // Array for storing the buffer data

    // TODO: When you get to part 5, implement the needed code to support iteration.
    @Override
    public Iterator<T> iterator() {
        return new BufferIterator();
    }

    private class BufferIterator implements Iterator<T> {
        private int ptr;

        public BufferIterator() {
            ptr = first;
        }

        @Override
        public boolean hasNext() {
            return ptr != last;
        }

        @Override
        public T next() {
            T toReturn = rb[ptr];
            ptr = (ptr + 1 == capacity ? 0 : ptr + 1);
            return toReturn;
        }
    }

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        first = 0;
        last = 0;
        this.fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];

    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        last = (last + 1 == capacity ? 0 : last + 1);
        fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update 
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T toReturn = rb[first];
        rb[first] = null;
        first = (first + 1 == capacity ? 0 : first + 1);
        fillCount -= 1;
        return toReturn;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
