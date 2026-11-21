import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Task6_CampusEventApp extends JFrame {
    JTextField id = new JTextField(8);
    JTextField name = new JTextField(10);
    JTextField email = new JTextField(12);
    JComboBox<String> event = new JComboBox<>(
        new String[]{"Tech Fest", "Cultural Day", "Sports Meet"});
    JComboBox<String> filter = new JComboBox<>(
        new String[]{"All", "Tech Fest", "Cultural Day", "Sports Meet"});
    DefaultTableModel model = new DefaultTableModel(
        new String[]{"Student ID", "Name", "Email", "Event"}, 0);
    ArrayList<String[]> data = new ArrayList<>();
    JTable table = new JTable(model);
    JLabel status = new JLabel("Ready");

    Task6_CampusEventApp() {
        setTitle("Campus Event Registration");
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
        form.add(new JLabel("Student ID"));
        form.add(id);
        form.add(new JLabel("Student Name"));
        form.add(name);
        form.add(new JLabel("Email"));
        form.add(email);
        form.add(new JLabel("Event"));
        form.add(event);

        JButton register = new JButton("Register");
        JButton clear = new JButton("Clear");
        JPanel buttons = new JPanel();
        buttons.add(register);
        buttons.add(clear);

        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.CENTER);
        top.add(buttons, BorderLayout.SOUTH);
        add(top, BorderLayout.NORTH);

        JPanel center = new JPanel(new BorderLayout());
        JPanel filterPanel = new JPanel();
        JButton apply = new JButton("Filter");
        filterPanel.add(filter);
        filterPanel.add(apply);
        center.add(filterPanel, BorderLayout.NORTH);
        center.add(new JScrollPane(table), BorderLayout.CENTER);
        add(center, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);

        register.addActionListener(e -> {
            String sid = id.getText().trim();
            String student = name.getText().trim();
            String mail = email.getText().trim();
            String ev = (String) event.getSelectedItem();

            if (sid.isEmpty() || student.isEmpty() ||
                !mail.matches(".+@.+\\\\..+")) {
                status.setText("Enter valid details");
                return;
            }

            for (String[] row : data) {
                if (row[0].equals(sid) && row[3].equals(ev)) {
                    status.setText("Already registered");
                    return;
                }
            }

            data.add(new String[]{sid, student, mail, ev});
            refresh("All");
            status.setText("Registration successful");
        });

        apply.addActionListener(e -> refresh((String) filter.getSelectedItem()));

        clear.addActionListener(e -> {
            id.setText("");
            name.setText("");
            email.setText("");
            status.setText("Form cleared");
        });

        setJMenuBar(createMenu());
        setSize(650, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    JMenuBar createMenu() {
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem export = new JMenuItem("Export CSV");
        export.addActionListener(e -> exportCSV());
        file.add(export);
        bar.add(file);
        return bar;
    }

    void refresh(String selected) {
        model.setRowCount(0);
        for (String[] row : data) {
            if (selected.equals("All") || row[3].equals(selected))
                model.addRow(row);
        }
        status.setText(model.getRowCount() + " record(s)");
    }

    void exportCSV() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (PrintWriter out = new PrintWriter(chooser.getSelectedFile())) {
                for (int c = 0; c < model.getColumnCount(); c++) {
                    if (c > 0) out.print(",");
                    out.print(model.getColumnName(c));
                }
                out.println();

                for (int r = 0; r < model.getRowCount(); r++) {
                    for (int c = 0; c < model.getColumnCount(); c++) {
                        if (c > 0) out.print(",");
                        out.print(model.getValueAt(r, c));
                    }
                    out.println();
                }
                status.setText("CSV exported");
            } catch (IOException e) {
                status.setText("Export failed");
            }
        }
    }

    public static void main(String[] args) {
        new Task6_CampusEventApp().setVisible(true);
    }
}
