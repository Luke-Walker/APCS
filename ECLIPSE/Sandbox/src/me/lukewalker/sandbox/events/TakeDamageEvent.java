package me.lukewalker.sandbox.events;

import me.lukewalker.sandbox.entities.Entity;

public interface TakeDamageEvent {

	void onEvent(Entity ent);
}
