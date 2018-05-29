package me.lukewalker.sandbox.items;

import java.util.ArrayList;

public abstract class Item {

	public static ArrayList<Item> items = new ArrayList<>();
	
	public Item() {
		items.add(this);
	}

	public abstract String getName();
	public abstract String getSprite();
	
	public void spawn(Item item, int x, int y) {
		
	}
	
	public static void registerItem(Item item) {}
}
