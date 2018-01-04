package city;

import java.util.*;

public class ShopBuilding extends Building {

    private String name;
    private HashMap<String, Integer> items;

    public ShopBuilding(String name, HashMap<String, Integer> items) {
        super();

        this.name = name;
        this.items = items;
    }
}
