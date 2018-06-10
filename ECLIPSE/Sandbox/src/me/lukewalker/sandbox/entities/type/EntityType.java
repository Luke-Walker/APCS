package me.lukewalker.sandbox.entities.type;

import java.net.URL;
import java.util.ArrayList;

import me.lukewalker.sandbox.entities.Entity;

public abstract class EntityType {
	
	public static ArrayList<EntityType> entityTypes = new ArrayList<>();
	public static ArrayList<ItemEntity> itemTypes = new ArrayList<>();
	
	private URL sprite;
	
	public EntityType() {
		if (this instanceof ItemEntity) {
			this.sprite = getClass().getResource("/images/items/" + getSprite());
			itemTypes.add((ItemEntity)this);
		} else {
			this.sprite = getClass().getResource("/images/entities/" + getSprite());
			entityTypes.add(this);
		}
	}
	
	public Entity spawn(int x, int y) {
		return new Entity(this, x, y, getWidth(), getHeight(), sprite);
	}
	
	public URL getFullSprite() {
		return sprite;
	}
	
	public abstract String getName();
	public abstract String getSprite();
	public abstract int getWidth();
	public abstract int getHeight();
}
