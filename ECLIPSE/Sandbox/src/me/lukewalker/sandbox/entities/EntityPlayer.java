package me.lukewalker.sandbox.entities;

public class EntityPlayer extends EntityType {
	
	public EntityPlayer() {
		super();
	}

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
}
