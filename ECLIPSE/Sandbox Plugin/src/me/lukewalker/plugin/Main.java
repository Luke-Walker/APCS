package me.lukewalker.plugin;

import me.lukewalker.plugin.entities.EntityTest;
import me.lukewalker.plugin.events.PlayerDamageEvent;
import me.lukewalker.sandbox.events.EventManager;
import me.lukewalker.sandbox.plugins.Plugin;

public class Main extends Plugin {

	@Override
	public String getName() {
		return "Test Plugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void load() {		
		EventManager.registerEvent(new PlayerDamageEvent());
		
		final EntityTest entityTest = new EntityTest();
		entityTest.spawn(100, 100);
	}
}
