package me.lukewalker.chat.server;

public class DataManager {
	
	private DataManager() {}
	private static DataManager INSTANCE = null;
	public static DataManager getInstance() {
		if (INSTANCE == null) INSTANCE = new DataManager();
		return INSTANCE;
	}
}
