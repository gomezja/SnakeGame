package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameWorld extends JPanel implements ActionListener, KeyListener {

	private Food foodItem;
	private Snake snake;
	
	private int points;
	private boolean play = true;
	private final int STARTINGSPEED = 200;
	private final int MAXSPEED = 100;
	private int delay = STARTINGSPEED;
	
	private int topBoundary = 120; //60
	private int bottomBoundary = 720; //630
	private int leftBoundary = 15; //0
	private int rightBoundary = 945; //930
	
	private Timer timer;
	
	public GameWorld() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		// create Food object
		foodItem = new Food();
		
		// create Snake object
		snake = new Snake(topBoundary, bottomBoundary, leftBoundary, rightBoundary);
		
		points = 0;
		
		// create timer object and start tick
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		if(play) {
			
			g.setColor(Color.black);
			g.fillRect(0, 0, 1000, 800);
			
			g.setColor(Color.white);
			g.drawRect(15, 15, 960, 90);
			g.drawRect(15, 120, 960, 630);

			g.setFont(new Font("serif", Font.BOLD, 35));
			g.drawString(("Score: " + points + " Speed: " + delay + " Length: " + snake.getLength()), 45, 75);
			
			foodItem.draw((Graphics2D)g);
			snake.draw((Graphics2D)g); 
		} else {
			g.setColor(Color.black);/*
			g.fillRect(237, 250, 500, 400);*/
			g.setColor(Color.white);
			//g.drawRect(237, 250, 500, 400);
			g.setFont(new Font("serif", Font.BOLD, 50));
			g.drawString(("Game Over!"), 350, 450);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(play) {	
			snake.move();
			
			//if((snake.getPosY() < topBoundary || snake.getPosY() > bottomBoundary) || (snake.getPosX() < leftBoundary || snake.getPosX() > rightBoundary)) {
			//play = false;
			//}
			
			repaint();
			
			// if player head and food collide
			if(new Rectangle(snake.getPosX(), snake.getPosY(), 30, 30).intersects(new Rectangle(foodItem.getPosX(), foodItem.getPosY(), 30, 30))) {
				points++;
				snake.grow();
				foodItem.setRandomLoc();
				
				if(delay > MAXSPEED) {
					delay -= 25;
					timer.setDelay(delay);
				}
			}
			
			for(int i = 1; i < snake.getLength(); i++) {
				if(new Rectangle(snake.getPosX(), snake.getPosY(), 30, 30).intersects(new Rectangle(snake.getPosX(i), snake.getPosY(i), 30, 30))) {
					play = false;
				}
			}
		}	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// player moves up
		if(e.getKeyCode() == KeyEvent.VK_W) {
			snake.moveUp();
		}
		
		// player moves down
		if(e.getKeyCode() == KeyEvent.VK_S) {
			snake.moveDown();
		}
		
		// player moves left
		if(e.getKeyCode() == KeyEvent.VK_A) {
			snake.moveLeft();
		}
		
		// player moves right
		if(e.getKeyCode() == KeyEvent.VK_D) {
			snake.moveRight();
		}
		
		// restart game
		if(e.getKeyCode() == KeyEvent.VK_R) {
			foodItem = new Food();
			snake = new Snake(topBoundary, bottomBoundary, leftBoundary, rightBoundary);
			
			points = 0;
			play = true;
			
			delay = STARTINGSPEED;
			timer.setDelay(delay);
			
			repaint();
		}
		
		// exit game
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
