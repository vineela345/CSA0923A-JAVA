import javax.swing.*;
import java.awt.*;

public class Task3_LibrarySearch extends JFrame {
    JTextField search = new JTextField(15);
    JComboBox<String> category = new JComboBox<>(
        new String[]{"All", "Books", "Journals", "Theses"});
    DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> results = new JList<>(model);
    JLabel status = new JLabel("Ready");

    Task3_LibrarySearch() {
        setTitle("Campus Library Search");
        setLayout(new BorderLayout(5, 5));

        JPanel top = new JPanel();
        top.add(new JLabel("Search:"));
        top.add(search);
        top.add(category);

        JButton button = new JButton("Search");
        top.add(button);
        add(top, BorderLayout.NORTH);

        model.addElement("Java Programming");
        model.addElement("Data Structures");
        model.addElement("Computer Networks");
        add(new JScrollPane(results), BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        JButton previous = new JButton("Previous");
        JButton next = new JButton("Next");
        JButton reserve = new JButton("Reserve");
        bottom.add(previous);
        bottom.add(next);
        bottom.add(reserve);
        add(bottom, BorderLayout.SOUTH);
        add(status, BorderLayout.PAGE_END);

        button.addActionListener(e -> {
            String word = search.getText().toLowerCase();
            model.clear();

            String[] books = {"Java Programming", "Data Structures",
                              "Computer Networks"};
            for (String book : books) {
                if (book.toLowerCase().contains(word))
                    model.addElement(book);
            }
            status.setText(model.size() + " result(s) found");
        });

        reserve.addActionListener(e ->
            status.setText("Select a book to reserve"));

        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Task3_LibrarySearch().setVisible(true);
    }
}
