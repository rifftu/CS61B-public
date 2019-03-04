public class LinkedListDeque<T> {
    private class Node {
        private T item;
        private Node next;
        private Node prev;

        Node(T i, Node p, Node n)  {
            item = i;
            next = n;
            prev = p;
        }

    }

    private Node sentinel;
    private Node first;
    private Node last;
    private int size;

    public LinkedListDeque() {
        // create a new empty one
        sentinel = new Node(null, sentinel, sentinel);
        first = sentinel;
        last = sentinel;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque other) {

        // create a new one but not empty
        // style just call the original once?

        sentinel = new Node(null, sentinel, sentinel);
        first = sentinel;
        last = sentinel;
        size = 0;

        //style change this to a while loop using p
        for (int i = 0; i < other.size; i++) {
            addLast((T) other.get(i));
        }


    }


    public void addFirst(T item) {
        first.prev = new Node(item, sentinel, first);
        first = first.prev;
        size = size + 1;
        sentinel.next = first;
        if (size == 1) {
            last = first;
            sentinel.prev = last;
        }
    }
    public void addLast(T item) {
        last.next = new Node(item, last, sentinel);
        last = last.next;
        size = size + 1;
        sentinel.prev = last;
        if (size == 1) {
            first = last;
            sentinel.next = first;
        }
    }


    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = first;
        while (p != sentinel) {
            //style - combine?
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
        //style - remove quotes?
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            Node p = first;
            first = first.next;
            first.prev = sentinel;
            sentinel.next = first;
            size = size - 1;
            return p.item;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            Node p = last;
            last = last.prev;
            last.next = sentinel;
            sentinel.prev = last;
            size = size - 1;
            return p.item;
        }
    }

    public T get(int index) {
        Node p = first;
        while (index > 0) {
            if (p == sentinel) {
                return null;
            }
            p = p.next;
            index--;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        return recursor(index, first);
    }
    private T recursor(int index, Node p) {
        if (p == sentinel) {
            return  null;
        } else if (index == 0) {
            return p.item;
        } else {
            return recursor(index - 1, p.next);
        }
    }

}
