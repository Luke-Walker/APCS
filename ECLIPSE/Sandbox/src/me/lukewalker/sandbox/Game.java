package me.lukewalker.sandbox;

import me.lukewalker.sandbox.data.DataManager;
import me.lukewalker.sandbox.entities.Entity;
import me.lukewalker.sandbox.entities.EntityPlayer;
import me.lukewalker.sandbox.entities.items.ItemSword;
import me.lukewalker.sandbox.events.EventManager;
import me.lukewalker.sandbox.input.KeyBindings;
import me.lukewalker.sandbox.plugins.PluginLoader;
import me.lukewalker.sandbox.ui.Window;

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
	
	public static final EntityPlayer entityPlayer = new EntityPlayer();
	
	public static final ItemSword itemSword = new ItemSword();
	
	public static Entity player = null;
	
	public static void main(String[] args) {
		state = GameState.LOADING;
		
		KeyBindings.initBindings();
		
		DataManager.getInstance().createFiles();
		try {
			DataManager.getInstance().loadSettings();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
			
		final PluginLoader pl = PluginLoader.getInstance();
		pl.initPlugins();
		
		final EventManager em = EventManager.getInstance();
		em.initEvents();
		
		Window.getInstance().display();
		
		player = entityPlayer.spawn(250, 250);
		
		//state = GameState.TITLE_SCREEN;
		state = GameState.IN_GAME;
		
		itemSword.spawn(500, 500);
		
		//while (true) {
		//}
	}
	
	public static GameState getState() { return state; }
	public static void setState(GameState state) { Game.state = state; }
}
