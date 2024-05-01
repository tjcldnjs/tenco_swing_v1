package ch07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LottoFrame extends JFrame implements ActionListener {

	private JButton button;
	private LottoRandomNumber lottoRandomNumber;
	private boolean isStart = true;
	private boolean color = true;
	private final int NUMBER_DISTANCE = 50;
	private JLabel image1;
	private JLabel image2;
	private JLabel image3;
	private JLabel image4;
	private JLabel image5;
	private JLabel backgorund;

	public LottoFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("Lotto Game");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("Game Start");
		lottoRandomNumber = new LottoRandomNumber();

//		background = new j
		image1 = new JLabel(new ImageIcon("lottoimages/yellow.png"));
		image1.setSize(100, 100);
		image1.setLocation(100, 190);
		image2 = new JLabel(new ImageIcon("lottoimages/blue.png"));
		image2.setSize(100, 100);
		image2.setLocation(300, 120);
		image3 = new JLabel("lottoimages/red.png");
		image4 = new JLabel("lottoimages/gray.png");
		image5 = new JLabel("lottoimages/green.png");
	}

	private void setInitLayout() {
		add(button, BorderLayout.NORTH);
		setVisible(true);
//		add(image1);
	}

	private void addEventListener() {
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("그림을 그려라!");
		// 이벤트가 일어나면 그림을 다시 그려라
		isStart = false;
		repaint(); // 다시 그림을 그려라 요청하는 명령어 // F5
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Font f = new Font("궁서체", Font.BOLD, 20);
		g.setFont(f);
		if (isStart) {
			g.drawString("로또 번호를 클릭하세요", 230, 200);
		} else {
			int[] getNumbers = lottoRandomNumber.createNumber();
			for (int i = 0; i < getNumbers.length; i++) {
				g.drawString(getNumbers[i] + "", 150 + (i * NUMBER_DISTANCE), 200);
				while (color) {
					if (getNumbers[i] > 0 && getNumbers[i] <= 10) {
						add(image1);
					}
					color = false;
				}

			}
		}
//		static class MyImagePanel extends JPanel{
//			
//			public MyImagePanel(){
//				image1 = new ImageIcon("lottoimages/yellow.png").getImage();
//				image2 = new ImageIcon("lottoimages/blue.png").getImage();
//				image3 = new ImageIcon("lottoimages/red.png").getImage();
//				image4 = new ImageIcon("lottoimages/gray.png").getImage();
//				image5 = new ImageIcon("lottoimages/green.png").getImage();
//			}
//			@Override
//			public void paint(Graphics g) {
//			}
	}

	// 코드 테스트
	public static void main(String[] args) {
		new LottoFrame();
	} // end of main

} // end of class
