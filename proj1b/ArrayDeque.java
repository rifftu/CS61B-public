public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int rCount;
    private int lCount;

    public ArrayDeque() {
        items = (T []) new Object[8];
        rCount = 4;
        lCount = 3;
    }

    public ArrayDeque(ArrayDeque other) {
        items = (T []) new Object[8];
        rCount = 4;
        lCount = 3;
        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }

    }

    private void expand(boolean R) {
        //R == true -> expand to right, else expand to left
        T[] lomgBoi = (T []) new Object[items.length * 2];
        int size = size();
        if (R) {
            System.arraycopy(items, lCount + 1, lomgBoi, lCount + 1, size);
        } else {
            System.arraycopy(items, lCount + 1, lomgBoi, lCount + 1 + items.length, size);

            lCount = lCount + items.length;
            rCount = rCount + items.length;
        }

        items = lomgBoi;

        checkShrink();
    }

    private void shrink() {
        //m a t h  t i m e : - )
        int size = size();
        int len = items.length;
        int a = lCount;
        int b = a + len / 4 + 1;
        //int x = ((a + b + 1) / 2 - (len / 4));
        int x = a - (len / 8) + 1;
        T[] shortBoi = (T []) new Object[items.length / 2];
        System.arraycopy(items, a + 1, shortBoi, a + 1 - x, size);
        lCount = a - x;
        rCount = rCount - x;
        items = shortBoi;

        /*
        if(size() < items.length / 2) {
            System.out.println("Too much ono");
            printDeque();
        }

        */
    }

    public void addFirst(T item) {
        if (lCount == 0) {
            expand(false);
        }
        items[lCount] = item;
        lCount--;

    }

    public void addLast(T item) {
        if (rCount == items.length - 1) {
            expand(true);
        }
        items[rCount] = item;
        rCount++;
    }

    public T removeFirst() {
        if (size() == 0) {
            return null;
        } else {
            T item = items[lCount + 1];
            lCount++;
            checkShrink();
            return item;
        }
    }

    public T removeLast() {
        if (size() == 0) {
            return null;
        } else {
            T item = items[rCount - 1];
            rCount--;
            checkShrink();
            return item;
        }
    }
    // style remove the return val
    private void checkShrink() {
        if (size() <= items.length / 4 && items.length > 8) {
            shrink();
        }
    }


    public int size() {
        return (rCount - lCount - 1);
    }

    public void printDeque() {
        for (int i = 0; i < size(); i++) {
            System.out.print(items[lCount + 1 + i] + " ");
        }
        System.out.println();
    }

    public T get(int index) {
        if (index < size()) {
            return items[lCount + 1 + index];
        } else {
            return null;
        }
    }

}
