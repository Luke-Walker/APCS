package me.lukewalker.plugin;

import me.lukewalker.plugin.entities.EntityFragger;
import me.lukewalker.sandbox.plugins.Plugin;

public class Main extends Plugin {

	@Override
	public String getName() {
		return "Plugin 2";
	}

	@Override
	public String getVersion() {
		return "v2.0";
	}

	@Override
	public void load() {
		final EntityFragger entityFragger = new EntityFragger();
		entityFragger.spawn(200, 200);
	}
}
