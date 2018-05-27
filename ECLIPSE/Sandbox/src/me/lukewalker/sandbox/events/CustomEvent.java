package me.lukewalker.sandbox.events;

import java.util.ArrayList;

public abstract class CustomEvent {
	
	public static ArrayList<CustomEvent> events = new ArrayList<>();
	
	public CustomEvent() {
		events.add(this);
	}
	
	public abstract Event getType();
}
