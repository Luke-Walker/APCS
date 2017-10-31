package me.lukewalker.rps;

import java.util.HashMap;
import java.util.Map;

public enum State {
	STARTED(0),
	WAITING_FOR_CLIENT(1),
	CLIENT_CONNECTED(2);
	
	//////////////////////////////////////////////////////////
	
	private int value;
	private static Map<Object, Object> map = new HashMap<>();
	
	private State(int value) {
		this.value = value;
	}
	
	static {
		for (State state : State.values()) {
			map.put(state.value, state);
		}
	}
	
	public static State valueOf(int state) {
		return (State) map.get(state);
	}
	
	public int getValue() {
		return value;
	}
}
