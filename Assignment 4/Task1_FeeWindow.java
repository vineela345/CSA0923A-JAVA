import javax.swing.*;
import java.awt.*;

public class Task1_FeeWindow extends JFrame {
    JTextField reg = new JTextField(10);
    JTextField amount = new JTextField(10);
    JLabel status = new JLabel("Enter fee details");

    Task1_FeeWindow() {
        setTitle("Student Fee Payment");
        setLayout(new FlowLayout());

        add(new JLabel("Register Number:"));
        add(reg);
        add(new JLabel("Amount:"));
        add(amount);

        JButton pay = new JButton("Pay");
        JButton clear = new JButton("Clear");
        JButton receipt = new JButton("Receipt");

        add(pay);
        add(clear);
        add(receipt);
        add(status);

        pay.addActionListener(e -> {
            try {
                String id = reg.getText().trim();
                double fee = Double.parseDouble(amount.getText());

                if (id.isEmpty() || fee <= 0) {
                    status.setText("Enter valid details");
                } else {
                    status.setText("Payment successful: Rs. " + fee);
                }
            } catch (Exception ex) {
                status.setText("Enter a valid amount");
            }
        });

        clear.addActionListener(e -> {
            reg.setText("");
            amount.setText("");
            status.setText("Fields cleared");
        });

        receipt.addActionListener(e -> {
            if (reg.getText().trim().isEmpty())
                status.setText("Enter register number");
            else
                status.setText("Receipt for " + reg.getText());
        });

        setSize(420, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Task1_FeeWindow().setVisible(true);
    }
}
