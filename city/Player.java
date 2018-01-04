package city;

import java.util.*;

public class Player {

    private ArrayList<Building> property;
    private ArrayList<Vehicle> vehicles;
    private double money, netWorth;

    private Player() {
        money = 100000;
    }
    private static Player INSTANCE = null;
    public static Player getInstance() {
        if (INSTANCE == null) INSTANCE = new Player();
        return INSTANCE;
    }

    public void addMoney(double money) {
        this.money += money;
        updateNetWorth();
    }

    public void loseMoney(double money) {
        this.money -= money;
        updateNetWorth();
    }

    public void updateNetWorth() {
        double propertyValue = 0;
        for (Building b : property) propertyValue += b.getValue();
        for (Vehicle v : vehicles) propertyValue += v.getValue();
        netWorth = money + propertyValue;
    }
}
