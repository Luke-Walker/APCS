package me.lukewalker.plugin.events;

import me.lukewalker.sandbox.entities.Entity;
import me.lukewalker.sandbox.events.CustomEvent;
import me.lukewalker.sandbox.events.Event;
import me.lukewalker.sandbox.events.type.TakeDamageEvent;

public class PlayerDamageEvent extends CustomEvent implements TakeDamageEvent {
	
	@Override
	public void onEvent(Entity ent) {		
		ent.destroy();
		System.out.println("TEST");
	}

	@Override
	public Event getType() {
		return Event.TAKE_DAMAGE;
	}
}
