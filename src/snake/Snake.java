package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Snake {
	private int posX;
	private int posY;
	
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	
	private int length;
	private List snakeLength;
	
	public Snake() {
		// initial starting position
		posX = 14 * 30 + 5;
		posY = 14 * 30 + 5;
		
		up = true;
		down = false;
		left = false;
		right = false;
		
		length = 3;
		snakeLength = new ArrayList(length);
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		for(int i = 0; i < length; i++) {
			g.fillRect(posX, posY, 30, 30);
		}
	}
	
	public void move() {
		if(up)
			posY -= 30;
		else if(down)
			posY += 30;
		else if(left)
			posX -= 30;
		else
			posX += 30;
	}
	
	public void moveUp() {
		if(!down) {
			up = true;
			down = false;
			left = false;
			right = false;
		}
	}
	
	public void moveDown() {
		if(!up) {
			up = false;
			down = true;
			left = false;
			right = false;
		}
	}
	
	public void moveLeft() {
		if(!right) {
			up = false;
			down = false;
			left = true;
			right = false;
		}
	}
	
	public void moveRight() {
		if(!left) {
			up = false;
			down = false;
			left = false;
			right = true;
		}
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void grow() {
		length++;
	}
}
