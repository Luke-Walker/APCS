package me.lukewalker.sandbox.entities;

import java.net.URL;
import java.util.ArrayList;

import me.lukewalker.sandbox.entities.type.EntityType;
import me.lukewalker.sandbox.entities.type.LivingEntity;

public class Entity {
	
	public static ArrayList<Entity> entities = new ArrayList<>();
	public static ArrayList<Entity> destroyed = new ArrayList<>();
	
	public static ArrayList<Entity> getEntities(EntityType type) {
		ArrayList<Entity> entities = new ArrayList<Entity>();
		
		for (Entity e : Entity.entities) {
			if (e.getType() == type) entities.add(e);
		}
		
		return entities;
	}
	
	private EntityType type;
	private int x, y, width, height, speed;
	private URL sprite;
	
	public Entity(EntityType type, int x, int y, int width, int height, URL sprite) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
		
		if (type instanceof LivingEntity) {
			this.speed = ((LivingEntity)type).getSpeed();
		}
		
		entities.add(this);
	}
	
	public void move() {
		if (type instanceof LivingEntity) ((LivingEntity)type).move(this);
	}
	
	public void destroy() {
		destroyed.add(this);
	}
	
	public EntityType getType() { return type; }
	public int getX() { return x; }
	public int getY() { return y; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getSpeed() { return speed; }
	public URL getSprite() { return sprite; }
	
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	public void setSpeed(int speed) { this.speed = speed; }
}
