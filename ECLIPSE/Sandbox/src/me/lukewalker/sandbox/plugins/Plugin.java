package me.lukewalker.sandbox.plugins;

import java.util.ArrayList;

public abstract class Plugin {

	public static ArrayList<Class> classes = new ArrayList<Class>();
	
	public void registerClass(Class c) {
		classes.add(c);
	}
	
	public abstract String getName();
	public abstract String getVersion();
}
