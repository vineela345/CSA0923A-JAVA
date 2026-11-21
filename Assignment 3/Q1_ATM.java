import java.io.*;

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);
    }
}

class Main {
    static double balance = 5000;

    static void withdraw(String amountText) {
        try {
            double amount = Double.parseDouble(amountText);

            if (amount < 0)
                throw new IllegalArgumentException("Negative amount");

            if (amount > balance)
                throw new InsufficientFundsException("Insufficient balance");

            balance = balance - amount;
            System.out.println("Withdraw successful: " + amount);
            System.out.println("Balance: " + balance);

        } catch (NumberFormatException e) {
            System.out.println("Enter numbers only");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Card ejected. Session closed.");
        }
    }

    public static void main(String[] args) {
        withdraw("1000");
        withdraw("abc");
        withdraw("-500");
        withdraw("9000");
    }
}
