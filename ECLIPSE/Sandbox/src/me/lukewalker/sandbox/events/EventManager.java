package me.lukewalker.sandbox.events;

import java.util.HashMap;

import me.lukewalker.sandbox.entities.Entity;

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
				}
			}
		}
	}
	
	public static void registerEvent(CustomEvent event) {}
}
