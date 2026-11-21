import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "buspass.txt";

        // Add two bus-pass records
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        bw.write("P101|192311001|Arun|12|Avadi|2026-12-31|4500");
        bw.newLine();
        bw.write("P102|192311002|Divya|7|Tambaram|2026-12-31|3800");
        bw.close();

        // Display all records and search for P101
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        boolean found = false;

        while ((line = br.readLine()) != null) {
            String[] data = line.split("\\\\|");
            if (data.length == 7) {
                if (data[0].equals("P101")) {
                    System.out.println("Pass Found: " + line);
                    found = true;
                }
            } else {
                System.out.println("Damaged record skipped");
            }
        }
        br.close();

        if (!found) System.out.println("Pass not found");
    }
}