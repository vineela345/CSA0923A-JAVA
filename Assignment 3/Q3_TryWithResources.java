import java.io.*;

class Main {
    public static void main(String[] args) {
        // try-with-resources closes the file automatically
        try (FileWriter writer = new FileWriter("report.txt")) {
            writer.write("Daily sales report");
            writer.write("\nTotal sales: 5000");
            System.out.println("Report written successfully");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("report.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Could not read report");
        }
    }
}
