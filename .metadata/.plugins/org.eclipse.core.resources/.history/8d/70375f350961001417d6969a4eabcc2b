package dev.bottle.mining;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	volatile boolean running = false;
	
	final int size = 320;
	
	final int scale = 2;
	
	BufferedImage image = new BufferedImage(size,(size/4)*3,BufferedImage.TYPE_INT_RGB);
	
	public static void main(String[] args)
	{
		Thread t = new Thread(new Game());
		t.start();
	}
	
	public Game()
	{
		
	}

	@Override
	public void run() {
		
		while(running)
		{
			
		}
		
	}
	
	@Override
	public void paint(Graphics g)
	{
		
	}
	
	@Override
	public void update(Graphics g)
	{
		paint(image.createGraphics());
		g.drawImage(image,0,0,size*scale,(size/4)*3*scale,null);
	}
	
}
