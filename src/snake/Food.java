package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Food {

	private int posX;
	private int posY;
	
	public Food() {
		setRandomLoc();
	}
	
	private void setRandomLoc() {
		Random rand = new Random();
		
		posX = rand.nextInt(30) * 30 + 5;
		posY = rand.nextInt(30) * 30 + 5;
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		g.fillRect(posX, posY, 30, 30);
	}
}
