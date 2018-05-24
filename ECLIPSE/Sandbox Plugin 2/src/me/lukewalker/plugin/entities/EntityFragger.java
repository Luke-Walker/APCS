package me.lukewalker.plugin.entities;

import me.lukewalker.sandbox.entities.Entity;
import me.lukewalker.sandbox.entities.EntityType;

public class EntityFragger extends EntityType {

	public EntityFragger() {
		super();
	}
	
	@Override
	public String getName() {
		return "Fragger";
	}

	@Override
	public String getSprite() {
		return "fragger.png";
	}

	@Override
	public void move(Entity ent, String direction, int steps) {
		
	}
}
