import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> records = new ArrayList<String>();

        records.add("P101, Arun, Route 12");
        records.add("P102, Divya, Route 7");
        records.add("P103, Ravi, Route 12");

        System.out.println("Adding records in a batch:");

        for (String record : records) {
            System.out.println("Inserted: " + record);
        }

        System.out.println("Batch executed successfully.");
        System.out.println("Total records inserted: " + records.size());
        System.out.println("In JDBC, addBatch() and executeBatch() perform this operation.");
    }
}