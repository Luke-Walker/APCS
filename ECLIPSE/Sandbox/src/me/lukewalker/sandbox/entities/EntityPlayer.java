package me.lukewalker.sandbox.entities;

public class EntityPlayer extends Entity {
	
	public EntityPlayer(String name, int x, int y) {
		super(name, x, y, "player.png");
	}

	@Override
	public void move(String direction, int steps) {
		if (direction.equals("up")) setY(getY()-steps);
		
		else if (direction.equals("down")) setY(getY()+steps);
		
		else if (direction.equals("left")) setX(getX()-steps);
		
		else if (direction.equals("right")) setX(getX()+steps);
	}
}
