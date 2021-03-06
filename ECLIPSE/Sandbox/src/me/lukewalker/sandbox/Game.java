package me.lukewalker.sandbox;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import me.lukewalker.sandbox.data.DataManager;
import me.lukewalker.sandbox.entities.Entity;
import me.lukewalker.sandbox.entities.EntityPlayer;
import me.lukewalker.sandbox.entities.EntitySlime;
import me.lukewalker.sandbox.entities.items.ItemSword;
import me.lukewalker.sandbox.entities.type.ItemEntity;
import me.lukewalker.sandbox.events.EventManager;
import me.lukewalker.sandbox.events.EventType;
import me.lukewalker.sandbox.input.KeyBindings;
import me.lukewalker.sandbox.plugins.PluginLoader;
import me.lukewalker.sandbox.ui.Window;

public class Game {

	// FIX CONCURRENTMODIFICATIONEXCEPTION WHEN DESTROYING AN ENEMY
		// IE WHEN PICKING UP AN ITEM
	
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
	public static final EntitySlime entitySlime = new EntitySlime();
	
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
		
		itemSword.spawn(1000, 1000);
		
		entitySlime.spawn(1700, 280);
		
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				for (Entity ent : Entity.entities) ent.move();
			}
		}, 0, 50);
		
		//while (Window.getInstance().isFocusOwner()) {
		while (true) {
			// CHECKING FOR EVENTS
			
			// PlayerPickUpItemEvent
			for (Entity ent : Entity.entities) {
				if (ent.getType() instanceof ItemEntity) {
					Rectangle pRec = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
					Rectangle iRec = new Rectangle(ent.getX(), ent.getY(), ent.getWidth(), ent.getHeight());
					
					if (pRec.intersects(iRec)) {
						HashMap<String, Object> eArgs = new HashMap<>();
						eArgs.put("entity", player);
						eArgs.put("entity_other", ent);
						
						EventManager.getInstance().triggerEvents(EventType.ENTITY_COLLISION, eArgs);
					}
				}
			}
			
			// prevents ConcurrentModificationException when using Entity.destroy()
			for (Entity ent : Entity.destroyed) Entity.entities.remove(ent);
		}
	}
	
	public static GameState getState() { return state; }
	public static void setState(GameState state) { Game.state = state; }
}
