package player1;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel{

	private int x;
	private int y;
	private ImageIcon playerR, playerL, playerU, playerD;
	
	public Player() {
	}
	
	private void initData() {
		playerR = new ImageIcon("image2/bazzi_right.png");
		playerL = new ImageIcon("image2/bazzi_left.png");
		playerU = new ImageIcon("image2/bazzi_back.png");
		playerD = new ImageIcon("image2/bazzi.png");
		
		setIcon(playerD);
		setSize(100, 100);
		setLocation(50,50);
	}
	
	
	
}
