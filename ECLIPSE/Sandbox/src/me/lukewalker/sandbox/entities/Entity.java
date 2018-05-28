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
	private int x, y, speed;
	private URL sprite;
	
	public Entity(EntityType type, int x, int y, URL sprite) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.speed = type.getSpeed();
		this.sprite = sprite;
		
		entities.add(this);
	}
	
	public void move(String direction) {
		type.move(this, direction, getSpeed());
	}
	
	public void destroy() {
		entities.remove(this);
	}
	
	public EntityType getType() { return type; }
	public int getX() { return x; }
	public int getY() { return y; }
	public int getSpeed() { return speed; }
	public URL getSprite() { return sprite; }
	
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	public void setSpeed(int speed) { this.speed = speed; }
}
