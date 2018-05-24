package me.lukewalker.sandbox.entities;

import java.net.URL;
import java.util.ArrayList;

public abstract class EntityType {
	
	public static ArrayList<EntityType> entityTypes = new ArrayList<>();
	
	private URL sprite;
	
	public EntityType() {
		super();
		
		sprite = getClass().getResource("/resources/images/entities/" + getSprite());
		
		entityTypes.add(this);
	}
	
	public Entity spawn(int x, int y) {
		return new Entity(this, x, y, sprite);
	}
	
	public URL getFullSprite() {
		return sprite;
	}
	
	public abstract String getName();
	public abstract String getSprite();
	public abstract void move(Entity ent, String direction, int steps);
}
