import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task5B_Converter_InnerClass extends JFrame {
    JTextField amount = new JTextField(10);
    JComboBox<String> target = new JComboBox<>(new String[]{"USD", "EUR"});
    JLabel result = new JLabel("Result");

    class ConvertHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            convertAmount();
        }
    }

    void convertAmount() {
        try {
            double value = Double.parseDouble(amount.getText());
            double rate = target.getSelectedItem().equals("USD") ? 0.012 : 0.011;
            result.setText(String.format("%.2f", value * rate));
        } catch (Exception e) {
            result.setText("Invalid amount");
        }
    }

    Task5B_Converter_InnerClass() {
        setTitle("Currency Converter - Inner Class");
        setLayout(new FlowLayout());
        add(new JLabel("INR:"));
        add(amount);
        add(target);
        JButton convert = new JButton("Convert");
        add(convert);
        add(result);

        ConvertHandler handler = new ConvertHandler();
        convert.addActionListener(handler);
        amount.addActionListener(handler);

        setSize(350, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Task5B_Converter_InnerClass().setVisible(true);
    }
}
