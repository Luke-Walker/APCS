package me.lukewalker.sandbox;

import java.util.ArrayList;

import me.lukewalker.sandbox.entities.Entity;
import me.lukewalker.sandbox.entities.EntityPlayer;

public class Game {

	private Game() {}
	private static Game INSTANCE = null;
	public static Game getInstance() {
		if (INSTANCE == null) INSTANCE = new Game();
		return INSTANCE;
	}
	
	public static final String TITLE = "Sandbox";
	public static final String VERSION = "v1.0";
	
	public static EntityPlayer player = null;
	
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public static void main(String[] args) {
		player = new EntityPlayer(args[0], 250, 250);
		
		
	
		Window.getInstance().display();
		
		while (true) {
		}
	}
}
