package me.lukewalker.sandbox.events.type;

import me.lukewalker.sandbox.entities.Entity;

public interface EntityCollisionEvent {

	void onEvent(Entity ent, Entity other);
}
