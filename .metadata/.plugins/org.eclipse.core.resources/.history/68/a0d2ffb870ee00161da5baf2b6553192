package sample02;

public class Hello {
	/*
	 * class 간의 약결합 예시
	 *  사용클래스 : Hello(중대장)
	 *  인터페이스 : Message(소대장)
	 *  구현클래스 : MessageKr(한국어 인사말), MessageEn(영어 인사말) ->(대원)
	 */
	public static void main(String[] args) {
		
		//다형성 기법
		Message msg = new MessageKr(); //영어 -> 한국어
		msg.sayHello("홍길동");//Hello, Tom! ->안녕하세요, 홍길동씨
		
		//사용 클래스의 코드 변경 범위가 작아진다.
	}

}
