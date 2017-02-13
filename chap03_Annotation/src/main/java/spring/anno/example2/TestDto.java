package spring.anno.example2;

import org.springframework.stereotype.Component;

@Component
public class TestDto {
	
	public void display(){
		System.out.println("TestDto 클래스 호출");
	}
}
