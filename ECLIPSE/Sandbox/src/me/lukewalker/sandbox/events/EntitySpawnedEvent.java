package me.lukewalker.sandbox.events;

import me.lukewalker.sandbox.entities.Entity;

public interface EntitySpawnedEvent {

	void onEvent(Entity ent);
}
