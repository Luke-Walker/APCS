import java.awt.*;
import java.util.*;
import javax.swing.*;

public class BasicAnimation extends JPanel {

    private static final String TITLE = "Animation Example";

    static Circle circle = new Circle();

    public static void main(String[] args) {
        JFrame frame = new JFrame(TITLE);
        frame.setSize(500, 525);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        BasicAnimation ba = new BasicAnimation();
        frame.add(ba);

        frame.setVisible(true);

        while (true) {
            circle.move();
            ba.repaint();

            try {
                Thread.sleep(100);
            } catch (Exception e) { e.printStackTrace(); }
        }
    }

    public void paint(Graphics g) {
        setBackground(Color.LIGHT_GRAY);
        super.paintComponent(g);

        g.setColor(circle.getColor());
        g.fillOval(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight());
    }
}

class Circle {

    private int x, y, dx, dy, width, height;
    private Color color;

    public Circle() {
        this.x = 100;
        this.y = 100;
        this.dx = 1;
        this.dy = 0;
        this.width = 100;
        this.height = 100;
        this.color = Color.RED;
    }

    public Circle(int x, int y, int dx, int dy, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }
}
