package bubble.test.ex10;

public interface Moveable {

	// public abstract 생략가능
	public abstract void left();

	public abstract void right();

	public abstract void up();

	// 인터페이스 추가 기능 default 사용해보기
	// 인터페이스에 모든 메서드는 추상 메서드 이어야 한다.
	// 단 default 메서드를 제외 하고
	default void down() {
	// 마지막에 default는 세미콜론 추가해야한다.
	};

}
