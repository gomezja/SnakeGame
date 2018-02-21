package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameWorld extends JPanel implements ActionListener, KeyListener {

	private Food foodItem;
	//private Snake snake;
	
	private Timer timer;
	
	public GameWorld() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		// create Food object
		foodItem = new Food();
		
		// create Snake object
		//snake = new Snake();
		
		// create timer object and start tick
		timer = new Timer(8, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 915, 950);
		
		foodItem.draw((Graphics2D)g);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// restart game
		if(e.getKeyCode() == KeyEvent.VK_R) {
			foodItem = new Food();
			
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
