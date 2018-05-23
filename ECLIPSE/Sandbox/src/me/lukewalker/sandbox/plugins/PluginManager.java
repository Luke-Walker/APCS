package me.lukewalker.sandbox.plugins;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginManager {

	private PluginManager() {}
	private static PluginManager INSTANCE = null;
	public static PluginManager getInstance() {
		if (INSTANCE == null) INSTANCE = new PluginManager();
		return INSTANCE;
	}
	
	public void loadPlugins() {
		URLClassLoader classLoader;
		try {
			classLoader = URLClassLoader.newInstance(new URL[] {new URL("")});
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		}
		
		
	}
}
