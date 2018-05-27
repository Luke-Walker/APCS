package me.lukewalker.sandbox.util;

import java.util.HashMap;

import me.lukewalker.sandbox.entities.Entity;

public class Util {

	public static HashMap<String, Object> createArgMap(Entity ent, Entity other) {
		HashMap<String, Object> args = new HashMap<>();
		
		args.put("entity", ent);
		args.put("entity_other", other);
		
		return args;
	}
}
