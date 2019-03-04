/** Performs some basic linked list tests. */
import java.util.Arrays;

public class ArrayDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkStr(String[] expected, ArrayDeque<String> actual) {
        boolean passed = true;
        if (actual.size() != expected.length) {
            passed = false;
            System.out.println("Wrong size. Expected: "  + expected.length + " Actual: " + actual.size());
        } else {
            for (int i = 0; i < expected.length; i++) {
                if(expected[i] != actual.get(i)) {
                    passed = false;
                    System.out.println("Wrong val at " + i + ". Expected: "  + expected[i] + " Actual: " + actual.get(i));
                    actual.printDeque();
                }
            }
            if (passed) {
                System.out.print("Passed! Expected: " + Arrays.toString(expected) + " Actual: ");
                actual.printDeque();
            } else {
                System.out.println("Failed :(  See above");
            }
        }
        return passed;
    }
    public static boolean checkInt(int[] expected, ArrayDeque<Integer> actual) {
        boolean passed = true;
        if (actual.size() != expected.length) {
            passed = false;
            System.out.println("Wrong size. Expected: "  + expected.length + " Actual: " + actual.size());
        } else {
            for (int i = 0; i < expected.length; i++) {
                if(expected[i] != actual.get(i)) {
                    passed = false;
                    System.out.println("Wrong val at " + i + ". Expected: "  + expected[i] + " Actual: " + actual.get(i));
                }
            }
            if (passed) {
                System.out.print("Passed! Expected: " + Arrays.toString(expected) + " Actual: ");
                actual.printDeque();
            } else {
                System.out.println("Failed :(  See above");
            }
        }
        return passed;
    }
    public static boolean checkDouble(double[] expected, ArrayDeque<Double> actual) {
        boolean passed = true;
        if (actual.size() != expected.length) {
            passed = false;
            System.out.println("Wrong size. Expected: "  + expected.length + " Actual: " + actual.size());
        } else {
            for (int i = 0; i < expected.length; i++) {
                if(expected[i] != actual.get(i)) {
                    passed = false;
                    System.out.println("Wrong val at " + i + ". Expected: "  + expected[i] + " Actual: " + actual.get(i));
                }
            }
            if (passed) {
                System.out.print("Passed! Expected: " + Arrays.toString(expected) + " Actual: ");
                actual.printDeque();
            } else {
                System.out.println("Failed :(  See above");
            }
        }
        return passed;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);

    }

    public static void duplicateTest() {
        System.out.println("Running dublicate test.");

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("1");
        //report(1, lld1);
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("2");
        //report(2, lld1);
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("3");
        passed = checkSize(3, lld1.size()) && passed;
        //report(3, lld1);
        lld1.addLast("4");
        passed = checkSize(4, lld1.size()) && passed;
        //report(4, lld1);
        System.out.println("printing");
        lld1.printDeque();
        ArrayDeque lld2 = new ArrayDeque(lld1);

        lld1.addLast("8");
        //report(5, lld1);
        System.out.println("Testing lld1");
        checkStr(new String[] {"1", "2", "3", "4", "8"}, lld1);

        System.out.println("Testing lld2");
        checkStr(new String[] {"1", "2", "3", "4"}, lld2);

        printTestStatus(passed);

    }

    public static void weirdDuplicateTest() {
        System.out.println("Running weird duplicate test.");

        ArrayDeque<Double> lld1 = new ArrayDeque<Double>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(1.0);

        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast(2.0);
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast(3.0);
        passed = checkSize(3, lld1.size()) && passed;

        lld1.addLast(4.0);
        passed = checkSize(4, lld1.size()) && passed;


        ArrayDeque lld2 = new ArrayDeque(lld1);

        lld1.addLast(8.0);

        System.out.println("Testing lld1");
        checkDouble(new double[] {1.0, 2.0, 3.0, 4.0, 8.0}, lld1);

        System.out.println("Testing lld2");
        checkInt(new int[] {1, 2, 3, 4}, lld2);

        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");


        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());
        System.out.print("should have nothing: ");
        lld1.printDeque();

        lld1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;
        System.out.print("should say 10: ");
        lld1.printDeque();

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;
        System.out.print("should have nothing: ");
        lld1.printDeque();

        printTestStatus(passed);

    }

    public static ArrayDeque<String> makeSomething() {
        ArrayDeque<String> lld = new ArrayDeque<String>();
        lld.addFirst("hewwo");
        lld.addLast("uwu");
        lld.addFirst("omg");
        lld.addFirst("owo");
        lld.addLast("NOTICE ME SENPAIIII UWUWUWU");
        lld.addLast("you shouldn't be seeing this");
        lld.removeFirst();
        lld.addFirst("re-owo");
        lld.removeLast();
        return lld;
    }
    /*
    private static void report(int step, ArrayDeque thing) {
        System.out.println("step: " + step + " lcounter: " + thing.lCount + " rcounter: " + thing.rCount + " size:  " +  thing.size());
    }
    */
    private static void manualTest() {
        ArrayDeque<Integer> addy = new ArrayDeque<Integer>();
        for(int i = 0; i < 100; i++) {
            addy.addLast(i);
        }
        for(int i = -1; i > -100; i--) {
            addy.addFirst(i);
        }
        addy.printDeque();
        for(int i = -1; i > -150; i--) {
            addy.removeLast();
        }
        addy.printDeque();

    }
    public static void main(String[] args) {
        System.out.println("Running tests.\n");

        addIsEmptySizeTest();
        addRemoveTest();
        duplicateTest();

        manualTest();
    }
} 