import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "passes.txt";

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        bw.write("P101|192311001|Arun|12|Avadi|2026-12-31|4500");
        bw.newLine();
        bw.write("P102|192311002|Divya|7|Tambaram|2026-12-31|3800");
        bw.newLine();
        bw.write("DAMAGED RECORD");
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        int count = 0;

        while ((line = br.readLine()) != null) {
            count++;
            String[] data = line.split("\\\\|");
            if (data.length != 7) {
                System.out.println("Damaged line skipped: " + line);
            } else if (data[0].equals("P102")) {
                System.out.println("Found record: " + line);
            }
        }
        br.close();

        System.out.println("Total lines: " + count);
    }
}