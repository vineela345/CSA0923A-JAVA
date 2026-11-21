import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "sample.txt";

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        bw.write("First line");
        bw.newLine();
        bw.write("Second line");
        bw.newLine();
        bw.write("Third line");
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        int count = 0;
        while (br.readLine() != null) {
            count++;
        }
        br.close();

        System.out.println("Total lines: " + count);
        System.out.println("Buffered reading completed.");
    }
}