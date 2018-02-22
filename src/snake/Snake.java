package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Snake {
	private int posX;
	private int posY;
	
	private int growPosX;
	private int growPosY;
	
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	
	private int length;
	private int[][] snakeCell;
	
	public Snake() {
		// initial starting head position
		posX = 450 + 15;
		posY = 450 + 120;
		
		
		
		up = true;
		down = false;
		left = false;
		right = false;
		
		length = 3;
		snakeCell = new int[10][10];
		
		for(int i = 0; i < length; i++) {
			snakeCell[i][0] = posX;
			snakeCell[i][1] = posY + 30 * i;
		}
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		
		// draw all snake cells
		for(int i = 0; i < length; i++) {
			g.fillRect(snakeCell[i][0], snakeCell[i][1], 30, 30);
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
		
		// move all snake body cells
		for(int i = length - 1; i > 0; i--) {
			snakeCell[i][0] = snakeCell[i - 1][0];
			snakeCell[i][1] = snakeCell[i - 1][1];
		}
		
		// set snake head new location
		snakeCell[0][0] = posX;
		snakeCell[0][1] = posY;
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
}
