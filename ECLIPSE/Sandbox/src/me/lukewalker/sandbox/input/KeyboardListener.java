package me.lukewalker.sandbox.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import me.lukewalker.sandbox.Game;
import me.lukewalker.sandbox.entities.Entity;

public class KeyboardListener implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		System.out.println("TEST: " + key);
		System.out.println("BINDING: " + KeyBindings.getBinding(Control.UP));
		switch (Game.getState()) {
		case LOADING:
			break;
		case TITLE_SCREEN:
			break;
		case IN_GAME:
			final Entity player = Game.player;
			if (KeyBindings.getBinding(Control.UP) == key) {
				player.move("up");
			} else if (KeyBindings.getBinding(Control.DOWN) == key) {
				player.move("down");
			} else if (KeyBindings.getBinding(Control.LEFT) == key) {
				player.move("left");
			} else if (KeyBindings.getBinding(Control.RIGHT) == key) {
				player.move("right");
			}
		default:
			break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}
}
