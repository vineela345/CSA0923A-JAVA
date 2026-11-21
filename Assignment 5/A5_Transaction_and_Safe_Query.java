public class Main {
    public static void main(String[] args) {
        int hostelWallet = 2000;
        int canteenWallet = 500;
        int amount = 500;

        System.out.println("Before transfer:");
        System.out.println("Hostel wallet: " + hostelWallet);
        System.out.println("Canteen wallet: " + canteenWallet);

        // Simple transaction demonstration
        if (hostelWallet >= amount) {
            hostelWallet = hostelWallet - amount;
            canteenWallet = canteenWallet + amount;
            System.out.println("Transfer successful");
        } else {
            System.out.println("Transfer failed");
        }

        System.out.println("After transfer:");
        System.out.println("Hostel wallet: " + hostelWallet);
        System.out.println("Canteen wallet: " + canteenWallet);

        // Safe SQL uses placeholders instead of joining user input
        String sql = "SELECT * FROM users WHERE id=? AND pwd=?";
        System.out.println("Safe SQL: " + sql);
        System.out.println("User values are supplied separately.");
    }
}