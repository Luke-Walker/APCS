package me.lukewalker.sandbox.entities;

import java.util.ArrayList;

import me.lukewalker.sandbox.entities.type.EntityType;
import me.lukewalker.sandbox.entities.type.ItemEntity;
import me.lukewalker.sandbox.entities.type.LivingEntity;

public class EntityPlayer extends EntityType implements LivingEntity {
	
	public static String direction = "";
	
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
		return 25;
	}
	
	@Override
	public void move(Entity ent) {
		if (direction.equals("up")) ent.setY(ent.getY()-getSpeed());
		
		else if (direction.equals("down")) ent.setY(ent.getY()+getSpeed());
		
		else if (direction.equals("left")) ent.setX(ent.getX()-getSpeed());
		
		else if (direction.equals("right")) ent.setX(ent.getX()+getSpeed());
	}
	
	@Override
	public int getWidth() {
		return 300;
	}
	
	@Override
	public int getHeight() {
		return 500;
	}
}
