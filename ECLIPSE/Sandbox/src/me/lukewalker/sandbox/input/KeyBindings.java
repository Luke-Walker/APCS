package me.lukewalker.sandbox.input;

import java.util.HashMap;

public class KeyBindings {

	private static HashMap<Control, Integer> bindings = new HashMap<>();
	
	public static void initBindings() {
		bindings.put(Control.UP, 87);
		bindings.put(Control.DOWN, 83);
		bindings.put(Control.LEFT, 65);
		bindings.put(Control.RIGHT, 68);
		bindings.put(Control.PLUGIN_MANAGER, 80);
	}
	
	public static int getBinding(Control control) { return bindings.get(control); }
	public static void setBinding(Control control, int binding) { bindings.put(control, binding); }
}
