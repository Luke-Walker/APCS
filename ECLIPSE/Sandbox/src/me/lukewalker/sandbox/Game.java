package me.lukewalker.sandbox;

import me.lukewalker.sandbox.data.DataManager;
import me.lukewalker.sandbox.entities.Entity;
import me.lukewalker.sandbox.entities.EntityPlayer;
import me.lukewalker.sandbox.events.EventManager;
import me.lukewalker.sandbox.plugins.PluginLoader;

public class Game {

	private Game() {}
	private static Game INSTANCE = null;
	public static Game getInstance() {
		if (INSTANCE == null) INSTANCE = new Game();
		return INSTANCE;
	}
	
	public static final String TITLE = "Sandbox";
	public static final String VERSION = "v1.0";
	
	private static GameState state = null;
	
	public static Entity player = null;
	
	public static void main(String[] args) {
		state = GameState.LOADING;
		
		DataManager.getInstance().createFiles();
		try {
			DataManager.getInstance().loadSettings();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		Window.getInstance().display();
			
		final EntityPlayer entityPlayer = new EntityPlayer();
		
		player = entityPlayer.spawn(250, 250);
		
		final PluginLoader pl = PluginLoader.getInstance();
		pl.initPlugins();
		
		final EventManager em = EventManager.getInstance();
		em.initEvents();
		
		state = GameState.TITLE_SCREEN;
		/*
		while (true) {
			
		}
		*/
	}
	
	public static GameState getState() { return state; }
	public static void setState(GameState state) { Game.state = state; }
}
