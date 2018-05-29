package me.lukewalker.sandbox.events.type;

import me.lukewalker.sandbox.entities.Entity;

public interface TakeDamageEvent {

	void onEvent(Entity ent);
}
