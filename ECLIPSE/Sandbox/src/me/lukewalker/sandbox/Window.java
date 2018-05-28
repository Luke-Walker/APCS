package me.lukewalker.sandbox;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import me.lukewalker.sandbox.entities.Entity;

public class Window extends JPanel implements KeyListener {
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
		
		frame.add(INSTANCE);
		
		frame.addKeyListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		setOpaque(true);
		setBackground(Color.GRAY);
		
		for (Entity e : Entity.entities) {
			render(g, e.getSprite(), e.getX(), e.getY());
		}
		
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {		
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}
	
	public void render(Graphics g, URL sprite, int x, int y) {
		try {
			g.drawImage(ImageIO.read(sprite), x, y, null);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
