package me.lukewalker.sandbox.items;

import java.util.ArrayList;

import me.lukewalker.sandbox.entities.Entity;
import me.lukewalker.sandbox.entities.EntityType;

public abstract class Item extends EntityType {

	public static ArrayList<Item> items = new ArrayList<>();
	
	public Item() {
		items.add(this);
	}

	public abstract String getItemName();
	public abstract String getItemSprite();
	
	public void spawn(Item item, int x, int y) {
		
	}
	
	@Override
	public void move(Entity ent, String direction, int steps) {}

	@Override
	public String getName() {
		return getItemName();
	}

	@Override
	public String getSprite() {
		return getItemSprite();
	}
	
	public static void registerItem(Item item) {}
}
