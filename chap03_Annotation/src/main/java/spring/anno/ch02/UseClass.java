package spring.anno.ch02;

import org.springframework.beans.factory.annotation.Autowired;

// 사용 클래스
public class UseClass {
	// Main -> UseClass -> ImplClass
	
	@Autowired //2차 : 멤버 앞쪽에 지정
	private ImplClass implClass;
	
	//1차 : 설정메서드 앞쪽에 지정
	//@Autowired //동일타입의 객체를 자동으로 주입(DI)
	/*public void setImplClass(ImplClass implClass){
		this.implClass = implClass;
	}*/
	
	public void display(){
		System.out.println("사용클래스 실행");
		this.implClass.display();
	}
	
	/*
	 * @Autowired 위치
	 *  - 설정메서드 앞쪽에 : 1차
	 *  - 일반메서드 앞쪽에
	 *  - 멤버변수 앞쪽에(선호) : 2차
	 * 
	 */
	
}
