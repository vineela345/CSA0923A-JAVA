import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task5C_Converter_AnonymousClass extends JFrame {
    JTextField amount = new JTextField(10);
    JComboBox<String> target = new JComboBox<>(new String[]{"USD", "EUR"});
    JLabel result = new JLabel("Result");

    void convertAmount() {
        try {
            double value = Double.parseDouble(amount.getText());
            double rate = target.getSelectedItem().equals("USD") ? 0.012 : 0.011;
            result.setText(String.format("%.2f", value * rate));
        } catch (Exception e) {
            result.setText("Invalid amount");
        }
    }

    Task5C_Converter_AnonymousClass() {
        setTitle("Currency Converter - Anonymous Class");
        setLayout(new FlowLayout());
        add(new JLabel("INR:"));
        add(amount);
        add(target);
        JButton convert = new JButton("Convert");
        add(convert);
        add(result);

        ActionListener handler = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertAmount();
            }
        };
        convert.addActionListener(handler);
        amount.addActionListener(handler);

        setSize(350, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Task5C_Converter_AnonymousClass().setVisible(true);
    }
}
