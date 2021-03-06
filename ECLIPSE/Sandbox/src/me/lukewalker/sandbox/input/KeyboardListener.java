package me.lukewalker.sandbox.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import me.lukewalker.sandbox.Game;
import me.lukewalker.sandbox.entities.EntityPlayer;
import me.lukewalker.sandbox.ui.PluginManagerWindow;

public class KeyboardListener implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch (Game.getState()) {
		case LOADING:
			break;
		case TITLE_SCREEN:
			break;
		case IN_GAME:
			if (KeyBindings.getBinding(Control.UP) == key) {
				EntityPlayer.direction = "up";
			} else if (KeyBindings.getBinding(Control.DOWN) == key) {
				EntityPlayer.direction = "down";
			} else if (KeyBindings.getBinding(Control.LEFT) == key) {
				EntityPlayer.direction = "left";
			} else if (KeyBindings.getBinding(Control.RIGHT) == key) {
				EntityPlayer.direction = "right";
			} else if (KeyBindings.getBinding(Control.PLUGIN_MANAGER) == key) {
				new PluginManagerWindow();
			}
		default:
			break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		EntityPlayer.direction = "";
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}
}
