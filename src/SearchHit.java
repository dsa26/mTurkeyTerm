import java.util.Arrays;
import java.util.Random;

/// fixed balanced, tried put, fixed shuffle




public class SearchHit {

    public static void main(String[] args) {
        SearchHit t = new SearchHit();
        t.run();
    }

    //best, average, worst
    BSTI[] treesToTest = new BSTI[3];
    String[] treeTypes = new String[]{"Best", "Random", "Worst"};


    //made copies of number arrays
    private BSTI[] sizingTreesToTest(int[] numbers) {
        BSTI best = TreeTypes.balancedTree(Arrays.copyOf(numbers, numbers.length));
        System.out.println("best made");
        BSTI random = TreeTypes.shuffledTree(TreeTypes.shuffle(Arrays.copyOf(numbers, numbers.length)));
        System.out.println("random made");
        BSTI worst = TreeTypes.linkedListTree(Arrays.copyOf(numbers, numbers.length));
        System.out.println("worst made");

        treesToTest[0] = best;
        treesToTest[1] = random;
        treesToTest[2] = worst;

        return treesToTest;
    }

    public void run() {
        test100();
        test1000();
        test10000();
        test100000();
        test1000000();
        test10000000();
    }

    private void test100() {
        System.out.println("----------------------------------------------\nTREE SIZE: ONE HUNDRED ITEMS");
        sizingTreesToTest(NumberArrays.numbers0To100);
        for (int i = 0; i < 3; i++) {
            testTree(treesToTest[i], 100, treeTypes[i]);
        }
        System.out.println("----------------------------------------------\n");
    }

    private void test1000() {
        System.out.println("----------------------------------------------\nTREE SIZE: ONE THOUSAND ITEMS");
        sizingTreesToTest(NumberArrays.numbers0To1000);
        for (int i = 0; i < 3; i++) {
            testTree(treesToTest[i], 1000, treeTypes[i]);
        }
        System.out.println("----------------------------------------------\n");
    }

    private void test10000() {
        System.out.println("----------------------------------------------\nTREE SIZE: TEN THOUSAND ITEMS");
        sizingTreesToTest(NumberArrays.numbers0To10000);
        for (int i = 0; i < 3; i++) {
            testTree(treesToTest[i], 10000, treeTypes[i]);
        }
        System.out.println("----------------------------------------------\n");
    }

    private void test100000() {
        System.out.println("----------------------------------------------\nTREE SIZE: ONE HUNDRED THOUSAND ITEMS");
        sizingTreesToTest(NumberArrays.numbers0To100000);
        System.out.println("testing");
        for (int i = 0; i < 3; i++) {
            testTree(treesToTest[i], 100000, treeTypes[i]);
        }
        System.out.println("----------------------------------------------\n");
    }

    private void test1000000() {
        System.out.println("----------------------------------------------\nTREE SIZE: ONE MILLION ITEMS");
        sizingTreesToTest(NumberArrays.numbers0To1000000);
        System.out.println("testing");
        for (int i = 0; i < 3; i++) {
            testTree(treesToTest[i], 1000000, treeTypes[i]);
        }
        System.out.println("----------------------------------------------\n");
    }

    private void test10000000() {
        System.out.println("----------------------------------------------\nTREE SIZE: TEN MILLION ITEMS");
        sizingTreesToTest(NumberArrays.numbers0To10000000);
        for (int i = 0; i < 3; i++) {
            testTree(treesToTest[i], 10000000, treeTypes[i]);
        }
        System.out.println("----------------------------------------------\n");
    }

    private void testTree(BSTI tree, int size, String structure) {
        Random rgen = new Random();

        long start = System.nanoTime();

        for (int i = 0; i < 50_000; i++) {
            tree.search(rgen.nextInt(size));
        }

        long end = System.nanoTime();
        long duration = end - start;

        System.out.println("Duration(" + structure + "): " + (duration / 1_000_000.0) + " ms ");
    }
}
