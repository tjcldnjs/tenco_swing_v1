package bubble.test.ex09;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


// Heap --> 객체 
// -------> new A();
// heap --- (객체 생성) <-- 주소(번지)
// 다른 곳에서 생성되어 있는 객체에 접근할려면 뭐가 필요하다?
// A my주소 = A();
// my주소 <-- 주소값 my주소.add(); 
// 나의 멤버 변수로 (주소값 가지고 있도록 설계)
// BubbleFrame  인스턴스가 생성될 때 멤버 변수로 나의 주소값을 가질 수 있도록 설계 했다.
public class BubbleFrame extends JFrame {

	// 컨텍스트를 생성하는 방법 (셀프 참조)
	BubbleFrame mContext = this;
	// 내 하위에 생성된 객체들에게 나의 주소값을 전달하면 
	// 내 하위 객체들에게 나의 기능을 사용할 수 있게 해준다. 
	
	// BubbleFrame 생성 ---> Player

	private JLabel backgroundMap;
	// 포함관계 - 콤포지션
	private Player player;  // <-- 나를 생성시킨 BubbleFrame 주소값을 같이 던저서 생성 시킨다면 Bf 기능을 호출 할 수 있다. 

	public BubbleFrame() {
		initData();
		setInitLayout();
		addEventListener();
		// Player 백그라운드 서비스 시작
		new Thread(new BackgroundPlayerService(player)).start();
	}

	private void initData() {
		// todo 이미지 변경
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
//		backgroundMap = new JLabel(new ImageIcon("img/test.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Frame --> root Panel
		setContentPane(backgroundMap);
		setSize(1000, 640);

		// mContext --> 참조 타입() --> 주소값에 크기는 기본 4byte 이다.
		player = new Player(mContext);

	}

	private void setInitLayout() {
		// 좌표 값으로 배치
		setLayout(null);
		setResizable(false); // 프레임 조절 불가
		setLocationRelativeTo(null); // JFrame 여러분 모니터 가운데 자동 배치
		setVisible(true);

		add(player);

	}

	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : " + e.getKeyCode());

				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:

					// 왼쪽으로 방향키 누르고 있다면
					// key 이벤트가 계속 <- <- <- <- <-
					// 왼쪽 상태가 아니라면
					// 왼쪽 벽에 충돌 한게 아니라면
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					if (!player.isUp() && !player.isDown()) {
						player.up();

					}
					break;
				case KeyEvent.VK_SPACE:
					// add(new Bubble(player));
					player.attack();
					// 프레임에 컴포넌트를 add 동작은 누구? JFrame --> add() 메서드 이다.
					// 버블 실행시에 끊김 현상이 발생하는 이유는 왜 일까?
					break;
				default:
					break;
				}

			} // end of KeyPressed

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					// 왼쪽으로 가는 상태 멈춤
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					// 오른쪽으로 가는 상태 멈춤
					player.setRight(false);
				default:
					break;
				}

			} // end of KeyReleased
		});

	}
	
	// getter
	public Player getPlayer() {
		return player;
	}

	// 코드 테스트
	public static void main(String[] args) {
		// main 함수를 가지고 있는 클래스는 하위에 생성된 모든 객체들에
		// 주소값을 알고 있다. (중요 !)
		new BubbleFrame();
	}
}
