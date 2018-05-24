package me.lukewalker.sandbox.entities;

import java.net.URL;
import java.util.ArrayList;

public class Entity {
	
	public static ArrayList<Entity> entities = new ArrayList<>();
	
	public static ArrayList<Entity> getEntities(EntityType type) {
		ArrayList<Entity> entities = new ArrayList<Entity>();
		
		for (Entity e : Entity.entities) {
			if (e.getType() == type) entities.add(e);
		}
		
		return entities;
	}
	
	private EntityType type;
	private int x, y;
	private URL sprite;
	
	public Entity(EntityType type, int x, int y, URL sprite) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		
		entities.add(this);
	}
	
	public void move(String direction, int steps) {
		type.move(this, direction, steps);
	}
	
	public void destroy() {
		entities.remove(this);
	}
	
	public EntityType getType() { return type; }
	public int getX() { return x; }
	public int getY() { return y; }
	public URL getSprite() { return sprite; }
	
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
}
