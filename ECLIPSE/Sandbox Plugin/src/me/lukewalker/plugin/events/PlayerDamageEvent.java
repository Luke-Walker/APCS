package me.lukewalker.plugin.events;

import me.lukewalker.sandbox.entities.Entity;
import me.lukewalker.sandbox.events.CustomEvent;
import me.lukewalker.sandbox.events.Event;
import me.lukewalker.sandbox.events.TakeDamageEvent;

public class PlayerDamageEvent extends CustomEvent implements TakeDamageEvent {

	public PlayerDamageEvent() {
		super(Event.TAKE_DAMAGE);
	}
	
	@Override
	public void onEvent(Entity ent) {		
		ent.destroy();
		System.out.println("TEST");
	}
}
