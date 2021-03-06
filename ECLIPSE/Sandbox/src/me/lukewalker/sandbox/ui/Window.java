package me.lukewalker.sandbox.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import me.lukewalker.sandbox.Game;
import me.lukewalker.sandbox.entities.Entity;
import me.lukewalker.sandbox.input.KeyboardListener;

public class Window extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private static final int HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	private Window() {}
	private static Window INSTANCE = null;
	public static Window getInstance() {
		if (INSTANCE == null) INSTANCE = new Window();
		return INSTANCE;
	}
	
	public void display() {
		JFrame frame = new JFrame(Game.TITLE + " | " + Game.VERSION);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		
		frame.add(INSTANCE);
		
		frame.addKeyListener(new KeyboardListener());
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		setOpaque(true);
		setBackground(Color.GRAY);
		
		switch (Game.getState()) {
		case TITLE_SCREEN:
			break;
		case IN_GAME:
			for (Entity e : Entity.entities) {
				render(g, e.getSprite(), e.getX(), e.getY(), e.getWidth(), e.getHeight());
			}
			break;
		default:
			break;
		}
		
		repaint();
	}
	
	public void render(Graphics g, URL sprite, int x, int y, int width, int height) {
		try {
			g.drawImage(ImageIO.read(sprite), x, y, width, height, null);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
