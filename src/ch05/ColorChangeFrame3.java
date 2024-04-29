package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ColorChangeFrame3 extends JFrame implements ActionListener {

	private JPanel panel;
	private JPanel panel2;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;

	public ColorChangeFrame3() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {
		setSize(1000, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panel = new JPanel();
		panel2 = new JPanel();
		panel.setBackground(Color.white);
		button1 = new JButton("red");
		button2 = new JButton("green");
		button3 = new JButton("blue");
		button4 = new JButton("yellow");
		panel2.setBackground(Color.black);
//		button1.setBackground(Color.red);
	}

	public void setInitLayout() {
		add(panel2, BorderLayout.SOUTH);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
	}

	public void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			panel.setBackground(Color.red);
		} else if (e.getSource() == button2) {
			panel.setBackground(Color.green);
		} else if (e.getSource() == button3) {
			panel.setBackground(Color.blue);
		} else if (e.getSource() == button4) {
			panel.setBackground(Color.yellow);
		}
	}

	// 코드 시작점
	public static void main(String[] args) {
		new ColorChangeFrame3();
	}

} // end of class
