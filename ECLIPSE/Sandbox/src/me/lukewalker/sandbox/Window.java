package me.lukewalker.sandbox;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	
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
		frame.setVisible(true);
		
		frame.add(INSTANCE);
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		setOpaque(true);
		setBackground(Color.GRAY);
		super.paintComponent(g);
		
		render(g, Game.getInstance().player.getSprite(), Game.getInstance().player.getX(), Game.getInstance().player.getY());
	}
	
	public void render(Graphics g, URL sprite, int x, int y) {
		try {
			g.drawImage(ImageIO.read(sprite), x, y, null);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
