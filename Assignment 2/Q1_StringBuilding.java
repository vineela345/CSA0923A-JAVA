public class Q1_StringBuilding {
    static String usingString(int fields) {
        String ticket = "";
        for (int i = 1; i <= fields; i++) {
            ticket = ticket + "Field" + i + " ";
        }
        return ticket;
    }

    static String usingBuilder(int fields) {
        StringBuilder ticket = new StringBuilder();
        for (int i = 1; i <= fields; i++) {
            ticket.append("Field").append(i).append(" ");
        }
        return ticket.toString();
    }

    static String usingBuffer(int fields) {
        StringBuffer ticket = new StringBuffer();
        for (int i = 1; i <= fields; i++) {
            ticket.append("Field").append(i).append(" ");
        }
        return ticket.toString();
    }

    static void test(String name, int fields, int tickets) {
        long start = System.nanoTime();
        long totalLength = 0;
        for (int i = 0; i < tickets; i++) {
            String result;
            if (name.equals("String")) result = usingString(fields);
            else if (name.equals("StringBuilder")) result = usingBuilder(fields);
            else result = usingBuffer(fields);
            totalLength += result.length();
        }
        long end = System.nanoTime();
        System.out.println(name + " time: " + (end - start) / 1_000_000.0
                + " ms | characters: " + totalLength);
    }

    public static void main(String[] args) {
        System.out.println("WORKLOAD 1: 1 ticket, 5 fields");
        test("String", 5, 1);
        test("StringBuilder", 5, 1);
        test("StringBuffer", 5, 1);

        System.out.println("\\nWORKLOAD 2: 10000 tickets, 50 fields");
        test("String", 50, 10000);
        test("StringBuilder", 50, 10000);
        test("StringBuffer", 50, 10000);

        System.out.println("\\nWORKLOAD 3: 1000 tickets, 200 fields");
        test("String", 200, 1000);
        test("StringBuilder", 200, 1000);
        test("StringBuffer", 200, 1000);

        System.out.println("\\nExpected: StringBuilder is usually fastest for repeated changes.");
        System.out.println("StringBuffer is synchronized; String is immutable.");
    }
}
