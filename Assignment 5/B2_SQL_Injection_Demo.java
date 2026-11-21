public class Main {
    public static void main(String[] args) {
        String userId = "student1";
        String password = "pass123";

        // Unsafe method: user input is joined with SQL
        String unsafeSQL = "SELECT * FROM users WHERE id='" +
                           userId + "' AND pwd='" + password + "'";
        System.out.println("Unsafe SQL:");
        System.out.println(unsafeSQL);

        // Safe method: placeholders are used
        String safeSQL = "SELECT * FROM users WHERE id=? AND pwd=?";
        System.out.println("Safe SQL:");
        System.out.println(safeSQL);
        System.out.println("ID and password are passed separately.");
    }
}