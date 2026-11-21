import javax.swing.*;
import java.awt.*;

public class Task5D_Converter_Lambda extends JFrame {
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

    Task5D_Converter_Lambda() {
        setTitle("Currency Converter - Lambda");
        setLayout(new FlowLayout());
        add(new JLabel("INR:"));
        add(amount);
        add(target);
        JButton convert = new JButton("Convert");
        add(convert);
        add(result);

        convert.addActionListener(e -> convertAmount());
        amount.addActionListener(e -> convertAmount());

        setSize(350, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Task5D_Converter_Lambda().setVisible(true);
    }
}
