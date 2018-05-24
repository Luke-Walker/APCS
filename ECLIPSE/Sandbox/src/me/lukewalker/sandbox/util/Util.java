package me.lukewalker.sandbox.util;

import java.util.HashMap;

import me.lukewalker.sandbox.entities.Entity;

public class Util {

	public static HashMap<String, Object> createArgMap(Entity ent) {
		HashMap<String, Object> args = new HashMap<>();
		
		args.put("entity", ent);
		
		return args;
	}
}
