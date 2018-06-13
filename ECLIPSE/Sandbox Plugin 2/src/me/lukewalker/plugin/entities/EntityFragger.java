package me.lukewalker.plugin.entities;

import me.lukewalker.sandbox.Game;
import me.lukewalker.sandbox.entities.Entity;
import me.lukewalker.sandbox.entities.type.EntityType;
import me.lukewalker.sandbox.entities.type.LivingEntity;

public class EntityFragger extends EntityType implements LivingEntity {

	@Override
	public String getName() {
		return "Fragger";
	}

	@Override
	public String getSprite() {
		return "fragger.png";
	}

	@Override
	public int getWidth() {
		return 150;
	}
	
	@Override
	public int getHeight() {
		return 150;
	}
	
	@Override
	public int getSpeed() {
		return 10;
	}
	
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
}
