package me.lukewalker.sandbox;

import me.lukewalker.sandbox.data.DataManager;
import me.lukewalker.sandbox.entities.Entity;
import me.lukewalker.sandbox.entities.EntityPlayer;
import me.lukewalker.sandbox.events.EventManager;
import me.lukewalker.sandbox.events.PlayerPickUpItemEvent;
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
	
	public static Entity player = null;
	
	public static void main(String[] args) {
		DataManager.getInstance().createFiles();
		try {
			DataManager.getInstance().loadSettings();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		Window.getInstance().display();
			
		final EntityPlayer entityPlayer = new EntityPlayer();
		
		player = entityPlayer.spawn(250, 250);
		
		PluginLoader pl = PluginLoader.getInstance();
		pl.initPlugins();
		
		initEvents();
		
		//final Scanner scan = new Scanner(System.in);
		while (true) {
			/*if (scan.nextLine().equals("test")) {
				EventManager.triggerEvents(Event.TAKE_DAMAGE, Util.createArgMap(Entity.getEntities(player).get(0)));
			}*/
		}
	}
	
	private static void initEvents() {
		EventManager.registerEvent(new PlayerPickUpItemEvent());
	}
}
