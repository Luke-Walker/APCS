package me.lukewalker.sandbox.entities;

import java.net.URL;

import me.lukewalker.sandbox.Game;

public abstract class Entity {
	
	private String name;
	private int x, y;
	private URL sprite;
	
	public Entity(String name, int x, int y, String sprite) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.sprite = getClass().getResource("/resources/images/entities/" + sprite);
		
		Game.getInstance().entities.add(this);
	}
	
	public void destroy() {
		Game.getInstance().entities.remove(this);
	}
	
	public String getName() { return name; }
	public int getX() { return x; }
	public int getY() { return y; }
	public URL getSprite() { return sprite; }
	
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	
	public abstract void move(String direction, int steps);
}
