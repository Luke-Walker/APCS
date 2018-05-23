package city;

import java.util.*;

public class ShopBuilding extends Building {

    private String name;
    private double money;
    private ArrayList<ShopItem> items;

    public ShopBuilding(String name, ArrayList<ShopItem> items) {
        super();

        this.name = name;
        this.money = 0;
        this.items = items;
    }

    public void restock(ShopItem item) {
        money -= item.getPrice();
        items.add(item);
    }

    public void sell(ShopItem item) {
        if (!items.contains(item)) return;

        items.remove(item);
        money += item.getPrice();
    }

    @Override
    public String toString() {
        return super.toString() + " : " + items + " : worth $" + money;
    }
}
