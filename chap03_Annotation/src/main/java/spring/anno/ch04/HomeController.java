package spring.anno.ch04;

import javax.annotation.Resource;

// 사용 클래스
public class HomeController {
	//Main -> HomeController -> Number
	//@Resource 어노테이션은 자바 1.6 이상에서 사용가능
	
	@Resource(name="num1")
	private Number number1;
	
	@Resource(name="num2")
	private Number number2;
	
	@Resource(name="num3")
	private Number number3;
	
	public void display(){
		System.out.println("HomeController 클래스 수행");
		System.out.println("num1 ="+this.number1);
		System.out.println("num2 ="+this.number2);
		System.out.println("num3 ="+this.number3);
	}
	
}
