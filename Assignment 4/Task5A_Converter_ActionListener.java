import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task5A_Converter_ActionListener extends JFrame
        implements ActionListener {
    JTextField amount = new JTextField(10);
    JComboBox<String> target = new JComboBox<>(new String[]{"USD", "EUR"});
    JLabel result = new JLabel("Result");

    Task5A_Converter_ActionListener() {
        setTitle("Currency Converter - ActionListener");
        setLayout(new FlowLayout());
        add(new JLabel("INR:"));
        add(amount);
        add(target);
        JButton convert = new JButton("Convert");
        add(convert);
        add(result);

        convert.addActionListener(this);
        amount.addActionListener(this);

        setSize(350, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        convertAmount();
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

    public static void main(String[] args) {
        new Task5A_Converter_ActionListener().setVisible(true);
    }
}
