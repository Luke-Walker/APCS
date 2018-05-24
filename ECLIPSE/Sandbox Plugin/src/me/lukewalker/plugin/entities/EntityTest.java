package me.lukewalker.plugin.entities;

import me.lukewalker.sandbox.entities.Entity;
import me.lukewalker.sandbox.entities.EntityType;

public class EntityTest extends EntityType {

	public EntityTest() {
		super();
	}
	
	@Override
	public String getName() {
		return "Test";
	}

	@Override
	public String getSprite() {
		return "test.png";
	}

	@Override
	public void move(Entity ent, String direction, int steps) {
		
	}
}
