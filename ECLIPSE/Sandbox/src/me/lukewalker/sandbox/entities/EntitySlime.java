package me.lukewalker.sandbox.entities;

import me.lukewalker.sandbox.Game;
import me.lukewalker.sandbox.entities.type.EntityType;
import me.lukewalker.sandbox.entities.type.LivingEntity;

public class EntitySlime extends EntityType implements LivingEntity {

	@Override
	public void move(Entity ent) {		
		Entity player = Game.player;
		
		int x_off = player.getX() - ent.getX();
		int y_off = player.getY() - ent.getY();
		
		if (x_off > 0) ent.setX(ent.getX()+getSpeed());
		else if (x_off < 0) ent.setX(ent.getX()-getSpeed());
		
		if (y_off > 0) ent.setY(ent.getY()+getSpeed());
		else if (y_off < 0) ent.setY(ent.getY()-getSpeed());
	}

	@Override
	public int getSpeed() {
		return 10;
	}

	@Override
	public String getName() {
		return "Slime";
	}

	@Override
	public String getSprite() {
		return "slime.png";
	}

	@Override
	public int getWidth() {
		return 250;
	}

	@Override
	public int getHeight() {
		return 250;
	}
}
