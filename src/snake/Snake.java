package snake;

import java.awt.Color;
import java.awt.Graphics2D;

public class Snake {
	private int posX;
	private int posY;
	
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	
	private int topBoundary;
	private int bottomBoundary;
	private int leftBoundary;
	private int rightBoundary;
	
	private int length;
	private int capacity;
	private int[][] snakeCell;
	
	private int front;
	private int end;
	private int[][] foodConsumed;
	
	public Snake(int topBoundary, int bottomBoundary, int leftBoundary, int rightBoundary) {
		this.topBoundary = topBoundary;
		this.bottomBoundary = bottomBoundary;
		this.leftBoundary = leftBoundary;
		this.rightBoundary = rightBoundary;
		
		// initial starting head position
		posX = 450 + 15;
		posY = 450 + 120;
		
		// initial direction
		up = true;
		down = false;
		left = false;
		right = false;
		
		// 2D array for snake
		length = 3;
		capacity = 10;
		snakeCell = new int[capacity][capacity];
		
		// queue for food consumed
		front = 0;
		end = 0;
		foodConsumed = new int[10][10];
		
		// set location of snake cells
		for(int i = 0; i < length; i++) {
			snakeCell[i][0] = posX;
			snakeCell[i][1] = posY + 30 * i;
		}
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.white);

		// draw all snake cells
		for(int i = 0; i < length; i++)
				g.drawRoundRect(snakeCell[i][0], snakeCell[i][1], 30, 30, 10, 10);
	}
	
	public void move() {
		if(up) {
			if((posY - 30) < topBoundary)
				posY = bottomBoundary;
			else
				posY -= 30;
		}
		else if(down) {
			if((posY + 30) > bottomBoundary)
				posY = topBoundary;
			else
				posY += 30;
		}
		else if(left) {
			if((posX - 30) < leftBoundary)
				posX = rightBoundary;
			else
				posX -= 30;
		}
		else {
			if((posX + 30) > rightBoundary)
				posX = leftBoundary;
			else
				posX += 30;
		}
		
		// move all snake body cells
		for(int i = length - 1; i > 0; i--) {
			snakeCell[i][0] = snakeCell[i - 1][0];
			snakeCell[i][1] = snakeCell[i - 1][1];
		}
		
		// set snake head new location
		snakeCell[0][0] = posX;
		snakeCell[0][1] = posY;

		// check if eaten food has reached tail
		if(front != end && (snakeCell[length - 1][0] == foodConsumed[front][0] && snakeCell[length - 1][1] == foodConsumed[front][1])) {
			length++;
			
			snakeCell[length - 1][0] = foodConsumed[front][0];
			snakeCell[length - 1][1] = foodConsumed[front][1];
			
			if((front + 1) > 9)
				front = 0;
			else
				front++;
			
			if((length + 1) >= capacity)
				resize(10);
		}
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
	
	public int getPosX(int index) {
		return snakeCell[index][0];
	}
	
	public int getPosY(int index) {
		return snakeCell[index][1];
	}
	
	public void grow() {
		foodConsumed[end][0] = posX;
		foodConsumed[end][1] = posY;
		
		if((end + 1) > 9)
			end = 0;
		else
			end++;
	}
	
	public int getLength() {
		return length;
	}
	
	private void resize(int moreSpace) {
		int[][] newArray = new int[capacity + moreSpace][capacity + moreSpace];
		
		
		for(int i = 0; i < length; i++) {
			newArray[i][0] = snakeCell[i][0];
			newArray[i][1] = snakeCell[i][1];
		}
		
		snakeCell = newArray;
		capacity += moreSpace;
	}
}
