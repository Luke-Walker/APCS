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
    static final int NUM_ASTEROIDS = 10;

    ArrayList<SpaceObject> spaceObjects = new ArrayList<SpaceObject>();

    public static void main(String[] args) {
        // #1 Create the JFrame
        // * Create the Starfield object
        // * Add the Starfield object to the JFrame
        JFrame frame = new JFrame(TITLE);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Starfield sf = new Starfield();
        frame.add(sf);

        // #4 Add NUM_STARS Stars to spaceObjects ArrayList (after creating Star class)
        // * Add MOVING_STARS MovingStars to spaceObjects ArrayList (after creating MovingStar class)

        for (int i = 0; i < NUM_STARS; i++) sf.spaceObjects.add(new Star());
        for (int i = 0; i < MOVING_STARS; i++) sf.spaceObjects.add(new MovingStar());

        // #5 while loop for the animation loop
        /*
        while(true) {
        for (SpaceObject spaceObj : spaceObjects) {
        if (spaceObj instanceof MovingStar) {
        // * call the move() method for spaceObj */

        while (true) {
            for (SpaceObject obj : sf.spaceObjects) {
                if (obj instanceof Star) {

                }
                if (obj instanceof MovingStar) {

                }
            }
        }
    }

    public void paint(Graphics g) {

        // #6

        // * update the background to clear the previous frame

        // * create a for loop to go through all of spaceObjects and draw each object

        super.paintComponent(g);
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

}

interface Collidable {

    public void collide(Collidable other);
}

/*
#2 Create a Star class that extends SpaceObject
*/

class Star extends SpaceObject {

    public Star() {
        super();
    }
}

/*
#3 Create a MovingStar class that extendsd MovingObject
*/

class MovingStar extends MovingObject {

    public MovingStar() {
        super();
    }
}

/*
#7 Create a new DimmingStar class that extends Star.

DimmingStar should dim to a certain level of brightness and then brighten
to a certain level of brightness and repeat.

DimmingStar will have a instance variable called dimmingFactor

One approach is to have your dimmingFactor begin at a value like 0.99999

•	In the move() method, get the red, green, and blue values from
the star’s color (int red = color.getRed() …).
•	Then, multiply the red, green, blue by the dimmingFactor.
•	If the brightness gets low enough for red, green, blue, then have
the dimmingFactor change to be greater than 1.0

Add DimmingStars into your Starfield
*/
