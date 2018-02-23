package snake;

import javax.swing.JFrame;

public class Start {

	public static void main(String[] args) {
		JFrame screen = new JFrame();
		GameWorld game = new GameWorld();
		
		screen.setBounds(0, 0, 1000, 800);
		screen.setTitle("Snake Game by Jesus Gomez");
		screen.setResizable(false);
		screen.setVisible(true);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		screen.add(game);
	}

}
	