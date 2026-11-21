import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Task4_DrawingPad extends Frame {
    ArrayList<Point> points = new ArrayList<>();
    Label status = new Label("Clicks: 0");

    Task4_DrawingPad() {
        setTitle("Drawing Pad");
        add(status, BorderLayout.SOUTH);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                points.add(e.getPoint());
                status.setText("Clicks: " + points.size());
                repaint();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setSize(400, 300);
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (Point p : points)
            g.fillOval(p.x - 4, p.y - 4, 8, 8);
    }

    public static void main(String[] args) {
        new Task4_DrawingPad().setVisible(true);
    }
}
