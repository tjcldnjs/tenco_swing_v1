package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChangeFrame2 extends JFrame implements ActionListener {

	private JPanel panel;
	private JButton button1;
	private JButton button2;

	public ColorChangeFrame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); // BoderLayout
		panel = new JPanel();
		panel.setBackground(Color.yellow);
		button1 = new JButton("click1");
		button2 = new JButton("click2");
	}

	private void setInitLayout() {
		add(button1, BorderLayout.NORTH);
		add(button2, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
	}

	// 이 메서드에 책임은 이벤트 리스너만 등록
	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	// 콜백 메서드이다.
	// 오버라이드 : 이벤트가 일어나면 호출되어지는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(e.getSource().toString());
		if (e.getSource() == button1) {
			System.out.println("버튼1이 눌러짐");
			panel.setBackground(Color.black);
		} else if (e.getSource() == button2) {
			System.out.println("버튼 2가 눌러짐");
			panel.setBackground(Color.blue);
		}
	}

	// 코드 테스트
	public static void maㅇin(String[] args) {
		new ColorChangeFrame2();

	}
 
} // end of class
