package es.datastructur.synthesizer;
import java.util.Iterator;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer<T> implements BoundedQueue<T> {

    private class ArrayRingIterator implements Iterator<T> {
        private int wizPos;
        public ArrayRingIterator() {
            wizPos = first;
        }
        public boolean hasNext() {
            return wizPos != last;
        }
        public T next() {
            T returnItem = rb[wizPos];
            wizPos += 1;
            if (wizPos == rb.length) {
                wizPos = 0;
            }
            return returnItem;
        }
    }
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T []) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        if (fillCount == rb.length) {
            throw new RuntimeException("Ring Buffer overflow");
        }
        rb[last] = x;
        last++;
        fillCount++;
        if(last == rb.length) {
            last = 0;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        if(fillCount == 0) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        T item = rb[first];
        first++;
        fillCount--;
        if(first == rb.length) {
            first = 0;
        }
        return item;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        if(fillCount == 0) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        return rb[first];
    }

    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    public Iterator<T> iterator() {
        return new ArrayRingIterator();
    }

    @Override
    public boolean equals(Object o) {
        if((!(o instanceof ArrayRingBuffer)) || ((ArrayRingBuffer) o).fillCount() != fillCount) {
            return false;
        }
        for(int i = 0; i < fillCount; i++) {
            T a = dequeue();
            T b = (T) ((ArrayRingBuffer) o).dequeue();
            if(!a.equals(b)) {
                return false;
            }
            enqueue(a);
            ((ArrayRingBuffer) o).enqueue(b);
        }
        return true;
    }

    // TODO: When you get to part 4, implement the needed code to support
    //       iteration and equals.
}
    // TODO: Remove all comments that say TODO when you're done.
