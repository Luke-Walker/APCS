package me.lukewalker.plugin.entities;

import me.lukewalker.sandbox.entities.Entity;
import me.lukewalker.sandbox.entities.EntityType;
import me.lukewalker.sandbox.entities.LivingEntity;

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
	public int getSpeed() {
		return 10;
	}
	
	@Override
	public void move(Entity ent, String direction, int steps) {
		
	}
}
