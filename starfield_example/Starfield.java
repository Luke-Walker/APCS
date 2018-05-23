import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Starfield extends JPanel {

    ArrayList<SpaceObject> spaceObjects = new ArrayList<SpaceObject>();

    static final int NUM_STARS = 30;
    static final int FIELD_WIDTH = 500;
    static final int FIELD_HEIGHT = 500;
    static final int MAX_DIAMETER = 15;
    static final double MAX_SPEED = 1;
    static final int MOVING_STARS = 15;
    static final int NUM_ASTEROIDS = 15;

    public static void main(String[] args) {

        JFrame window = new JFrame("Starfield");
        window.setSize(FIELD_WIDTH, FIELD_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        Starfield field = new Starfield();
        ArrayList<Collidable> colliderList = new ArrayList<Collidable>();

        for (int i = 0; i < NUM_STARS-MOVING_STARS; i++)
        field.spaceObjects.add(new Star());

        for (int i = 0; i < MOVING_STARS; i++)
        field.spaceObjects.add(new MovingStar());

        for (int i = 0; i < NUM_ASTEROIDS; i++) {
            Asteroid a = new Asteroid();
            field.spaceObjects.add(a);
            colliderList.add(a);
        }

        window.add(field);
        window.setVisible(true);

        while (true) {
            for (SpaceObject star : field.spaceObjects) {

                if (star instanceof MovingObject)
                ((MovingObject)star).move();

                if (star instanceof Collidable) {
                    for (Collidable collider : colliderList) {
                        ((Collidable)star).collide(collider);
                    }
                }

            }

            try {
                Thread.sleep(10);
            } catch(Exception e) {}

                field.repaint();
            }

        }

        public void paint(Graphics g) {

            setOpaque(true);
            setBackground(Color.BLACK);
            super.paintComponent(g);

            for (SpaceObject star : spaceObjects) {
                g.setColor(star.color);
                g.fillOval((int)star.x, (int)star.y, star.diameter, star.diameter);
            }
        }

    }


    abstract class SpaceObject {

        double x;
        double y;
        int diameter;
        Color color;

        public SpaceObject() {
            x = (int)(Math.random()*Starfield.FIELD_WIDTH);
            y = (int)(Math.random()*Starfield.FIELD_HEIGHT);
            diameter = (int)(Math.random()*Starfield.MAX_DIAMETER);
            int brightness = (int)(Math.random()*255);
            color = new Color(brightness, brightness, brightness);
        }

    }

    abstract class MovingObject extends SpaceObject {

        double speed;

        public MovingObject() {
            super();
            speed = Math.random()*Starfield.MAX_SPEED;
        }

        public void move() {
            x -= speed;
            if (x < 0) {
                x = Starfield.FIELD_WIDTH + 100;
                y = (int)(Math.random()*Starfield.FIELD_HEIGHT);
            }
        }
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

    class Asteroid extends MovingObject implements Collidable {

        double ySpeed;

        public Asteroid() {
            super();
            int red = (int)(Math.random()*255);
            int green = (int)(Math.random()*255);
            int blue = (int)(Math.random()*255);
            color = new Color(red, green, blue);
            ySpeed = 0;
        }

        public void collide(Collidable other) {

            if ( this != other &&
            Math.abs(this.x-other.getX()) < Math.max(this.diameter, other.getWidth()) &&
            Math.abs(this.y-other.getY()) < Math.max(this.diameter, other.getHeight()) ) {

                if (Math.random() < 0.5)
                this.speed *= -1;
                ySpeed = this.speed;
                if (Math.random() < 0.5)
                ySpeed *= -1;
            }
        }

        public void move() {
            x -= speed;
            y += ySpeed;
            if (x < 0 || x > Starfield.FIELD_WIDTH + 100 || y < 0 || y > Starfield.FIELD_HEIGHT) {
                x = Starfield.FIELD_WIDTH + 100;
                y = (int)(Math.random()*Starfield.FIELD_HEIGHT);
                ySpeed = 0;
                speed = Math.abs(speed);
            }
        }

        public double getX() { return x; }
        public double getY() { return y; }
        public int getHeight() { return diameter; }
        public int getWidth() { return diameter; }

    }

    class Planet extends SpaceObject implements Collidable {

        public void collide(Collidable other) {

        }

        public double getX() { return x; }
        public double getY() { return y; }
        public int getHeight() { return diameter; }
        public int getWidth() { return diameter; }

    }

    interface Collidable {

        public void collide(Collidable other);
        public double getX();
        public double getY();
        public int getHeight();
        public int getWidth();

    }
