package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

// 내부 클래스를 활용해서 코드를 완성해주세요
public class PaintFrame extends JFrame{
	
	DrawPanel drawPanel;
	
	public PaintFrame() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setTitle("그림그리는 연습");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		drawPanel = new DrawPanel();
	}
	private void setInitLayout() {
		
		add(drawPanel);
		setVisible(true);
	}
	
	class DrawPanel extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawRect(200, 200, 400, 400);
			g.drawRect(450, 300, 100, 100);
			g.drawLine(450,350, 550, 350);
			g.drawLine(500,300, 500, 400);
			g.drawRect(250, 400, 100, 200);
			g.drawOval(260, 500, 10, 10);
			g.drawLine(180,200,400,50);
			g.drawLine(620,200,400,50);
			g.drawLine(180,200,620,200);
			g.drawOval(700, 50, 50, 50);
			g.drawLine(650,60,690,60);
			g.drawLine(650,100,690,80);
			g.drawLine(690,140,700,110);
			g.drawLine(730,150,735,115);
		}
		
		
	}

}
