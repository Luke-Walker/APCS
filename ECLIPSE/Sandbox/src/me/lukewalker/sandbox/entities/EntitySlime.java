package me.lukewalker.sandbox.entities;

import me.lukewalker.sandbox.entities.type.EntityType;
import me.lukewalker.sandbox.entities.type.LivingEntity;

public class EntitySlime extends EntityType implements LivingEntity {

	@Override
	public void move(Entity ent) {		
		
	}

	@Override
	public int getSpeed() {
		return 5;
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
