package snake;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame screen = new JFrame();
		GameWorld game = new GameWorld();
		
		screen.setBounds(10, 10, 915, 950);
		//screen.setBackground(Color.black);
		screen.setTitle("Snake Game by Jesus Gomez");
		screen.setResizable(false);
		screen.setVisible(true);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		screen.add(game);
	}

}
