package me.lukewalker.sandbox.events.type;

import me.lukewalker.sandbox.entities.Entity;

public interface EntitySpawnedEvent {

	void onEvent(Entity ent);
}
