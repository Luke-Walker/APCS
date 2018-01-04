package city;

import java.util.*;

public class Building {

    private static String[] addresses = {
        "Knott St",
        "Fuller St",
        "Alberta St",
        "Fremont St",
        "Siskiyou St",
        "Stanton St",
        "Brazee St",
        "Broadway St"
    };
    private static int addressPlace = 0;
    private static int number = 1;
    public static ArrayList<Building> buildings = new ArrayList<Building>();

    private String address;
    private int width, length, height;
    private double value;

    public Building() {
        Random rand = new Random();
        init(rand.nextInt(275)+25, rand.nextInt(500)+100, rand.nextInt(275)+25);
    }

    public Building(int width, int height, int length) {
        init(width, height, length);
    }

    public void init(int width, int height, int length) {
        this.address = number + " " + addresses[addressPlace]; number++;
        this.width = width;
        this.height = height;
        this.length = length;
        this.value = width*height*length;

        if (number%10 == 0) addressPlace++;

        buildings.add(this);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return address + " : " + width + "x" + height + "x" + length;
    }
}
