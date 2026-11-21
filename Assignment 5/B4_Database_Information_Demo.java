public class Main {
    public static void main(String[] args) {
        // Simple demonstration of database details
        String databaseName = "MySQL";
        String databaseVersion = "8.0";
        String driverName = "MySQL JDBC Driver";

        System.out.println("Database Name: " + databaseName);
        System.out.println("Database Version: " + databaseVersion);
        System.out.println("Driver Name: " + driverName);

        System.out.println("Example tables:");
        System.out.println("1. bus_pass");
        System.out.println("2. student");
        System.out.println("3. users");

        System.out.println("Actual database details are read using JDBC DatabaseMetaData.");
    }
}