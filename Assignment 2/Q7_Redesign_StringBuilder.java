public class Q7_Redesign_StringBuilder {
    // Original approach: repeated + creates many temporary String objects.
    static String original(int fields) {
        String ticket = "";
        for (int i = 1; i <= fields; i++) {
            ticket = ticket + "Field" + i + " ";
        }
        return ticket;
    }

    // Redesigned approach: one mutable builder is reused for the ticket.
    static String redesigned(int fields) {
        StringBuilder ticket = new StringBuilder(fields * 10);
        for (int i = 1; i <= fields; i++) {
            ticket.append("Field").append(i).append(" ");
        }
        return ticket.toString();
    }

    static long measure(boolean useBuilder, int fields, int tickets) {
        long start = System.nanoTime();
        long length = 0;
        for (int i = 0; i < tickets; i++) {
            String result = useBuilder ? redesigned(fields) : original(fields);
            length += result.length();
        }
        long end = System.nanoTime();
        System.out.println("Total characters: " + length);
        return end - start;
    }

    public static void main(String[] args) {
        int fields = 100;
        int tickets = 5000;

        // Warm-up
        measure(true, fields, 500);
        measure(false, fields, 500);

        System.out.println("Original repeated +: "
                + measure(false, fields, tickets) / 1_000_000.0 + " ms");
        System.out.println("Redesigned StringBuilder: "
                + measure(true, fields, tickets) / 1_000_000.0 + " ms");

        System.out.println("Expected: repeated + can take O(n^2) copying.");
        System.out.println("StringBuilder takes about O(n) append work.");
    }
}
