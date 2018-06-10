package me.lukewalker.sandbox.plugins;

public class PluginManager {

	private PluginManager() {}
	private static PluginManager INSTANCE = null;
	public static PluginManager getInstance() {
		if (INSTANCE == null) INSTANCE = new PluginManager();
		return INSTANCE;
	}
	
	public void enablePlugin(Plugin plugin) {
		PluginLoader pl = PluginLoader.getInstance();
		
		if (pl.enabled.contains(plugin)) return;
		
		pl.disabled.remove(plugin);
		pl.enabled.add(plugin);
	}
	
	public void disablePlugin(Plugin plugin) {
		PluginLoader pl = PluginLoader.getInstance();
		
		if (pl.disabled.contains(plugin)) return;
		
		pl.enabled.remove(plugin);
		pl.disabled.add(plugin);
	}
	
	public Plugin getPluginByName(String name) {
		for (Plugin plugin : PluginLoader.getInstance().plugins) {
			if (plugin.getName().equals(name)) return plugin;
		}
		return null;
	}
}
