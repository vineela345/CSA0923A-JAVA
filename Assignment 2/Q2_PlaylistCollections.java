import java.util.*;

public class Q2_PlaylistCollections {
    static void testList(String name, List<Integer> list, int n) {
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) list.add(i);
        long addEnd = System.nanoTime();

        list.add(0, -1);
        list.add(list.size() / 2, -2);
        long insertEnd = System.nanoTime();

        list.remove(0);
        list.remove(list.size() / 2);
        long removeEnd = System.nanoTime();

        int value = list.get(list.size() / 2);
        long getEnd = System.nanoTime();

        long sum = 0;
        for (int x : list) sum += x;
        long iterateEnd = System.nanoTime();

        System.out.println("\\n" + name + " (" + n + " songs)");
        System.out.println("Add at end: " + (addEnd - start) / 1_000_000.0 + " ms");
        System.out.println("Insert front/middle: " + (insertEnd - addEnd) / 1_000_000.0 + " ms");
        System.out.println("Remove front/middle: " + (removeEnd - insertEnd) / 1_000_000.0 + " ms");
        System.out.println("Get middle: " + (getEnd - removeEnd) / 1_000_000.0 + " ms");
        System.out.println("Iteration: " + (iterateEnd - getEnd) / 1_000_000.0 + " ms");
        System.out.println("Middle song: " + value + ", sum: " + sum);
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 50000};
        for (int n : sizes) {
            testList("ArrayList", new ArrayList<Integer>(), n);
            testList("LinkedList", new LinkedList<Integer>(), n);
        }

        ArrayDeque<Integer> upNext = new ArrayDeque<>();
        upNext.addFirst(10);
        upNext.addLast(20);
        upNext.addFirst(5);
        System.out.println("\\nArrayDeque Up Next queue: " + upNext);
        upNext.removeFirst();
        System.out.println("After removing first song: " + upNext);
    }
}
