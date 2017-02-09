package sample03;

//구현 클래스(한국어 인사말)
public class MessageKr implements Message {

	@Override //annotation
	public void sayHello(String name) {
		// 메서드 재정의
		System.out.println("안녕하세요, "+name+"씨");
		
	}

}
