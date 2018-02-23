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
	
	public void setRandomLoc() {
		Random rand = new Random();
		
		posX = rand.nextInt(31) * 30+15;//900;//rand.nextInt(30) * 30; 		// 900 //930+15
		posY = rand.nextInt(20) * 30 + 120;//rand.nextInt(18) * 30 + 60;	// 600 //600+120
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		g.drawOval(posX, posY, 30, 30);
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
}
