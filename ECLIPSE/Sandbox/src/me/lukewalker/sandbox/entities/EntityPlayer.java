package me.lukewalker.sandbox.entities;

import java.util.ArrayList;

import me.lukewalker.sandbox.entities.type.EntityType;
import me.lukewalker.sandbox.entities.type.ItemEntity;
import me.lukewalker.sandbox.entities.type.LivingEntity;

public class EntityPlayer extends EntityType implements LivingEntity {
	
	private ArrayList<ItemEntity> inventory = new ArrayList<>();

	public void addItem(ItemEntity item) { inventory.add(item); }
	public void removeItem(ItemEntity item) { inventory.remove(item); }
	public boolean hasItem(ItemEntity item) { return inventory.contains(item); }

	public EntityPlayer() {
		super();
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
	
	@Override
	public void move(Entity ent, String direction, int steps) {
		if (direction.equals("up")) ent.setY(ent.getY()-steps);
		
		else if (direction.equals("down")) ent.setY(ent.getY()+steps);
		
		else if (direction.equals("left")) ent.setX(ent.getX()-steps);
		
		else if (direction.equals("right")) ent.setX(ent.getX()+steps);
	}
}
