package me.lukewalker.sandbox.entities.type;

import me.lukewalker.sandbox.entities.Entity;

public interface LivingEntity {

	void move(Entity ent);
	
	int getSpeed();
}
