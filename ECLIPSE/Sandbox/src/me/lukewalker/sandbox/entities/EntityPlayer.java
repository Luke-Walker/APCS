package me.lukewalker.sandbox.entities;

import java.util.ArrayList;

import me.lukewalker.sandbox.items.Item;

public class EntityPlayer extends EntityType {
	
	private ArrayList<Item> inventory = new ArrayList<>();

	public void addItem(Item item) { inventory.add(item); }
	public void removeItem(Item item) { inventory.remove(item); }
	public boolean hasItem(Item item) { return inventory.contains(item); }
	
	@Override
	public void move(Entity ent, String direction, int steps) {
		if (direction.equals("up")) ent.setY(ent.getY()-steps);
		
		else if (direction.equals("down")) ent.setY(ent.getY()+steps);
		
		else if (direction.equals("left")) ent.setX(ent.getX()-steps);
		
		else if (direction.equals("right")) ent.setX(ent.getX()+steps);
	}

	@Override
	public String getName() {
		return "Player";
	}

	@Override
	public String getSprite() {
		return "player.png";
	}
	@Override
	public int getSpeed() {
		return 50;
	}
}
