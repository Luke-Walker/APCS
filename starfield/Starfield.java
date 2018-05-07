import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Starfield extends JPanel {

    private static final String TITLE = "Starfield";

    static final int FIELD_WIDTH = 500;
    static final int FIELD_HEIGHT = 500;
    static final int MAX_DIAMETER = 15;
    static final int MAX_SPEED = 3;
    static final int NUM_STARS = 50;
    static final int MOVING_STARS = 25;
    static final int NUM_PLANETS = 5;
    static final int NUM_ASTEROIDS = 10;

    public static ArrayList<SpaceObject> spaceObjects = new ArrayList<SpaceObject>();
    public static ArrayList<Collidable> collidableObjects = new ArrayList<Collidable>();

    public static int x = 0;
    public static int y = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame(TITLE);
        frame.setSize(FIELD_WIDTH, FIELD_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        Starfield sf = new Starfield();
        frame.add(sf);

        Random rand = new Random();
        for (int i = 0; i < NUM_STARS; i++) {
            if (rand.nextInt(5) == 1) sf.spaceObjects.add(new DimmingStar());
            else sf.spaceObjects.add(new Star());
        }
        for (int i = 0; i < MOVING_STARS; i++) sf.spaceObjects.add(new MovingStar());
        for (int i = 0; i < NUM_PLANETS; i++) sf.spaceObjects.add(new Planet());
        for (int i = 0; i < NUM_ASTEROIDS; i++) sf.spaceObjects.add(new Asteroid());

        while (true) {
            for (SpaceObject obj : sf.spaceObjects) {
                if (obj instanceof MovingObject) {
                    ((MovingObject)obj).move();
                }
                if (obj instanceof Collidable) {
                    if (!sf.collidableObjects.contains(obj)) sf.collidableObjects.add((Collidable)obj);

                    for (Collidable other : sf.collidableObjects) {
                        if (obj != other) {
                            ((Collidable)obj).collide(other);
                        }
                    }
                }
                if (obj instanceof DimmingStar) {
                    ((DimmingStar)obj).dim();
                }
            }
            sf.repaint();
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        setOpaque(true);
        setBackground(Color.BLACK);

        super.paintComponent(g);

        for (SpaceObject obj : spaceObjects) {
            if (obj instanceof Asteroid) g.setColor(Color.GREEN);
            else g.setColor(obj.getColor());
            g.fillOval(obj.getX(), obj.getY(), obj.getDiameter(), obj.getDiameter());
        }

        g.setColor(Color.BLUE);
        g.fillOval(x, y, 10, 10);
    }
}

abstract class SpaceObject {

    private int x;
    private int y;
    private int diameter;
    private Color color;

    public SpaceObject() {
        x = (int)(Math.random()*Starfield.FIELD_WIDTH);
        y = (int)(Math.random()*Starfield.FIELD_HEIGHT);
        diameter = (int)(Math.random()*Starfield.MAX_DIAMETER);
        int brightness = (int)(Math.random()*255);
        if (brightness < 50) brightness = 50;
        color = new Color(brightness, brightness, brightness);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getDiameter() { return diameter; }
    public Color getColor() { return color; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setDiameter(int d) { diameter = d;}
    public void setColor(Color c) { color = c; }
}

abstract class MovingObject extends SpaceObject {

    private int dx;

    public MovingObject() {
        super();
        dx = (int)(Math.random()*Starfield.MAX_SPEED);
    }

    public void move() {
        setX( getX() - dx );
        if (getX() < 0) {
            setX( Starfield.FIELD_WIDTH + 100 );
            setY( (int)(Math.random()*Starfield.FIELD_HEIGHT) );
        }
    }

    public int getSpeed() { return dx; }
    public void setSpeed(int dx) { this.dx = dx; }
}

interface Collidable {

    public void collide(Collidable other);
}

class Star extends SpaceObject {

    public Star() {
        super();
    }
}

class MovingStar extends MovingObject {

    public MovingStar() {
        super();
    }
}

class DimmingStar extends Star {

    private static final int MINIMUM_COLOR = 50;
    private static final int MAXIMUM_COLOR = 225;

    private double dimmingFactor;

    public DimmingStar() {
        super();
        dimmingFactor = .9;
    }

    public void dim() {
        double red = getColor().getRed()*dimmingFactor;
        double green = getColor().getGreen()*dimmingFactor;
        double blue = getColor().getBlue()*dimmingFactor;

        setColor(new Color((int)red, (int)green, (int)blue));

        if (red <= MINIMUM_COLOR || green <= MINIMUM_COLOR || blue <= MINIMUM_COLOR) dimmingFactor = 1.1;
        else if (red >= MAXIMUM_COLOR || green >= MAXIMUM_COLOR || blue >= MAXIMUM_COLOR) dimmingFactor = .9;
    }
}

class Planet extends SpaceObject implements Collidable {

    public Planet() {
        super();
        setColor(Color.RED);
    }

    @Override
    public void collide(Collidable other) { }
}

class Asteroid extends MovingObject implements Collidable {

    public Asteroid() {
        super();
    }

    @Override
    public void collide(Collidable other) {
        SpaceObject obj;
        if (other instanceof SpaceObject) {
            obj = (SpaceObject) other;
            if (Math.sqrt( ((getX()-obj.getX())^2) + ((getY()-obj.getY())^2) ) < obj.getDiameter()/2) {
                Starfield field = new Starfield();
                field.x = getX();
                field.y = getY();
                setSpeed(0);
                setX(-1000);
                System.out.println("COLLISION");
            }
        }
    }
}
