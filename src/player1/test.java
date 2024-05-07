package player1;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class test extends JFrame{
	
	private Player player;
	private JLabel backgroundMap;
	
	public test() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		backgroundMap = new JLabel(new ImageIcon("image2/background_.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(1000,1000);
		

	}
	
	private void setInitLayout() {
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		add(player);
	}
	
	private void addEventListener() {
		
	}
	
	
	
public static void main(String[] args) {
	new test();
}
}
