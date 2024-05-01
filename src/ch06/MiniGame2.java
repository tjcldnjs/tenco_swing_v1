package ch06;

import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MiniGame2 extends JFrame {

	private JLabel PlayerR;
	private JLabel backgroundMap;
	private JLabel tempBox;

	private int PlayerX = 50;
	private int PlayerY = 500;
	private final int MOVE_DISTANCE = 60;
	private final int FRAME_WIDTH = 1100;
	private final int FRAME_HEIGHT = 700;
	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 100;

	public MiniGame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("보글보글");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Icon background = new ImageIcon("image2/backgroundMap.png");
		backgroundMap = new JLabel(background);
		backgroundMap.setSize(1000,600);
		backgroundMap.setLocation(0,0);
		
		PlayerR = new JLabel(new ImageIcon("image2/playerR.png"));
		PlayerR.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
		PlayerR.setLocation(PlayerX, PlayerY);
	}

	private void setInitLayout() {
		// 좌표 기반으로 배치관리자 변경
		setLayout(null);
		add(backgroundMap);
		backgroundMap.add(PlayerR);
		setVisible(true);
	}

	private void addEventListener() {
		// jPlayer 객체에게서만 keyListener 동작을 시키고자 한다면
		// 익명 구현클래스로 KeyListener 인터페이스를 재정의 할 수 있다.
		// jPlayer.addKeyListener(this);

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					///////////////
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					PlayerX += MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					PlayerX -= MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					PlayerY -= MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					PlayerY += MOVE_DISTANCE;
				}
				PlayerR.setLocation(PlayerX, PlayerY);
			}
		});

	}

	// 코드 테스트
	public static void main(String[] args) {
		new MiniGame2();
	} // end of main

} // end of class
