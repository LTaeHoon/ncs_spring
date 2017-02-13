package spring.anno.ch01;

import org.springframework.beans.factory.annotation.Required;

// @Required


public class RequiredClass {
	private int num; // num = 0
	/*@Required 역할 : 반드시 num의 초기화를 해야 한다는 annotation (필수요구사항)*/
	@Required
	public void setNum(int num){
		this.num = num;
	}

	public void display(){
		System.out.println("num="+this.num);
	}
	
}
