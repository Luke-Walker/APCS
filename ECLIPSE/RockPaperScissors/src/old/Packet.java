package old;

import java.util.HashMap;
import java.util.Map;

public enum Packet {
	
	STATE_CHANGE(0);
	
	///////////////////////////////////////////////////////////
	
	private int value;
	private static Map<Object, Object> map = new HashMap<>();
	
	private Packet(int value) {
		this.value = value;
	}
	
	static {
		for (Packet packet : Packet.values()) {
			map.put(packet.value, packet);
		}
	}
	
	public static Packet valueOf(int packet) {
		return (Packet) map.get(packet);
	}
	
	public int getValue() {
		return value;
	}
}
