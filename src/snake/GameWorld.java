package snake;

import java.awt.Color;
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
	
	private Timer timer;
	
	public GameWorld() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		// create Food object
		foodItem = new Food();
		
		// create Snake object
		snake = new Snake();
		
		points = 0;
		
		// create timer object and start tick
		timer = new Timer(500, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		if(play) {
			g.setColor(Color.black);
			g.fillRect(0, 0, 915, 950);
			
			foodItem.draw((Graphics2D)g);
			snake.draw((Graphics2D)g); 
		} else {
			g.setColor(Color.red);
			g.fillRect(0, 0, 915, 950);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(play) {
			snake.move();
			
			if((snake.getPosX() < 5 || snake.getPosX() > (29 * 30 + 5)) || (snake.getPosY() < 5 || snake.getPosY() > (29 * 30 + 5))) {
				play = false;
			}
			
			repaint();
			
			// if player head and food collide
			if(new Rectangle(snake.getPosX(), snake.getPosY(), 30, 30).intersects(new Rectangle(foodItem.getPosX(), foodItem.getPosY(), 30, 30))) {
				points++;
				snake.grow();
				foodItem.setRandomLoc();
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
			snake = new Snake();
			
			points = 0;
			play = true;
			
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
