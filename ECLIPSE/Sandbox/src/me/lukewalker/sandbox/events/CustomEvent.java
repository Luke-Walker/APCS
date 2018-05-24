package me.lukewalker.sandbox.events;

import java.util.ArrayList;

public abstract class CustomEvent {
	
	public static ArrayList<CustomEvent> events = new ArrayList<>();
	
	private Event type;
	
	public CustomEvent(Event type) {
		super();
		
		this.type = type;
		
		events.add(this);
	}
	
	public Event getType() { return type; }
}
