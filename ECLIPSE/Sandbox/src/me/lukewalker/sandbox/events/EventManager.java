package me.lukewalker.sandbox.events;

import java.util.HashMap;

import me.lukewalker.sandbox.entities.Entity;
import me.lukewalker.sandbox.events.type.EntityCollisionEvent;
import me.lukewalker.sandbox.events.type.EntitySpawnedEvent;
import me.lukewalker.sandbox.events.type.TakeDamageEvent;

public class EventManager {
	
	public static void triggerEvents(Event event, HashMap<String, Object> args) {
		for (CustomEvent e : CustomEvent.events) {
			if (event == e.getType()) {
				if (event == Event.TAKE_DAMAGE) {
					TakeDamageEvent ev = (TakeDamageEvent) e;
					ev.onEvent((Entity)args.get("entity"));
				} else if (event == Event.ENTITY_SPAWNED) {
					EntitySpawnedEvent ev = (EntitySpawnedEvent) e;
					ev.onEvent((Entity)args.get("entity"));
				} else if (event == Event.ENTITY_COLLISION) {
					EntityCollisionEvent ev = (EntityCollisionEvent) e;
					ev.onEvent((Entity)args.get("entity"), (Entity)args.get("entity_other"));
				}
			}
		}
	}
	
	public static void registerEvent(CustomEvent event) {}
}
