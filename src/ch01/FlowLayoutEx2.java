package ch01;

import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// Swing -> 배치 관리자 : FlowLayout
// 컴포넌트들을 (버튼, 라벨) 등을 수평, 수직으로 배치를 해주는 클래스이다..
public class FlowLayoutEx2 extends JFrame {

	// 배열 활용 - 하나의 변수로 여러개 통으로 관리하고 싶다면 배열을 써보자.

	private JButton[] buttons;

	// 생성자
	public FlowLayoutEx2() {
		super.setTitle("FlowLayout 연습");
		super.setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initData();
		setInitLayout();
	}

	// 멤버 변수를 초기화 하는 기능(값을 넣다)
	public void initData() {

		buttons = new JButton[6]; // [][][][][] 공간만 선언

		// 반복문의 활용
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("[ buttons" + (i + 1) + " ]");
		}
	}

	// 컴포넌트들을 배치하는 기능
	public void setInitLayout() {
		super.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 50)); // 배치관리자 --> FlowLayout
		for(int i = 0; i < buttons.length; i++) {
			super.add(buttons[i]);
		}
	}

	// 코드 테스트
	public static void main(String[] args) {
		new FlowLayoutEx2(); // <---- 익명 클래스 : 다시 접근해서 사용할 일 없으면 사용함.

	} // end of main

} // end of class
