import javax.swing.*;
import java.awt.*;

public class Task2_AppointmentDesk extends JFrame {
    JTextField patient = new JTextField(10);
    JComboBox<String> department = new JComboBox<>(
        new String[]{"Cardiology", "Neurology", "Orthopedics"});
    JComboBox<String> doctor = new JComboBox<>();
    JComboBox<String> time = new JComboBox<>(
        new String[]{"09:00 AM", "10:00 AM", "11:00 AM"});
    JLabel status = new JLabel("Enter appointment details");

    Task2_AppointmentDesk() {
        setTitle("Hospital Appointment Desk");
        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("Patient ID"));
        add(patient);
        add(new JLabel("Department"));
        add(department);
        add(new JLabel("Doctor"));
        add(doctor);
        add(new JLabel("Time Slot"));
        add(time);

        JButton book = new JButton("Book Appointment");
        add(book);
        add(status);

        department.addActionListener(e -> {
            doctor.removeAllItems();
            String d = (String) department.getSelectedItem();

            if (d.equals("Cardiology")) {
                doctor.addItem("Dr. Arun");
                doctor.addItem("Dr. Meena");
            } else if (d.equals("Neurology")) {
                doctor.addItem("Dr. Kumar");
                doctor.addItem("Dr. Sara");
            } else {
                doctor.addItem("Dr. Ravi");
                doctor.addItem("Dr. Nila");
            }
        });

        department.setSelectedIndex(0);

        book.addActionListener(e -> {
            if (patient.getText().trim().isEmpty())
                status.setText("Enter Patient ID");
            else
                status.setText("Appointment booked successfully");
        });

        setSize(430, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Task2_AppointmentDesk().setVisible(true);
    }
}
