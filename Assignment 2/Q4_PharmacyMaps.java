import java.util.*;

public class Q4_PharmacyMaps {
    static void testMap(String name, Map<String, Integer> map) {
        map.put("MED103", 25);
        map.put("MED101", 40);
        map.put("MED104", 15);
        map.put("MED102", 30);

        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            map.get("MED102");
        }
        long lookupEnd = System.nanoTime();

        long reportStart = System.nanoTime();
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            System.out.println(item.getKey() + " : " + item.getValue());
        }
        long reportEnd = System.nanoTime();

        System.out.println(name + " lookup time: "
                + (lookupEnd - start) / 1_000_000.0 + " ms");
        System.out.println(name + " report time: "
                + (reportEnd - reportStart) / 1_000_000.0 + " ms");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("HashMap: no guaranteed order");
        testMap("HashMap", new HashMap<String, Integer>());

        System.out.println("TreeMap: medicine-code order");
        testMap("TreeMap", new TreeMap<String, Integer>());

        System.out.println("LinkedHashMap: insertion order");
        testMap("LinkedHashMap", new LinkedHashMap<String, Integer>());

        System.out.println("Recommendation: TreeMap for code-order report.");
        System.out.println("LinkedHashMap for insertion-order report.");
        System.out.println("HashMap for fast lookup when order is not needed.");
    }
}
